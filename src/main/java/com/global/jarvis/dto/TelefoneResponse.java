package com.global.jarvis.dto;

import com.global.jarvis.model.Telefone;
import lombok.Data;

@Data
public class TelefoneResponse {

    private Long idTelefone;  // ID do telefone
    private Long idCliente;   // ID do cliente
    private String nrTelefone; // Número de telefone
    private String nrDdd;      // Código DDD
    private String dsTelefone; // Descrição do telefone

    // Construtor que converte um Telefone em TelefoneResponse
    public TelefoneResponse(Telefone telefone) {
        this.idTelefone = telefone.getIdTelefone();
        this.idCliente = telefone.getCliente() != null ? telefone.getCliente().getIdCliente() : null; // Previne NullPointerException
        this.nrTelefone = telefone.getNrTelefone();
        this.nrDdd = telefone.getNrDdd();
        this.dsTelefone = telefone.getDsTelefone();
    }
}
