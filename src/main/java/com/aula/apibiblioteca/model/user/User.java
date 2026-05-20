package com.aula.apibiblioteca.model.user;

import com.aula.apibiblioteca.dto.user.UserPatchDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
  @Id
  @UuidGenerator
  private String id;
  @Column(nullable = false)
  private String name;
  @Column(unique = true, nullable = false)
  private String email;
  @Column(nullable = false)
  private String password;

  public void update(User user) {
    name = user.name;
    email = user.email;
    password = user.password;
  }

  public void patch(UserPatchDTO dto) {
    if (dto.name() != null && !dto.name().isBlank()) {
      name = dto.name();
    }

    if (dto.email() != null && !dto.email().isBlank()) {
      email = dto.email();
    }

    if (dto.password() != null && !dto.password().isBlank()) {
      password = dto.password();
    }
  }
}
