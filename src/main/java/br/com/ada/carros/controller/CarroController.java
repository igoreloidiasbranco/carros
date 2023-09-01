package br.com.ada.carros.controller;

import br.com.ada.carros.dto.CarroDTO;
import br.com.ada.carros.dto.FactoryDTO;
import br.com.ada.carros.dto.RespostaDTO;
import br.com.ada.carros.service.CarroService;
import br.com.ada.carros.service.CombustivelService;
import br.com.ada.carros.service.CorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

// listar e criar somente funcionam
// fazer validação se criou, não criar novamente
// fazer a edição do carro e a relação com as demais entidades.
@RestController
@RequestMapping("/carro")
public class CarroController extends BaseController {

  @Autowired
  private CarroService carroService;

  @Autowired
  private CombustivelService combustivelService;

  @Autowired
  private CorService corService;

    @GetMapping("/listar")
    public List<CarroDTO> listar(/*@RequestParam String filtro*/) {
       // if (filtro != null && !filtro.isEmpty()) {
           // return carroService.filterByNome(filtro);
       // }
        return FactoryDTO.carrosToDTO(carroService.listar());
    }

    @GetMapping
    public CarroDTO consultar (@RequestParam String nome){
        return CarroDTO.builder().nome(nome).preco(10000).build();
    }


    @PostMapping
    public ResponseEntity<RespostaDTO> criar (@RequestBody @Valid CarroDTO carroDTO) {
       System.out.println("Nome do Carro: " + carroDTO.getNome());
       carroService.criar(FactoryDTO.dtoToEntity(carroDTO));
       return ResponseEntity.ok(new RespostaDTO().setResposta(true).setMensagem("Carro " +
               carroDTO.getNome() + " criado com sucesso"));

}

@PutMapping
    public RespostaDTO editar(@RequestBody CarroDTO carroDTO){
 return new RespostaDTO().setResposta(true).setMensagem("Carro " + carroDTO.getNome() +
         " editado com sucesso");
}

@DeleteMapping
    public ResponseEntity<RespostaDTO> remover(@RequestParam String nome){
    int removido = 0;

      if (removido == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new RespostaDTO()
                    .setResposta(false).setMensagem("Não foi encontrado nenhum carro com esse nome"));
        }
    return ResponseEntity.ok(new RespostaDTO()
            .setResposta(true)
            .setMensagem(removido + " carros com o nome " + nome + " foram removidos com sucesso"));
    }

}


