package com.fcamara.testebackendjava.parkwise.service;

import com.fcamara.testebackendjava.parkwise.model.EntradaSaida;
import com.fcamara.testebackendjava.parkwise.model.Veiculo;
import com.fcamara.testebackendjava.parkwise.repository.EntradaSaidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EntradaSaidaService {

    @Autowired
    private EntradaSaidaRepository entradaSaidaRepository;

    // Create (Registrar Entrada)
    public EntradaSaida registrarEntrada(Veiculo veiculo) {
        EntradaSaida entradaSaida = new EntradaSaida();
        entradaSaida.setVeiculo(veiculo);
        entradaSaida.setEntrada(LocalDateTime.now());
        return entradaSaidaRepository.save(entradaSaida);
    }

    // Read
    public List<EntradaSaida> listarEntradasSaidas() {
        return entradaSaidaRepository.findAll();
    }

    public Optional<EntradaSaida> obterEntradaSaidaPorId(Long id) {
        return entradaSaidaRepository.findById(id);
    }

    // Update (Registrar Saída)
    public EntradaSaida registrarSaida(Long id) {
        EntradaSaida entradaSaida = entradaSaidaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrada/Saída não encontrada"));

        entradaSaida.setSaida(LocalDateTime.now());
        return entradaSaidaRepository.save(entradaSaida);
    }

    // Delete
    public void deletarEntradaSaida(Long id) {
        entradaSaidaRepository.deleteById(id);
    }
}
