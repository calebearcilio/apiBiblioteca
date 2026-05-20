package com.aula.apibiblioteca.controller;

import com.aula.apibiblioteca.dto.user.UserPatchDTO;
import com.aula.apibiblioteca.dto.user.UserRequestDTO;
import com.aula.apibiblioteca.dto.user.UserResponseDTO;
import com.aula.apibiblioteca.mapper.user.UserMapper;
import com.aula.apibiblioteca.model.user.User;
import com.aula.apibiblioteca.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping
  public ResponseEntity<Page<UserResponseDTO>> getAll(Pageable pageable) {
    Page<UserResponseDTO> users = userService.findAll(pageable).map(user -> UserMapper.toDTO(user));
    return ResponseEntity.ok(users);
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserResponseDTO> getById(@PathVariable String id) {
    try {
      User user = userService.findById(id);
      return ResponseEntity.ok(UserMapper.toDTO(user));
    } catch (Exception e) {
      if (e instanceof EntityNotFoundException) {
        return ResponseEntity.notFound().build();
      }

      return ResponseEntity.internalServerError().build();
    }
  }

  @PostMapping
  public ResponseEntity<UserResponseDTO> post(@RequestBody @Valid UserRequestDTO dto) {
    try {
      User user = UserMapper.toEntity(dto);
      var userCreated = userService.save(user);
      return ResponseEntity.status(201).body(UserMapper.toDTO(userCreated));
    } catch (Exception e) {
      if (e instanceof DataIntegrityViolationException) {
        return ResponseEntity.status(409).build();
      }
      IO.print(e);
      return ResponseEntity.internalServerError().build();
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<UserResponseDTO> update(@PathVariable String id, @RequestBody @Valid UserRequestDTO dto) {
    try {
      var updateUser = userService.update(id, UserMapper.toEntity(dto));
      return ResponseEntity.ok(UserMapper.toDTO(updateUser));
    } catch (Exception e) {
      if (e instanceof EntityNotFoundException) {
        return ResponseEntity.notFound().build();
      }

      return ResponseEntity.internalServerError().build();
    }
  }

  @PatchMapping("/{id}")
  public ResponseEntity<UserResponseDTO> patch(@PathVariable String id, @RequestBody UserPatchDTO dto) {
    try {
      User updatedUser = userService.patch(id, dto);
      return ResponseEntity.ok(UserMapper.toDTO(updatedUser));
    } catch (Exception e) {
      if (e instanceof EntityNotFoundException) {
        return ResponseEntity.notFound().build();
      }
      IO.print(e);
      return ResponseEntity.internalServerError().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable String id) {
    try {
      userService.delete(id);
      return ResponseEntity.ok().build();
    } catch (Exception e) {
      if (e instanceof EntityNotFoundException) {
        return ResponseEntity.notFound().build();
      }

      return ResponseEntity.internalServerError().build();
    }
  }
}
