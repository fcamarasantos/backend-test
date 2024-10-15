package com.fcamara.testebackendjava.parkwise.controller;

import com.fcamara.testebackendjava.parkwise.model.Veiculo;
import com.fcamara.testebackendjava.parkwise.service.VeiculoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/veiculos")
@Tag(name = "Veículos", description = "Endpoints de gestão de veículos")
public class VeiculoController {
    @Autowired
    private VeiculoService veiculoService;

    // Criar veículo
    @PostMapping
    @Operation(summary = "Criar veículo", description = "Adiciona um novo veículo ao sistema",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Veículo criado com sucesso",
                            content = {
                                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Veiculo.class)),
                                    @Content(mediaType = MediaType.APPLICATION_XML_VALUE, schema = @Schema(implementation = Veiculo.class))
                            })
            }
    )
    public ResponseEntity<Veiculo> criarVeiculo(@RequestBody Veiculo veiculo) {
        Veiculo novoVeiculo = veiculoService.salvarVeiculo(veiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoVeiculo);
    }

    // Listar todos os veículos
    @GetMapping
    @Operation(summary = "Listar veículos", description = "Retorna uma lista de todos os veículos",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista de veículos",
                            content = {
                                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Veiculo.class)),
                                    @Content(mediaType = MediaType.APPLICATION_XML_VALUE, schema = @Schema(implementation = Veiculo.class))
                            })
            }
    )
    public ResponseEntity<List<Veiculo>> listarVeiculos() {
        List<Veiculo> veiculos = veiculoService.listarVeiculos();
        return ResponseEntity.ok(veiculos);
    }

    // Obter um veículo por ID
    @GetMapping("/{id}")
    @Operation(summary = "Obter veículo por ID", description = "Retorna os detalhes de um veículo específico",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Veículo encontrado",
                            content = {
                                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Veiculo.class)),
                                    @Content(mediaType = MediaType.APPLICATION_XML_VALUE, schema = @Schema(implementation = Veiculo.class))
                            }),
                    @ApiResponse(responseCode = "404", description = "Veículo não encontrado")
            }
    )
    public ResponseEntity<Veiculo> obterVeiculoPorId(@PathVariable Long id) {
        Optional<Veiculo> veiculo = veiculoService.obterVeiculoPorId(id);
        return veiculo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Atualizar um veículo por ID
    @PutMapping("/{id}")
    @Operation(summary = "Atualizar veículo", description = "Atualiza as informações de um veículo existente",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Veículo atualizado com sucesso",
                            content = {
                                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Veiculo.class)),
                                    @Content(mediaType = MediaType.APPLICATION_XML_VALUE, schema = @Schema(implementation = Veiculo.class))
                            }),
                    @ApiResponse(responseCode = "404", description = "Veículo não encontrado")
            }
    )
    public ResponseEntity<Veiculo> atualizarVeiculo(@PathVariable Long id, @RequestBody Veiculo veiculo) {
        try {
            Veiculo veiculoAtualizado = veiculoService.atualizarVeiculo(id, veiculo);
            return ResponseEntity.ok(veiculoAtualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Deletar um veículo por ID
    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir veículo", description = "Remove um veículo do sistema pelo ID",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Veículo excluído com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Veículo não encontrado")
            }
    )
    public ResponseEntity<Void> deletarVeiculo(@PathVariable Long id) {
        veiculoService.deletarVeiculo(id);
        return ResponseEntity.noContent().build();
    }
}
