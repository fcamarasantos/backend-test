package com.fcamara.testebackendjava.parkwise.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fcamara.testebackendjava.parkwise.model.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    // Métodos personalizados podem ser adicionados aqui, se necessário
}