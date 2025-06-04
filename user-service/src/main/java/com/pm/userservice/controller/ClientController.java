package com.pm.userservice.controller;

import com.pm.userservice.dto.ClientResponseDTO;
import com.pm.userservice.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<List<ClientResponseDTO>> getAllUsers() {
        List<ClientResponseDTO> users = clientService.getUsers();
        return ResponseEntity.ok(users);
    }
}
