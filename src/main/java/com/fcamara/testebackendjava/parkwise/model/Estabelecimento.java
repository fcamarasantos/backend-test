package com.fcamara.testebackendjava.parkwise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;


@Entity
@Data                  // Gera automaticamente getters, setters, equals, hashCode e toString
@NoArgsConstructor     // Gera um construtor sem argumentos
@AllArgsConstructor    // Gera um construtor com todos os argumentos
public class Estabelecimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;

    @NotNull
    private String cnpj;

    @NotNull
    private String endereco;

    @NotNull
    private String telefone;

    @NotNull
    private int vagasMotos;

    @NotNull
    private int vagasCarros;

    @NotNull
    private String email;
}
