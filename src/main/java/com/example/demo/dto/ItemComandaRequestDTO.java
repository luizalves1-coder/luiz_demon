package com.example.demo.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;


public record ItemComandaRequestDTO(


        @NotNull(mensage = "Id não pode ser nulo.")
        Long produtoId,

        @Min (minimo = 1 "valor minimo: 1")
        Integer
        quantidade
) {
}