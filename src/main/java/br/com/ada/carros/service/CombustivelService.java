package br.com.ada.carros.service;
import br.com.ada.carros.model.Combustivel;
import br.com.ada.carros.repository.CombustivelRepository;
import br.com.ada.carros.service.exception.CombustivelNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class CombustivelService {

   @Autowired
   private CombustivelRepository combustivelRepository;

    public List<Combustivel> listar(){
      return combustivelRepository.findAll();
    }

    public void criar( Combustivel combustivel){

       combustivel.setUid(UUID.randomUUID().toString());

       combustivelRepository.saveAndFlush(combustivel);
    }

    public void editar(String uid, Combustivel combustivel)
    throws CombustivelNotFoundException {
       List<Combustivel> combustiveis = combustivelRepository.findByUid(uid);
        if (combustiveis.size() == 1){
            Combustivel combustivelDB = combustiveis.get(0);
            combustivelDB.setNome(combustivel.getNome());
            combustivelRepository.saveAndFlush(combustivelDB);
        }else{
            throw new CombustivelNotFoundException("O combustível " + uid + " não foi encontrado");
        }

    }

    public boolean deletar(String uid){
       List<Combustivel> combustiveis = combustivelRepository.findByUid(uid);
       if (combustiveis.size() == 0){
           return false;
       }
      Combustivel combustivel = combustiveis.get(0);
       combustivelRepository.delete(combustivel);
       return true;
    }

    public Combustivel getByUid(String uid){
        List<Combustivel> combustiveis = combustivelRepository.findByUid(uid);
        if(combustiveis.size() == 1){
            return combustiveis.get(0);
        }
    return null;
    }
}
