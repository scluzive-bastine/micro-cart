package com.pm.userservice.mapper;

import com.pm.userservice.dto.ClientRequestDTO;
import com.pm.userservice.dto.ClientResponseDTO;
import com.pm.userservice.model.Client;

public class ClientMapper {

    public static ClientResponseDTO toDTO(Client client) {
        ClientResponseDTO clientDTO = new ClientResponseDTO();
        clientDTO.setId(client.getId().toString());
        clientDTO.setName(client.getName());
        clientDTO.setEmail(client.getEmail());
        clientDTO.setBio(client.getBio());
        clientDTO.setCreatedAt(client.getCreatedAt().toString());
        clientDTO.setUpdatedAt(client.getUpdatedAt().toString());
        return clientDTO;
    }

    public static Client toModel(ClientRequestDTO clientRequestDTO) {
        Client client = new Client();
        client.setName(clientRequestDTO.getName());
        client.setEmail(clientRequestDTO.getEmail());
        client.setBio(clientRequestDTO.getBio());
        return client;
    }
}
