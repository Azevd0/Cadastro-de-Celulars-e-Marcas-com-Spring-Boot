package com.SpringPhone.Cellphone.repository;

import com.SpringPhone.Cellphone.model.Celular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CelularRepository extends JpaRepository<Celular, Long> {

    Optional<Celular> findByModeloIgnoreCase(String nome);
    List<Celular> findAllByMarcaId(Long id_mark);
    List<Celular> findAllByMarcaNomeContainingIgnoreCase(String nome);

}
