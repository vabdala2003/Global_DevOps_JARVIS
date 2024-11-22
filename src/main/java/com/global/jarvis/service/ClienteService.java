package com.global.jarvis.service;

import com.global.jarvis.dto.ClienteRequest;
import com.global.jarvis.dto.ClienteResponse;
import com.global.jarvis.model.Cliente;
import com.global.jarvis.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteResponse> listarClientes() {
        return clienteRepository.findAll()
                .stream()
                .map(ClienteResponse::new)
                .collect(Collectors.toList());
    }

    public ClienteResponse cadastrarCliente(ClienteRequest clienteRequest) {
        try {
            Cliente cliente = new Cliente(clienteRequest);
            clienteRepository.save(cliente);
            return new ClienteResponse(cliente);
        } catch (Exception e) {
            throw new IllegalStateException("Erro ao cadastrar cliente: " + e.getMessage(), e);
        }
    }

    public ClienteResponse atualizarCliente(Long idCliente, ClienteRequest clienteRequest) {
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));

        cliente.setNome(clienteRequest.getNome());
        cliente.setCpf(clienteRequest.getCpf());
        cliente.setRg(clienteRequest.getRg());
        cliente.setDataNascimento(LocalDate.parse(clienteRequest.getDataNascimento()));
        cliente.setSenha(clienteRequest.getSenha());

        clienteRepository.save(cliente);
        return new ClienteResponse(cliente);
    }

    public boolean deletarCliente(Long idCliente) {
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
        clienteRepository.delete(cliente);
        return true;
    }

    public ClienteResponse obterCliente(Long idCliente) {
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
        return new ClienteResponse(cliente);
    }
}
