package com.global.jarvis.controller;

import com.global.jarvis.dto.ClienteRequest;
import com.global.jarvis.dto.ClienteResponse;
import com.global.jarvis.model.Cliente;
import com.global.jarvis.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class JarvisControllerTest {

    @InjectMocks
    private JarvisController jarvisController;

    @Mock
    private ClienteService clienteService;

    private ClienteRequest clienteRequest;
    private ClienteResponse clienteResponse;

    @BeforeEach
    void setUp() {
        clienteRequest = new ClienteRequest();
        clienteRequest.setNome("Vinícius");
        clienteRequest.setCpf("12345678901");
        clienteRequest.setRg("MG123456");
        clienteRequest.setDataNascimento("2000-01-01");
        clienteRequest.setSenha("senha123");

        Cliente cliente = new Cliente();
        cliente.setIdCliente(1L);
        cliente.setNome("Vinícius");
        cliente.setCpf("12345678901");
        cliente.setRg("MG123456");
        cliente.setDataNascimento(LocalDate.parse("2000-01-01"));
        cliente.setSenha("senha123");

        clienteResponse = new ClienteResponse(cliente);
    }

    @Test
    void testObterCliente() {
        when(clienteService.obterCliente(1L)).thenReturn(clienteResponse);

        ResponseEntity<ClienteResponse> response = jarvisController.obterCliente(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals(clienteResponse.getNome(), response.getBody().getNome());
    }

    @Test
    void testCadastrarCliente() {
        when(clienteService.cadastrarCliente(Mockito.any(ClienteRequest.class))).thenReturn(clienteResponse);

        ResponseEntity<ClienteResponse> response = jarvisController.cadastrarCliente(clienteRequest);

        assertEquals(201, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals(clienteResponse.getNome(), response.getBody().getNome());
    }
}
