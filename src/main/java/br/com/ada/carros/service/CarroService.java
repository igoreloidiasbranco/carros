package br.com.ada.carros.service;

import br.com.ada.carros.dto.CarroDTO;
import br.com.ada.carros.model.Carro;
import br.com.ada.carros.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CarroService {
   @Autowired
    CarroRepository carroRepository;

   @Autowired
   CombustivelService combustivelService;

    public List<Carro> listar() {return carroRepository.findWithCombustiveis();}

public void criar(Carro carro){
        carro.setCombustivel(combustivelService.getByUid(carro.getCombustivel().getUid()));
        carro.setUid(UUID.randomUUID().toString());
        carroRepository.saveAndFlush(carro);
}

    }

