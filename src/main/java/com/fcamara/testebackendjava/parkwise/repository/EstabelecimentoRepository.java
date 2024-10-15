package com.fcamara.testebackendjava.parkwise.repository;

import com.fcamara.testebackendjava.parkwise.model.Estabelecimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Long> { }
