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
@Table(name = "telefone") // Define explicitamente o nome da tabela
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_telefone")
    private Long idTelefone; // ID do telefone

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente; // Relacionamento com Cliente

    @Column(name = "nr_telefone", nullable = false, length = 15)
    private String nrTelefone; // Número de telefone

    @Column(name = "nr_ddd", nullable = false, length = 5)
    private String nrDdd; // Código DDD

    @Column(name = "ds_telefone", length = 255)
    private String dsTelefone; // Descrição do telefone

    // Construtor que mapeia TelefoneRequest para Telefone
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
