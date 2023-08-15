package br.com.ada.carros.repository;

import br.com.ada.carros.model.Combustivel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CombustivelRepository extends JpaRepository<Combustivel, Long> {
    @Query("SELECT c FROM Combustivel c WHERE c.uid = :uid")
    List<Combustivel> findByUid(@Param("uid")String uid);
}
