package br.com.ada.carros.dto;

import br.com.ada.carros.model.Carro;
import br.com.ada.carros.model.Combustivel;

import java.util.ArrayList;
import java.util.List;

public class FactoryDTO {
    public static CombustivelDTO entityToDTO(Combustivel combustivel){
        if (combustivel == null){
            return null;
        }
    return CombustivelDTO.builder()
            .uid(combustivel.getUid()).nome(combustivel.getNome()).build();
    }

    public static Combustivel dtoToEntity (CombustivelDTO combustivelDTO){
        if (combustivelDTO == null){
            return null;
        }
        Combustivel combustivel = new Combustivel();
        combustivel.setUid(combustivelDTO.getUid());
        combustivel.setNome(combustivelDTO.getNome());
        return combustivel;
    }

    public static List<CombustivelDTO> combustiveisToDTO (List<Combustivel>combustiveis){
        List<CombustivelDTO> combustiveisDTO = new ArrayList<>();
        for (Combustivel combustivel : combustiveis){
            combustiveisDTO.add(FactoryDTO.entityToDTO(combustivel));
        }
        return combustiveisDTO;
    }

    public static CarroDTO entityToDTO (Carro carro){
        if (carro == null){
            return null;
        }
        return CarroDTO.builder().uid(carro.getUid()).nome(carro.getNome()).preco(carro.getPreco()).combustivel(
                entityToDTO(carro.getCombustivel())).build();
    }

    public static Carro dtoToEntity (CarroDTO carroDTO){
        if (carroDTO == null){
            return null;
        }
    Carro carro = new Carro();
        carro.setUid(carroDTO.getUid());
        carro.setNome(carroDTO.getNome());
        carro.setPreco(carro.getPreco());
        if (carroDTO.getCombustivel() !=null){
            carro.setCombustivel(dtoToEntity(carroDTO.getCombustivel()));
        }
    return carro;
    }

    public static List<CarroDTO> carrosToDTO(List<Carro> carros){
        List<CarroDTO> carrosDTO = new ArrayList<>();
        for (Carro carro : carros){
            carrosDTO.add(FactoryDTO.entityToDTO(carro));
        }
    return carrosDTO;
    }
}
