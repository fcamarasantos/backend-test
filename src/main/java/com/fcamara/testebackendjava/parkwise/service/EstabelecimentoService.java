package com.fcamara.testebackendjava.parkwise.service;

import com.fcamara.testebackendjava.parkwise.model.Estabelecimento;
import com.fcamara.testebackendjava.parkwise.repository.EstabelecimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstabelecimentoService {
    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;

    // Create
    public Estabelecimento salvarEstabelecimento(Estabelecimento estabelecimento) {
        return estabelecimentoRepository.save(estabelecimento);
    }
    // Read
    public List<Estabelecimento> listarEstabelecimentos() {
        return estabelecimentoRepository.findAll();
    }

    public Optional<Estabelecimento> obterEstabelecimentoPorId(Long id) {
        return estabelecimentoRepository.findById(id);
    }
    // Update
    public Estabelecimento atualizarEstabelecimento(Long id, Estabelecimento estabelecimento) {
        if (estabelecimentoRepository.existsById(id)) {
            estabelecimento.setId(id); // Garantir que o ID seja mantido
            return estabelecimentoRepository.save(estabelecimento);
        }
        throw new RuntimeException("Estabelecimento não encontrado");
    }

    // Delete
    public void deletarEstabelecimento(Long id) {
        estabelecimentoRepository.deleteById(id);
    }
}
