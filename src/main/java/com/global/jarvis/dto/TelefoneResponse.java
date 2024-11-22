package com.global.jarvis.dto;

import com.global.jarvis.model.Telefone;
import lombok.Data;

@Data
public class TelefoneResponse {

    private Long idTelefone;
    private Long idCliente;
    private String nrTelefone;
    private String nrDdd;
    private String dsTelefone;

    public TelefoneResponse(Telefone telefone) {
        this.idTelefone = telefone.getIdTelefone();
        this.idCliente = telefone.getCliente() != null ? telefone.getCliente().getIdCliente() : null; // Previne NullPointerException
        this.nrTelefone = telefone.getNrTelefone();
        this.nrDdd = telefone.getNrDdd();
        this.dsTelefone = telefone.getDsTelefone();
    }
}
