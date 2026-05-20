package com.aula.apibiblioteca.dto.exeption;

import java.time.LocalDateTime;
import java.util.Map;

public record ExceptionResponseDTO(
        String status,
        Map<String, String> errors,
        LocalDateTime localDateTime
) {
}
