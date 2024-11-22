package com.global.jarvis.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class TelefoneRequest {

    @NotNull(message = "O ID do cliente não pode ser nulo.")
    private Long idCliente;

    @NotNull(message = "O número de telefone não pode ser nulo.")
    @Size(min = 10, max = 15, message = "O número de telefone deve ter entre 10 e 15 caracteres.")
    private String numero;

    @NotNull(message = "O DDD não pode ser nulo.")
    @Size(min = 2, max = 5, message = "O DDD deve ter entre 2 e 5 caracteres.")
    private String ddd;

    @Size(max = 255, message = "A descrição do telefone não pode exceder 255 caracteres.")
    private String descricao;
}
