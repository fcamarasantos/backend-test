package com.fcamara.testebackendjava.parkwise.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;

@Entity
@Data                  // Gera automaticamente getters, setters, equals, hashCode e toString
@NoArgsConstructor     // Gera um construtor sem argumentos
@AllArgsConstructor
public class EntradaSaida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Veiculo veiculo;

    @NotNull
    private LocalDateTime entrada;

    private LocalDateTime saida;
}
