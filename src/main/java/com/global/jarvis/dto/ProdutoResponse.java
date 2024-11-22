package com.global.jarvis.dto;

import com.global.jarvis.model.Produto;

import java.math.BigDecimal;

public class ProdutoResponse {

    private Long idProduto; // Alterado para Long
    private String nomeProduto; // Nome atualizado para corresponder ao modelo
    private String categoria; // Nome atualizado para corresponder ao modelo
    private BigDecimal preco; // Nome atualizado para corresponder ao modelo
    private String status; // Nome atualizado para corresponder ao modelo
    private String descricao; // Nome atualizado para corresponder ao modelo
    private String tamanho; // Nome atualizado para corresponder ao modelo

    // Construtor que aceita um objeto Produto
    public ProdutoResponse(Produto produto) {
        this.idProduto = produto.getIdProduto();
        this.nomeProduto = produto.getNomeProduto();
        this.categoria = produto.getCategoria();
        this.preco = produto.getPreco();
        this.status = produto.getStatus();
        this.descricao = produto.getDescricao();
        this.tamanho = produto.getTamanho();
    }

    // Getters and Setters
    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
}
