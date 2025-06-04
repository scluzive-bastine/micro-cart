package com.pm.userservice.service;

import com.pm.userservice.dto.ClientResponseDTO;
import com.pm.userservice.mapper.ClientMapper;
import com.pm.userservice.model.Client;
import com.pm.userservice.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<ClientResponseDTO> getUsers() {
        List<Client> clients = clientRepository.findAll();

        return clients.stream().map(ClientMapper::toDTO).toList();
    }
}
