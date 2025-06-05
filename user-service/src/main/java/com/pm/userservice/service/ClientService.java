package com.pm.userservice.service;

import com.pm.userservice.dto.ClientRequestDTO;
import com.pm.userservice.dto.ClientResponseDTO;
import com.pm.userservice.exception.ClientNotFoundException;
import com.pm.userservice.exception.EmailAlreadyExistsException;
import com.pm.userservice.grpc.BillingServiceGrpcClient;
import com.pm.userservice.kafka.KafkaProducer;
import com.pm.userservice.mapper.ClientMapper;
import com.pm.userservice.model.Client;
import com.pm.userservice.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final BillingServiceGrpcClient billingServiceGrpcClient;
    private final KafkaProducer kafkaProducer;

    public ClientService(ClientRepository clientRepository, BillingServiceGrpcClient billingServiceGrpcClient, KafkaProducer kafkaProducer) {
        this.clientRepository = clientRepository;
        this.billingServiceGrpcClient = billingServiceGrpcClient;
        this.kafkaProducer = kafkaProducer;
    }


    public List<ClientResponseDTO> getUsers() {
        List<Client> clients = clientRepository.findAll();

        return clients.stream().map(ClientMapper::toDTO).toList();
    }

    public ClientResponseDTO createClient(ClientRequestDTO clientRequestDTO) {
        if(clientRepository.existsByEmail(clientRequestDTO.getEmail())) {
            throw new EmailAlreadyExistsException(
                    "A client with this email " + "already exists"
                            + clientRequestDTO.getEmail());
        }
        Client newClient = clientRepository.save(ClientMapper.toModel(clientRequestDTO));
        billingServiceGrpcClient.createBillingAccount(newClient.getId().toString(), newClient.getName(), newClient.getEmail());


        kafkaProducer.sendEvent(newClient);

        return ClientMapper.toDTO(newClient);
    }

    public ClientResponseDTO updateClient(UUID id, ClientRequestDTO clientRequestDTO) {

        Client client = clientRepository.findById(id).orElseThrow(
                () -> new ClientNotFoundException("Client with id " + id + " not found")
        );

        if(clientRepository.existsByEmailAndIdNot(client.getEmail(), id)) {
            throw new EmailAlreadyExistsException(
                    "A client with this email " + "already exists" + clientRequestDTO.getEmail()
            );
        }

        client.setName(clientRequestDTO.getName());
        client.setEmail(clientRequestDTO.getEmail());
        client.setBio(clientRequestDTO.getBio());

        Client updatedClient = clientRepository.save(client);
        return ClientMapper.toDTO(updatedClient);
    }

    public void deleteClient(UUID id) {
       clientRepository.deleteById(id);
    }
}
