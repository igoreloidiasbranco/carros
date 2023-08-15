package br.com.ada.carros.controller;

import br.com.ada.carros.dto.CombustivelDTO;
import br.com.ada.carros.dto.FactoryDTO;
import br.com.ada.carros.dto.RespostaDTO;
import br.com.ada.carros.service.CombustivelService;
import br.com.ada.carros.service.exception.CombustivelNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/combustivel")
public class CombustivelController extends BaseController {

    @Autowired
    private CombustivelService combustivelService;



    @GetMapping("/listar")
    public ResponseEntity<List<CombustivelDTO>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(FactoryDTO.combustiveisToDTO(combustivelService.listar()));
    }

@PostMapping
    public ResponseEntity<RespostaDTO> criar(@RequestBody @Valid CombustivelDTO combustivelDTO){
       combustivelService.criar(FactoryDTO.dtoToEntity(combustivelDTO));
       return ResponseEntity.ok(new RespostaDTO().setResposta(true)
               .setMensagem("O combustivel do carro foi criado com sucesso"));
        }


    @PutMapping
    public ResponseEntity<RespostaDTO> editar(
            @RequestParam(name = "uid") String uid,
            @RequestBody @Valid CombustivelDTO combustivelDTO)
    {
        try {
            combustivelService.editar(uid,FactoryDTO.dtoToEntity(combustivelDTO));
        } catch (CombustivelNotFoundException e) {return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(
                        new RespostaDTO()
                                .setResposta(false)
                                .setMensagem(e.getMessage()));

        }
        return ResponseEntity.status(HttpStatus.OK).body(new RespostaDTO()
                .setResposta(true).setMensagem("O combustível " + uid + " foi editado com sucesso"));
    }

    @DeleteMapping
    public ResponseEntity<RespostaDTO> deletar(
            @RequestParam(name = "uid") String uid)

    {
       boolean resposta = combustivelService.deletar(uid);
        if (resposta == false) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(
                            new RespostaDTO()
                                    .setResposta(false)
                                    .setMensagem("O combustível " + uid + " não foi encontrado"));
        }

        return ResponseEntity.status(HttpStatus.OK).body(new RespostaDTO()
                .setResposta(true)
                .setMensagem("O combustível " + uid +
                        " foi deletado com sucesso"));
    }
}
