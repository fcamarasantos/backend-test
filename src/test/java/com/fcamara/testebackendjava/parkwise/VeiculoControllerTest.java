package com.fcamara.testebackendjava.parkwise;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fcamara.testebackendjava.parkwise.controller.VeiculoController;
import com.fcamara.testebackendjava.parkwise.model.Veiculo;
import com.fcamara.testebackendjava.parkwise.service.VeiculoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@WebMvcTest(VeiculoController.class)
public class VeiculoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VeiculoService veiculoService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void deveCriarVeiculo() throws Exception {
        Veiculo veiculo = new Veiculo(
                null, "Toyota", "Corolla", "Prata", "ABC-1234", Veiculo.TipoVeiculo.CARRO
        );

        // Mocka o retorno do serviço
        when(veiculoService.salvarVeiculo(any(Veiculo.class))).thenReturn(veiculo);

        String veiculoJson = objectMapper.writeValueAsString(veiculo);

        mockMvc.perform(post("/api/veiculos")
                        .contentType("application/json")
                        .content(veiculoJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.marca").value("Toyota"))
                .andExpect(jsonPath("$.modelo").value("Corolla"));
    }
}