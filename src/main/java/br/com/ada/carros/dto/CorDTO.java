package br.com.ada.carros.dto;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class CorDTO {
   private String uid;

@NotBlank(message = "O nome da cor deve ser preenchida")
@Length(min = 4, message = "O nome da cor deve ter no mínimo 4 letras")
private String nome;

}
