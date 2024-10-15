package com.fcamara.testebackendjava.parkwise;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fcamara.testebackendjava.parkwise.controller.EntradaSaidaController;
import com.fcamara.testebackendjava.parkwise.model.EntradaSaida;
import com.fcamara.testebackendjava.parkwise.model.Veiculo;
import com.fcamara.testebackendjava.parkwise.service.EntradaSaidaService;
import com.fcamara.testebackendjava.parkwise.service.VeiculoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

@WebMvcTest(EntradaSaidaController.class)
public class EntradaSaidaControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EntradaSaidaService entradaSaidaService;

    @MockBean
    private VeiculoService veiculoService; // Adiciona o MockBean para VeiculoService

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void deveRegistrarEntrada() throws Exception {
        // Dados do veículo e registro de entrada
        Veiculo veiculo = new Veiculo(
                1L, "Toyota", "Corolla", "Prata", "ABC-1234", Veiculo.TipoVeiculo.CARRO
        );

        LocalDateTime entradaDataHora = LocalDateTime.of(2024, 10, 14, 8, 0);
        EntradaSaida entradaSaida = new EntradaSaida(1L, veiculo, entradaDataHora, null);

        // Configura o mock para retornar o registro de entrada
        when(entradaSaidaService.registrarEntrada(any(Veiculo.class))).thenReturn(entradaSaida);

        String veiculoJson = objectMapper.writeValueAsString(veiculo);

        mockMvc.perform(post("/api/entradas-saidas/entrada")
                        .contentType("application/json")
                        .content(veiculoJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.veiculo.marca").value("Toyota"))
                .andExpect(jsonPath("$.entrada").value("2024-10-14T08:00:00"));
    }
}