package com.aula.apibiblioteca.mapper.user;

import com.aula.apibiblioteca.dto.user.UserRequestDTO;
import com.aula.apibiblioteca.dto.user.UserResponseDTO;
import com.aula.apibiblioteca.model.user.User;

public class UserMapper {

  public static User toEntity(UserRequestDTO dto) {
    User user = new User();
    user.setName(dto.name());
    user.setEmail(dto.email());
    user.setPassword(dto.password());
    return user;
  }

  public static UserResponseDTO toDTO(User user) {
    return new UserResponseDTO(user.getId(), user.getName(), user.getEmail());
  }
}
