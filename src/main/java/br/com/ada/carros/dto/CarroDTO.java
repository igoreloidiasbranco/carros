package br.com.ada.carros.dto;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
@Data
@Builder
public class CarroDTO {


    private String uid;

    @NotBlank(message = "O nome é obrigatório.")
    @Length(min = 3, max = 100, message = "O nome do carro tem que ter no mínimo três letras e no máximo cem letras.")
    private String nome;

    @Min(value = 5000, message = "O valor não pode ser menor que cinco mil")
    @Max(value = 100000, message = "O valor não pode ser maior que cem mil")
    private double preco;

    @NotNull(message = "O combustível do carro não pode ser nulo")
    private CombustivelDTO combustivel;


    private CorDTO cor;







}
