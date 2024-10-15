package com.fcamara.testebackendjava.parkwise;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fcamara.testebackendjava.parkwise.controller.EstabelecimentoController;
import com.fcamara.testebackendjava.parkwise.model.Estabelecimento;
import com.fcamara.testebackendjava.parkwise.service.EstabelecimentoService;
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

@WebMvcTest(EstabelecimentoController.class)
public class EstabelecimentoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EstabelecimentoService estabelecimentoService;

    @Autowired
    private ObjectMapper objectMapper;
    @Test
    public void deveCriarEstabelecimento() throws Exception {
        Estabelecimento estabelecimento = new Estabelecimento(
                null, "Estacionamento Central", "12.345.678/0001-00", "Rua Principal, 123",
                "(85) 1234-5678", 10, 50, "contato@central.com"
        );

        // Configura o mock para retornar o estabelecimento quando o método salvar for chamado
        when(estabelecimentoService.salvarEstabelecimento(any(Estabelecimento.class))).thenReturn(estabelecimento);

        String estabelecimentoJson = objectMapper.writeValueAsString(estabelecimento);

        mockMvc.perform(post("/api/estabelecimentos")
                        .contentType("application/json")
                        .content(estabelecimentoJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nome").value("Estacionamento Central"));
    }
}