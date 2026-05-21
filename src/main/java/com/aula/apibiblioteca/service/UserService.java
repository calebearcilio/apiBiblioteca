package com.aula.apibiblioteca.service;

import com.aula.apibiblioteca.dto.user.UserPatchDTO;
import com.aula.apibiblioteca.model.user.User;
import com.aula.apibiblioteca.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public Page<User> findAll(@PageableDefault(size = 4, sort = "name") Pageable pageable) {
    return userRepository.findAll(pageable);
  }

  public User findById(String id) {
    return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado."));
  }

  public User save(User user) {
    return userRepository.save(user);
  }

  public User update(String id, User user) {
    User userTemp = findById(id);
    userTemp.update(user);
    userRepository.save(userTemp);
    return userTemp;
  }

  public User patch(String id, UserPatchDTO dto) {
    User userTemp = findById(id);
    userTemp.patch(dto);
    userRepository.save(userTemp);
    return userTemp;
  }

  public void delete(String id) {
    findById(id);
    userRepository.deleteById(id);
  }
}
