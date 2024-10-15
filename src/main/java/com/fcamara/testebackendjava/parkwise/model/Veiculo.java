package com.fcamara.testebackendjava.parkwise.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Data                  // Gera automaticamente getters, setters, equals, hashCode e toString
@NoArgsConstructor     // Gera um construtor sem argumentos
@AllArgsConstructor    // Gera um construtor com todos os argumentos
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String marca;

    @NotNull
    private String modelo;

    @NotNull
    private String cor;

    @NotNull
    private String placa;

    @Enumerated(EnumType.STRING)
    @NotNull
    private TipoVeiculo tipo;


    public enum TipoVeiculo {
        CARRO, MOTO
    }
}
