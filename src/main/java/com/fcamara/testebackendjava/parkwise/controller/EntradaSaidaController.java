package com.fcamara.testebackendjava.parkwise.controller;

import com.fcamara.testebackendjava.parkwise.model.EntradaSaida;
import com.fcamara.testebackendjava.parkwise.model.Veiculo;
import com.fcamara.testebackendjava.parkwise.service.EntradaSaidaService;
import com.fcamara.testebackendjava.parkwise.service.VeiculoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entradas-saidas")
@Tag(name = "Entradas e Saídas", description = "Endpoints de gestão de entradas e saídas de veículos")
public class EntradaSaidaController {
    @Autowired
    private EntradaSaidaService entradaSaidaService;
    @Autowired
    private VeiculoService veiculoService;

    // Registrar entrada de veículo
    @PostMapping("/entrada")
    @Operation(summary = "Registrar entrada", description = "Registra a entrada de um veículo no estacionamento")
    public ResponseEntity<EntradaSaida> registrarEntrada(@RequestBody Veiculo veiculo) {
        EntradaSaida entradaSaida = entradaSaidaService.registrarEntrada(veiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(entradaSaida);
    }

    // Listar todos os registros de entrada e saída
    @GetMapping
    @Operation(summary = "Listar entradas e saídas", description = "Retorna uma lista de todos os registros de entrada e saída")
    public ResponseEntity<List<EntradaSaida>> listarEntradasSaidas() {
        List<EntradaSaida> entradasSaidas = entradaSaidaService.listarEntradasSaidas();
        return ResponseEntity.ok(entradasSaidas);
    }

    // Registrar saída de veículo
    @PutMapping("/saida/{id}")
    @Operation(summary = "Registrar saída", description = "Registra a saída de um veículo no estacionamento")
    public ResponseEntity<EntradaSaida> registrarSaida(@PathVariable Long id) {
        try {
            EntradaSaida entradaSaidaAtualizada = entradaSaidaService.registrarSaida(id);
            return ResponseEntity.ok(entradaSaidaAtualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Deletar um registro de entrada e saída por ID
    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir registro de entrada/saída", description = "Remove um registro de entrada e saída do sistema pelo ID")
    public ResponseEntity<Void> deletarEntradaSaida(@PathVariable Long id) {
        entradaSaidaService.deletarEntradaSaida(id);
        return ResponseEntity.noContent().build();
    }
}
