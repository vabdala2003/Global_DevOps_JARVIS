package com.global.jarvis.model;

import com.global.jarvis.dto.ClienteRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long idCliente;

    @NotBlank(message = "O nome não pode estar vazio.")
    @Column(nullable = false, length = 100)
    @Getter @Setter
    private String nome;

    @NotBlank(message = "O CPF é obrigatório.")
    @Column(unique = true, nullable = false, length = 11)
    @Getter @Setter
    private String cpf;

    @NotBlank(message = "O RG é obrigatório.")
    @Column(unique = true, nullable = false, length = 15)
    @Getter @Setter
    private String rg;

    @NotNull(message = "A data de nascimento é obrigatória.")
    @Getter @Setter
    private LocalDate dataNascimento;

    @NotBlank(message = "A senha não pode estar vazia.")
    @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres.")
    @Column(nullable = false)
    @Getter @Setter
    private String senha;

    public Cliente() {}

    public Cliente(ClienteRequest clienteRequest) {
        this.nome = clienteRequest.getNome();
        this.cpf = clienteRequest.getCpf();
        this.rg = clienteRequest.getRg();
        this.dataNascimento = LocalDate.parse(clienteRequest.getDataNascimento(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.senha = clienteRequest.getSenha();
    }
}
