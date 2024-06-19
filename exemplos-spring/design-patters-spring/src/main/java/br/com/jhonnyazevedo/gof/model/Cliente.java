package br.com.jhonnyazevedo.gof.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.processing.Generated;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;

    @ManyToOne
    private Endereco endereco;

    public Cliente(String nome, Endereco endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }
}
