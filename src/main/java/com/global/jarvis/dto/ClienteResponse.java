package com.global.jarvis.dto;

import com.global.jarvis.model.Cliente;

import java.time.format.DateTimeFormatter;

public class ClienteResponse {

    private Long idCliente;
    private String nome;
    private String cpf;
    private String rg;
    private String dataNascimento;
    private String senha;

    public ClienteResponse(Cliente cliente) {
        this.idCliente = cliente.getIdCliente();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.rg = cliente.getRg();
        this.dataNascimento = cliente.getDataNascimento().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.senha = cliente.getSenha();
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
