package br.com.ada.carros.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name="combustivel")
@Data

public class Combustivel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String uid;
    private String nome;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "combustivel")
    private Collection<Carro> carros = new ArrayList<>();
}
