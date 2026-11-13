package com.example.demo.dto;


import java.math.BigDecimal;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;


public record ItemComandaResponseDTO(

        @NotNull(mensage = "Id não pode ser nulo.")
        Long produtoId,


        @NotBlank(mensage = "o nome do produto é obrigatorio.")
        String nomeProduto,


        @Min (minimo = 1 "quantidade minima: 1")
        Integer quantidade,


        @Min (minimo = 1 "unidade minima por produto: 1")
        BigDecimal precoUnitario,

        @Min (minimo = 1 "valor minimo: 1")
        BigDecimal
        subtotal
) {
}