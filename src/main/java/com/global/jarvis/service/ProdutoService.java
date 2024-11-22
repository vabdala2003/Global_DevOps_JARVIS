package com.global.jarvis.service;

import com.global.jarvis.dto.ProdutoRequest;
import com.global.jarvis.dto.ProdutoResponse;
import com.global.jarvis.model.Produto;
import com.global.jarvis.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoResponse cadastrarProduto(ProdutoRequest produtoRequest) {
        Produto produto = new Produto(produtoRequest);
        produtoRepository.save(produto);
        return new ProdutoResponse(produto);
    }

    public List<ProdutoResponse> listarProdutos() {
        List<Produto> produtos = produtoRepository.findAll();
        return produtos.stream()
                .map(ProdutoResponse::new)
                .collect(Collectors.toList());
    }

    public ProdutoResponse obterProduto(Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado com o ID: " + id));
        return new ProdutoResponse(produto);
    }

    public ProdutoResponse atualizarProduto(Long id, ProdutoRequest produtoRequest) {
        Produto produtoExistente = produtoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado com o ID: " + id));

        produtoExistente.setNomeProduto(produtoRequest.getNomeProduto());
        produtoExistente.setCategoria(produtoRequest.getCategoria());
        produtoExistente.setPreco(produtoRequest.getPreco());
        produtoExistente.setStatus(produtoRequest.getStatus());
        produtoExistente.setDescricao(produtoRequest.getDescricao());
        produtoExistente.setTamanho(produtoRequest.getTamanho());

        produtoRepository.save(produtoExistente);
        return new ProdutoResponse(produtoExistente);
    }

    public boolean deletarProduto(Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado com o ID: " + id));
        produtoRepository.delete(produto);
        return true;
    }
}
