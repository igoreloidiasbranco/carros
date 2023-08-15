package br.com.ada.carros.repository;

import br.com.ada.carros.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarroRepository extends JpaRepository<Carro, Long> {
    @Query("SELECT a FROM Carro a JOIN FETCH a.combustivel c")
    List<Carro> findWithCombustiveis();
}
