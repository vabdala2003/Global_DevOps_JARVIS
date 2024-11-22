package com.global.jarvis.model;

import com.global.jarvis.dto.TelefoneRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "telefone")
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_telefone")
    private Long idTelefone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @Column(name = "nr_telefone", nullable = false, length = 15)
    private String nrTelefone;

    @Column(name = "nr_ddd", nullable = false, length = 5)
    private String nrDdd;

    @Column(name = "ds_telefone", length = 255)
    private String dsTelefone;

    public Telefone(TelefoneRequest telefoneRequest, Cliente cliente) {
        if (telefoneRequest == null || cliente == null) {
            throw new IllegalArgumentException("TelefoneRequest e Cliente não podem ser nulos");
        }
        this.cliente = cliente;
        this.nrTelefone = telefoneRequest.getNumero();
        this.nrDdd = telefoneRequest.getDdd();
        this.dsTelefone = telefoneRequest.getDescricao();
    }
}
