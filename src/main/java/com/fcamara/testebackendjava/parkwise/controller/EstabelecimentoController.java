package com.fcamara.testebackendjava.parkwise.controller;


import com.fcamara.testebackendjava.parkwise.model.Estabelecimento;
import com.fcamara.testebackendjava.parkwise.service.EstabelecimentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/estabelecimentos")
public class EstabelecimentoController {
    @Autowired
    private EstabelecimentoService service;

    @PostMapping
    public ResponseEntity<Estabelecimento> criarEstabelecimento(@RequestBody @Valid Estabelecimento estabelecimento) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvarEstabelecimento(estabelecimento));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estabelecimento> obterEstabelecimento(@PathVariable Long id) {
        return service.obterEstabelecimentoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Métodos PUT, DELETE
}
