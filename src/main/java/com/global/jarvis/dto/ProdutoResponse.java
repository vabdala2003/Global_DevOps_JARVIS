package com.global.jarvis.dto;

import com.global.jarvis.model.Produto;

import java.math.BigDecimal;

public class ProdutoResponse {

    private Long idProduto;
    private String nomeProduto;
    private String categoria;
    private BigDecimal preco;
    private String status;
    private String descricao;
    private String tamanho;

    public ProdutoResponse(Produto produto) {
        this.idProduto = produto.getIdProduto();
        this.nomeProduto = produto.getNomeProduto();
        this.categoria = produto.getCategoria();
        this.preco = produto.getPreco();
        this.status = produto.getStatus();
        this.descricao = produto.getDescricao();
        this.tamanho = produto.getTamanho();
    }

    public ProdutoResponse(Long idProduto, String nomeProduto, String categoria, BigDecimal preco, String status, String descricao, String tamanho) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.categoria = categoria;
        this.preco = preco;
        this.status = status;
        this.descricao = descricao;
        this.tamanho = tamanho;
    }

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
