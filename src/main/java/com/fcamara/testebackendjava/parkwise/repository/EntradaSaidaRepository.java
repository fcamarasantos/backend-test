package com.fcamara.testebackendjava.parkwise.repository;

import com.fcamara.testebackendjava.parkwise.model.EntradaSaida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntradaSaidaRepository extends JpaRepository<EntradaSaida, Long> {
    // Métodos personalizados podem ser adicionados aqui, se necessário
}
