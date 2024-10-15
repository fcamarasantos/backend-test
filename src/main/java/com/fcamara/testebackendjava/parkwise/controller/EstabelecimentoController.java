package com.fcamara.testebackendjava.parkwise.controller;


import com.fcamara.testebackendjava.parkwise.model.Estabelecimento;
import com.fcamara.testebackendjava.parkwise.service.EstabelecimentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estabelecimentos")
@Tag(name = "Estabelecimentos", description = "Endpoints de gestão de estabelecimentos")
public class EstabelecimentoController {
    @Autowired
    private EstabelecimentoService service;
    @Autowired
    private EstabelecimentoService estabelecimentoService;

    @PostMapping
    @Operation(summary = "Criar estabelecimento", description = "Adiciona um novo estabelecimento ao sistema")
    public ResponseEntity<Estabelecimento> criarEstabelecimento(@RequestBody @Valid Estabelecimento estabelecimento) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvarEstabelecimento(estabelecimento));
    }

    // Obter um estabelecimento por ID
    @GetMapping("/{id}")
    @Operation(summary = "Obter estabelecimento por ID", description = "Retorna os detalhes de um estabelecimento específico")
    public ResponseEntity<Estabelecimento> obterEstabelecimento(@PathVariable Long id) {
        return service.obterEstabelecimentoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Listar todos os estabelecimentos
    @GetMapping
    @Operation(summary = "Listar estabelecimentos", description = "Retorna uma lista de todos os estabelecimentos")
    public ResponseEntity<List<Estabelecimento>> listarEstabelecimentos() {
        List<Estabelecimento> estabelecimentos = estabelecimentoService.listarEstabelecimentos();
        return ResponseEntity.ok(estabelecimentos);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar estabelecimento", description = "Atualiza as informações de um estabelecimento existente")
    public ResponseEntity<Estabelecimento> atualizarEstabelecimento(@PathVariable Long id, @RequestBody Estabelecimento estabelecimento) {
        try {
            Estabelecimento estabelecimentoAtualizado = estabelecimentoService.atualizarEstabelecimento(id, estabelecimento);
            return ResponseEntity.ok(estabelecimentoAtualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir estabelecimento", description = "Remove um estabelecimento do sistema pelo ID")
    public ResponseEntity<Void> deletarEstabelecimento(@PathVariable Long id) {
        estabelecimentoService.deletarEstabelecimento(id);
        return ResponseEntity.noContent().build();
    }

}
