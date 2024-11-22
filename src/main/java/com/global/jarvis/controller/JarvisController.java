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

    // ========================== TELEFONES ============================

    // Endpoint para listar todos os telefones
    @GetMapping("/telefones")
    public ResponseEntity<List<TelefoneResponse>> listarTelefones() {
        List<TelefoneResponse> telefones = telefoneService.listarTelefones();
        if (telefones.isEmpty()) {
            return ResponseEntity.noContent().build(); // Retorna 204 se não houver telefones
        }
        return ResponseEntity.ok(telefones);
    }

    // Endpoint para listar um telefone pelo id
    @GetMapping("/telefones/{idTelefone}")
    public ResponseEntity<TelefoneResponse> obterTelefone(@PathVariable Long idTelefone) {
        TelefoneResponse telefoneResponse = telefoneService.obterTelefone(idTelefone);
        if (telefoneResponse == null) {
            return ResponseEntity.notFound().build(); // Retorna 404 se não encontrar
        }
        return ResponseEntity.ok(telefoneResponse);
    }

    // Endpoint para cadastrar um novo telefone
    @PostMapping("/telefones")
    public ResponseEntity<TelefoneResponse> cadastrarTelefone(@RequestBody TelefoneRequest telefoneRequest) {
        TelefoneResponse telefoneResponse = telefoneService.cadastrarTelefone(telefoneRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(telefoneResponse); // Retorna HTTP 201 (Created)
    }

    // Endpoint para atualizar um telefone existente
    @PutMapping("/telefones/{idTelefone}")
    public ResponseEntity<TelefoneResponse> atualizarTelefone(@PathVariable Long idTelefone, @RequestBody TelefoneRequest telefoneRequest) {
        TelefoneResponse telefoneResponse = telefoneService.atualizarTelefone(idTelefone, telefoneRequest);
        if (telefoneResponse == null) {
            return ResponseEntity.notFound().build(); // Retorna 404 se não encontrar
        }
        return ResponseEntity.ok(telefoneResponse);
    }

    // Endpoint para deletar um telefone pelo id
    @DeleteMapping("/telefones/{idTelefone}")
    public ResponseEntity<Void> deletarTelefone(@PathVariable Long idTelefone) {
        telefoneService.deletarTelefone(idTelefone);
        return ResponseEntity.noContent().build(); // Retorna 204 (No Content) após sucesso
    }

    // ========================== PRODUTOS ============================

    // Endpoint para listar todos os produtos
    @GetMapping("/produtos")
    public ResponseEntity<List<ProdutoResponse>> listarProdutos() {
        List<ProdutoResponse> produtos = produtoService.listarProdutos();
        if (produtos.isEmpty()) {
            return ResponseEntity.noContent().build(); // Retorna 204 se não houver produtos
        }
        return ResponseEntity.ok(produtos);
    }

    // Endpoint para listar um produto pelo id
    @GetMapping("/produtos/{idProduto}")
    public ResponseEntity<ProdutoResponse> obterProduto(@PathVariable Long idProduto) {
        ProdutoResponse produtoResponse = produtoService.obterProduto(idProduto);
        if (produtoResponse == null) {
            return ResponseEntity.notFound().build(); // Retorna 404 se não encontrar
        }
        return ResponseEntity.ok(produtoResponse);
    }

    // Endpoint para cadastrar um novo produto
    @PostMapping("/produtos")
    public ResponseEntity<ProdutoResponse> cadastrarProduto(@RequestBody ProdutoRequest produtoRequest) {
        ProdutoResponse produtoResponse = produtoService.cadastrarProduto(produtoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoResponse); // Retorna HTTP 201 (Created)
    }

    // Endpoint para atualizar um produto existente
    @PutMapping("/produtos/{idProduto}")
    public ResponseEntity<ProdutoResponse> atualizarProduto(@PathVariable Long idProduto, @RequestBody ProdutoRequest produtoRequest) {
        ProdutoResponse produtoResponse = produtoService.atualizarProduto(idProduto, produtoRequest);
        if (produtoResponse == null) {
            return ResponseEntity.notFound().build(); // Retorna 404 se não encontrar
        }
        return ResponseEntity.ok(produtoResponse);
    }

    // Endpoint para deletar um produto pelo id
    @DeleteMapping("/produtos/{idProduto}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long idProduto) {
        boolean deleted = produtoService.deletarProduto(idProduto);
        if (!deleted) {
            return ResponseEntity.notFound().build(); // Retorna 404 se o produto não for encontrado
        }
        return ResponseEntity.noContent().build(); // Retorna 204 (No Content) após sucesso
    }

    // ========================== CLIENTES ============================

    // Endpoint para listar todos os clientes
    @GetMapping("/clientes")
    public ResponseEntity<List<ClienteResponse>> listarClientes() {
        List<ClienteResponse> clientes = clienteService.listarClientes();
        if (clientes.isEmpty()) {
            return ResponseEntity.noContent().build(); // Retorna 204 se não houver clientes
        }
        return ResponseEntity.ok(clientes);
    }

    // Endpoint para listar um cliente pelo id
    @GetMapping("/clientes/{idCliente}")
    public ResponseEntity<ClienteResponse> obterCliente(@PathVariable Long idCliente) {
        ClienteResponse clienteResponse = clienteService.obterCliente(idCliente);
        if (clienteResponse == null) {
            return ResponseEntity.notFound().build(); // Retorna 404 se não encontrar
        }
        return ResponseEntity.ok(clienteResponse);
    }

    // Endpoint para cadastrar um novo cliente
    @PostMapping("/clientes")
    public ResponseEntity<ClienteResponse> cadastrarCliente(@RequestBody ClienteRequest clienteRequest) {
        ClienteResponse clienteResponse = clienteService.cadastrarCliente(clienteRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteResponse); // Retorna HTTP 201 (Created)
    }

    // Endpoint para atualizar um cliente existente
    @PutMapping("/clientes/{idCliente}")
    public ResponseEntity<ClienteResponse> atualizarCliente(@PathVariable Long idCliente, @RequestBody ClienteRequest clienteRequest) {
        ClienteResponse clienteResponse = clienteService.atualizarCliente(idCliente, clienteRequest);
        if (clienteResponse == null) {
            return ResponseEntity.notFound().build(); // Retorna 404 se não encontrar
        }
        return ResponseEntity.ok(clienteResponse);
    }

    // Endpoint para deletar um cliente pelo id
    @DeleteMapping("/clientes/{idCliente}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long idCliente) {
        boolean deleted = clienteService.deletarCliente(idCliente);
        if (!deleted) {
            return ResponseEntity.notFound().build(); // Retorna 404 se o cliente não for encontrado
        }
        return ResponseEntity.noContent().build(); // Retorna 204 (No Content) após sucesso
    }
}
