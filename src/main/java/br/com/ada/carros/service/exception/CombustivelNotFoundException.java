package br.com.ada.carros.service.exception;

public class CombustivelNotFoundException extends Exception {
    public CombustivelNotFoundException(String mensagem){
        super(mensagem);
    }
}
