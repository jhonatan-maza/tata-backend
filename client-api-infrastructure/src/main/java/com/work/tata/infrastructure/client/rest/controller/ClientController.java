package com.work.tata.infrastructure.client.rest.controller;

import com.work.tata.application.client.port.ClientInteractionPort;
import com.work.tata.infrastructure.client.rest.dto.request.ClientCreateRequest;
import com.work.tata.infrastructure.client.rest.dto.response.ClientResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("client")
public class ClientController {
    private final ClientInteractionPort port;

    public ClientController(ClientInteractionPort port) {
        this.port = port;
    }

    @PostMapping()
    public ResponseEntity<ClientResponse> create(@RequestBody ClientCreateRequest clientToCreate) {
        var client= port.create(ClientCreateRequest.toDomain(clientToCreate));
        return ResponseEntity.status(HttpStatus.CREATED).body(ClientResponse.toResponse(client));
    }

    @GetMapping()
    public List<ClientResponse> getAll() {
        return ClientResponse.toResponse(port.findAll());
    }

}
