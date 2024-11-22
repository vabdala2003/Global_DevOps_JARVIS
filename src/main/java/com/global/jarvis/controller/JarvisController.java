package com.global.jarvis.controller;

import com.global.jarvis.dto.ClienteRequest;
import com.global.jarvis.dto.ClienteResponse;
import com.global.jarvis.dto.ProdutoRequest;
import com.global.jarvis.dto.ProdutoResponse;
import com.global.jarvis.dto.TelefoneRequest;
import com.global.jarvis.dto.TelefoneResponse;
import com.global.jarvis.service.ClienteService;
import com.global.jarvis.service.ProdutoService;
import com.global.jarvis.service.TelefoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class JarvisController {

    @Autowired
    private TelefoneService telefoneService;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/telefones")
    public ResponseEntity<List<TelefoneResponse>> listarTelefones() {
        List<TelefoneResponse> telefones = telefoneService.listarTelefones();
        if (telefones.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(telefones);
    }

    @GetMapping("/telefones/{idTelefone}")
    public ResponseEntity<TelefoneResponse> obterTelefone(@PathVariable Long idTelefone) {
        TelefoneResponse telefoneResponse = telefoneService.obterTelefone(idTelefone);
        if (telefoneResponse == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(telefoneResponse);
    }

    @PostMapping("/telefones")
    public ResponseEntity<TelefoneResponse> cadastrarTelefone(@RequestBody TelefoneRequest telefoneRequest) {
        TelefoneResponse telefoneResponse = telefoneService.cadastrarTelefone(telefoneRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(telefoneResponse);
    }

    @PutMapping("/telefones/{idTelefone}")
    public ResponseEntity<TelefoneResponse> atualizarTelefone(@PathVariable Long idTelefone, @RequestBody TelefoneRequest telefoneRequest) {
        TelefoneResponse telefoneResponse = telefoneService.atualizarTelefone(idTelefone, telefoneRequest);
        if (telefoneResponse == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(telefoneResponse);
    }

    @DeleteMapping("/telefones/{idTelefone}")
    public ResponseEntity<Void> deletarTelefone(@PathVariable Long idTelefone) {
        telefoneService.deletarTelefone(idTelefone);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/produtos")
    public ResponseEntity<List<ProdutoResponse>> listarProdutos() {
        List<ProdutoResponse> produtos = produtoService.listarProdutos();
        if (produtos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/produtos/{idProduto}")
    public ResponseEntity<ProdutoResponse> obterProduto(@PathVariable Long idProduto) {
        ProdutoResponse produtoResponse = produtoService.obterProduto(idProduto);
        if (produtoResponse == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produtoResponse);
    }

    @PostMapping("/produtos")
    public ResponseEntity<ProdutoResponse> cadastrarProduto(@RequestBody ProdutoRequest produtoRequest) {
        ProdutoResponse produtoResponse = produtoService.cadastrarProduto(produtoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoResponse);
    }

    @PutMapping("/produtos/{idProduto}")
    public ResponseEntity<ProdutoResponse> atualizarProduto(@PathVariable Long idProduto, @RequestBody ProdutoRequest produtoRequest) {
        ProdutoResponse produtoResponse = produtoService.atualizarProduto(idProduto, produtoRequest);
        if (produtoResponse == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produtoResponse);
    }

    @DeleteMapping("/produtos/{idProduto}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long idProduto) {
        boolean deleted = produtoService.deletarProduto(idProduto);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/clientes")
    public ResponseEntity<List<ClienteResponse>> listarClientes() {
        List<ClienteResponse> clientes = clienteService.listarClientes();
        if (clientes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/clientes/{idCliente}")
    public ResponseEntity<ClienteResponse> obterCliente(@PathVariable Long idCliente) {
        ClienteResponse clienteResponse = clienteService.obterCliente(idCliente);
        if (clienteResponse == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clienteResponse);
    }

    @PostMapping("/clientes")
    public ResponseEntity<ClienteResponse> cadastrarCliente(@RequestBody ClienteRequest clienteRequest) {
        ClienteResponse clienteResponse = clienteService.cadastrarCliente(clienteRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteResponse);
    }

    @PutMapping("/clientes/{idCliente}")
    public ResponseEntity<ClienteResponse> atualizarCliente(@PathVariable Long idCliente, @RequestBody ClienteRequest clienteRequest) {
        ClienteResponse clienteResponse = clienteService.atualizarCliente(idCliente, clienteRequest);
        if (clienteResponse == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clienteResponse);
    }

    @DeleteMapping("/clientes/{idCliente}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long idCliente) {
        boolean deleted = clienteService.deletarCliente(idCliente);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
