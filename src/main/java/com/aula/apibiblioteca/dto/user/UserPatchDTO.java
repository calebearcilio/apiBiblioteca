package com.aula.apibiblioteca.dto.user;

import jakarta.validation.constraints.Email;

public record UserPatchDTO(String name, @Email String email, String password) {
}
