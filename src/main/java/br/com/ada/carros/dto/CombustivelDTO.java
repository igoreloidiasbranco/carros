package br.com.ada.carros.dto;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
@Data
@Builder
public class CombustivelDTO {

    @NotBlank(message = "O nome é obrigatório.")
   @Length(min = 3, message = "O nome tem que ter no minimo 3 letras.")
    private String nome;

   private String uid;


}
