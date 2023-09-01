package br.com.ada.carros.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "cor")
@Data
public class Cor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nome;
}
