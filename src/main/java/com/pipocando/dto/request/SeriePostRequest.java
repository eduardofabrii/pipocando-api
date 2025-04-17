package com.pipocando.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record SeriePostRequest(
    @NotBlank(message = "Nome é obrigatório")
    String name,
    
    @NotBlank(message = "Streaming é obrigatório")
    String streaming,
    
    @NotBlank(message = "Gravadora é obrigatória")
    String company,
    
    @NotBlank(message = "Diretor é obrigatório")
    String director,
    
    @NotBlank(message = "Atores são obrigatórios")
    String actors,
    
    @NotNull(message = "Número de temporadas é obrigatório")
    @Positive(message = "Número de temporadas deve ser um valor positivo")
    Integer seasons
) {}
