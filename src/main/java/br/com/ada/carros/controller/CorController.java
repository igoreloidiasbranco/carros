package br.com.ada.carros.controller;

import br.com.ada.carros.dto.CorDTO;
import br.com.ada.carros.dto.RespostaDTO;
import br.com.ada.carros.service.CorService;
import br.com.ada.carros.service.exception.CorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cor")
public class CorController extends BaseController{

    @Autowired
    private CorService corService;


     @GetMapping("/listar")
    public ResponseEntity<List<CorDTO>> listar(){
         return ResponseEntity.ok().body(corService.listar());
     }

     @PostMapping
    public ResponseEntity<RespostaDTO> criar (@RequestBody @Valid CorDTO corDTO){
         corService.criar(corDTO);
         return ResponseEntity.ok(new RespostaDTO().setResposta(true).setMensagem("A cor do carro foi criado com sucesso"));
     }

     @PutMapping
    public ResponseEntity<RespostaDTO> editar(@RequestParam (name = "nome") String nomeFiltro,
                                              @RequestBody @Valid CorDTO corDTO){
         try{
             corService.editar(nomeFiltro, corDTO);
         }catch (CorNotFoundException e){
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new RespostaDTO().setResposta(false)
                     .setMensagem(e.getMessage()));
         }
    return ResponseEntity.ok(new RespostaDTO().setResposta(true).setMensagem("A cor do carro foi editada"));
     }

    @DeleteMapping
    public ResponseEntity<RespostaDTO> deletar(@RequestParam(name = "nome") String nomeFiltro){
         boolean resposta = corService.deletar(nomeFiltro);
         if(resposta == false){
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                     new RespostaDTO().setResposta(false).setMensagem("A cor " + nomeFiltro +
                             " não foi encontrada"));
         }
return ResponseEntity.ok(new RespostaDTO().setResposta(true).setMensagem("A cor " + nomeFiltro +
        " foi removida com sucesso."));
    }
}

