package com.global.jarvis.service;

import com.global.jarvis.dto.TelefoneRequest;
import com.global.jarvis.dto.TelefoneResponse;
import com.global.jarvis.model.Cliente;
import com.global.jarvis.model.Telefone;
import com.global.jarvis.repository.TelefoneRepository;
import com.global.jarvis.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TelefoneService {

    private static final Logger logger = LoggerFactory.getLogger(TelefoneService.class);

    @Autowired
    private TelefoneRepository telefoneRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    // Método para listar todos os telefones
    public List<TelefoneResponse> listarTelefones() {
        logger.info("Listando todos os telefones...");
        List<Telefone> telefones = telefoneRepository.findAll();
        return telefones.stream()
                .map(TelefoneResponse::new)
                .collect(Collectors.toList());
    }

    // Método para cadastrar um novo telefone
    public TelefoneResponse cadastrarTelefone(TelefoneRequest telefoneRequest) {
        logger.info("Cadastrando um novo telefone para o cliente com ID: {}", telefoneRequest.getIdCliente());

        Cliente cliente = clienteRepository.findById(telefoneRequest.getIdCliente())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));

        Telefone telefone = new Telefone(telefoneRequest, cliente);

        try {
            telefoneRepository.save(telefone);
            logger.info("Telefone cadastrado com sucesso para o cliente ID: {}", telefoneRequest.getIdCliente());
            return new TelefoneResponse(telefone);
        } catch (Exception e) {
            logger.error("Erro ao salvar o telefone no banco de dados: {}", e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao cadastrar telefone");
        }
    }

    // Método para atualizar um telefone existente
    @Transactional
    public TelefoneResponse atualizarTelefone(Long idTelefone, TelefoneRequest telefoneRequest) {
        logger.info("Atualizando telefone com ID: {}", idTelefone);

        Telefone telefone = telefoneRepository.findById(idTelefone)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Telefone não encontrado"));

        telefone.setNrTelefone(telefoneRequest.getNumero());
        telefone.setNrDdd(telefoneRequest.getDdd());
        telefone.setDsTelefone(telefoneRequest.getDescricao());

        try {
            telefoneRepository.save(telefone);
            logger.info("Telefone com ID {} atualizado com sucesso.", idTelefone);
            return new TelefoneResponse(telefone);
        } catch (Exception e) {
            logger.error("Erro ao atualizar o telefone no banco de dados: {}", e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao atualizar telefone");
        }
    }

    // Método para deletar um telefone pelo id
    public void deletarTelefone(Long idTelefone) {
        logger.info("Deletando telefone com ID: {}", idTelefone);

        if (!telefoneRepository.existsById(idTelefone)) {
            logger.error("Telefone com ID {} não encontrado.", idTelefone);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Telefone não encontrado");
        }

        try {
            telefoneRepository.deleteById(idTelefone);
            logger.info("Telefone com ID {} deletado com sucesso.", idTelefone);
        } catch (Exception e) {
            logger.error("Erro ao deletar o telefone: {}", e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao deletar telefone");
        }
    }

    // Método para obter um telefone pelo id
    public TelefoneResponse obterTelefone(Long idTelefone) {
        logger.info("Buscando telefone com ID: {}", idTelefone);

        Telefone telefone = telefoneRepository.findById(idTelefone)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Telefone não encontrado"));

        return new TelefoneResponse(telefone);
    }
}
