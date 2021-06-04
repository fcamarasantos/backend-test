package fcamara.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fcamara.model.Estacionamento;

public interface EstacionamentoRepository extends JpaRepository<Estacionamento, String>{

	Estacionamento findByCnpj(String cnpj);

	void deleteByCnpj(String cnpj);

}