package br.com.ada.carros.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "carro")
@Data
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String uid;
private String nome;
private double preco;

@ManyToOne(fetch = FetchType.LAZY)
    private Combustivel combustivel;
}
