package com.global.jarvis.model;

import com.global.jarvis.dto.ProdutoRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduto;

    @NotNull
    @Size(max = 100)
    private String nomeProduto;

    @Size(max = 50)
    private String categoria;

    @NotNull
    private BigDecimal preco;

    @NotNull
    @Size(max = 20)
    private String status;

    @Size(max = 255)
    private String descricao;

    @Size(max = 10)
    private String tamanho;

    // Default constructor
    public Produto() {}

    // Constructor that accepts ProdutoRequest
    public Produto(ProdutoRequest produtoRequest) {
        this.nomeProduto = produtoRequest.getNomeProduto();
        this.categoria = produtoRequest.getCategoria();
        this.preco = produtoRequest.getPreco();
        this.status = produtoRequest.getStatus();
        this.descricao = produtoRequest.getDescricao();
        this.tamanho = produtoRequest.getTamanho();
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
