package br.com.ada.carros.service;

import br.com.ada.carros.dto.CorDTO;
import br.com.ada.carros.service.exception.CorNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CorService {
    private List<CorDTO> cores = new ArrayList<>();

    public List<CorDTO> listar(){
        return cores;
    }

    public void criar (CorDTO corDTO){
        cores.add(corDTO);
    }

  public void editar (String nomeFiltro, CorDTO corDTO) throws CorNotFoundException {
        CorDTO corEncontrada = getByNome(nomeFiltro);
        if (corEncontrada == null) {
            throw new CorNotFoundException("A cor " + nomeFiltro + " não foi encontrada");
        }
  corEncontrada.setNome(corDTO.getNome());
    }

public boolean deletar(String nomeFiltro){
        CorDTO corEncontrada = getByNome(nomeFiltro);
        if (corEncontrada == null){
            return false;
        }
cores.remove(corEncontrada);
        return true;
    }


  public CorDTO getByNome(String nomeFiltro) {
        CorDTO corEncontrada = null;
        for (CorDTO corLista : cores){
          if(  corLista.getNome().equalsIgnoreCase(nomeFiltro)){
            corEncontrada = corLista;
            break;
            }
        }
  return corEncontrada;
    }

    public boolean contains (String nomeFiltro){
        return getByNome(nomeFiltro) != null;
    }
}
