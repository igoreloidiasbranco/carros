package br.com.ada.carros.controller;

import br.com.ada.carros.dto.RespostaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public RespostaDTO handleValidException(MethodArgumentNotValidException ex) {
        RespostaDTO respostaDTO = new RespostaDTO();
        ex.getBindingResult().getAllErrors().forEach(e ->{
            String fieldName = ((FieldError)e).getField();
            String errorMessage = e.getDefaultMessage();
            respostaDTO.putError(fieldName, errorMessage);
        });
        return respostaDTO;
    }
}
