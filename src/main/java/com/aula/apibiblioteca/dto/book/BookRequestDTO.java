package com.aula.apibiblioteca.dto.book;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public record BookRequestDTO(
        @NotBlank String title,
        @NotBlank String author,
        @PositiveOrZero int amount
) {
}
