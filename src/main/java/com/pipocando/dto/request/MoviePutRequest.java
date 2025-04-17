package com.pipocando.dto.request;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record MoviePutRequest(
    @NotBlank(message = "Nome é obrigatório")
    String name,
    
    @NotEmpty(message = "Pelo menos uma plataforma de streaming é obrigatória")
    List<String> streamingPlatforms,
    
    @NotBlank(message = "Gravadora é obrigatória")
    String company,
    
    @NotBlank(message = "Diretor é obrigatório")
    String director,
    
    @NotEmpty(message = "Pelo menos um ator é obrigatório")
    List<String> actors,
    
    @NotNull(message = "Duração é obrigatória")
    @Positive(message = "Duração deve ser um valor positivo")
    Integer durationMinutes
) {}
