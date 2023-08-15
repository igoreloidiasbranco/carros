package br.com.ada.carros.dto;

import java.util.HashMap;
import java.util.Map;

public class RespostaDTO {
    private boolean resposta = false;
    private String mensagem;
    private Map<String, String> error = null;


    public boolean isResposta() {
        return resposta;
    }

    public RespostaDTO setResposta(boolean resposta) {
        this.resposta = resposta;
        return this;
    }

    public String getMensagem() {
        return mensagem;
    }

    public RespostaDTO setMensagem(String mensagem) {
        this.mensagem = mensagem;
        return this;
    }

    public Map<String, String> getErrors() {
        return error;
    }

    public RespostaDTO putError(String campo, String mensagem){
        if (error == null){
            error = new HashMap<>();
        }
    this.error.put(campo, mensagem);
        return this;
    }
}
