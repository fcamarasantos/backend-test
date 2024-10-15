package com.fcamara.testebackendjava.parkwise.service;

import com.fcamara.testebackendjava.parkwise.model.Veiculo;
import com.fcamara.testebackendjava.parkwise.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {
    @Autowired
    private VeiculoRepository veiculoRepository;

    // Create
    public Veiculo salvarVeiculo(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    // Read
    public List<Veiculo> listarVeiculos() {
        return veiculoRepository.findAll();
    }

    public Optional<Veiculo> obterVeiculoPorId(Long id) {
        return veiculoRepository.findById(id);
    }

    // Update
    public Veiculo atualizarVeiculo(Long id, Veiculo veiculo) {
        if (veiculoRepository.existsById(id)) {
            veiculo.setId(id); // Garantir que o ID seja mantido
            return veiculoRepository.save(veiculo);
        }
        throw new RuntimeException("Veículo não encontrado");
    }

    // Delete
    public void deletarVeiculo(Long id) {
        veiculoRepository.deleteById(id);
    }
}
