package com.aula.apibiblioteca.scripts;

import com.aula.apibiblioteca.model.book.Book;
import com.aula.apibiblioteca.model.user.User;
import com.aula.apibiblioteca.repository.BookRepository;
import com.aula.apibiblioteca.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DatabaseSeeder implements CommandLineRunner {

  private final UserRepository userRepository;
  private final BookRepository bookRepository;

  @Override
  public void run(String... args) {

    if (userRepository.count() == 0) {

      userRepository.save(new User(
              null,
              "Carlos Silva",
              "carlos.silva@email.com",
              "carlos123"
      ));

      userRepository.save(new User(
              null,
              "Mariana Costa",
              "mariana.costa@email.com",
              "mariana789"
      ));

      userRepository.save(new User(
              null,
              "João Pereira",
              "joao.pereira@email.com",
              "joao4567"
      ));

      userRepository.save(new User(
              null,
              "Fernanda Lima",
              "fernanda.lima@email.com",
              "fernanda321"
      ));

      userRepository.save(new User(
              null,
              "Lucas Almeida",
              "lucas.almeida@email.com",
              "lucas987"
      ));

      userRepository.save(new User(
              null,
              "Patrícia Rocha",
              "patricia.rocha@email.com",
              "patricia654"
      ));

      userRepository.save(new User(
              null,
              "Ricardo Souza",
              "ricardo.souza@email.com",
              "ricardo741"
      ));

      userRepository.save(new User(
              null,
              "Juliana Martins",
              "juliana.martins@email.com",
              "juliana852"
      ));

      userRepository.save(new User(
              null,
              "Eduardo Gomes",
              "eduardo.gomes@email.com",
              "eduardo963"
      ));

      userRepository.save(new User(
              null,
              "Camila Ferreira",
              "camila.ferreira@email.com",
              "camila159"
      ));
    }

    if (bookRepository.count() == 0) {

      bookRepository.save(new Book(
              null,
              "Clean Code",
              "Robert C. Martin",
              5
      ));

      bookRepository.save(new Book(
              null,
              "Effective Java",
              "Joshua Bloch",
              3
      ));

      bookRepository.save(new Book(
              null,
              "Design Patterns",
              "Erich Gamma",
              7
      ));

      bookRepository.save(new Book(
              null,
              "Refactoring",
              "Martin Fowler",
              2
      ));

      bookRepository.save(new Book(
              null,
              "Spring in Action",
              "Craig Walls",
              4
      ));

      bookRepository.save(new Book(
              null,
              "Java Concurrency in Practice",
              "Brian Goetz",
              0
      ));

      bookRepository.save(new Book(
              null,
              "Domain-Driven Design",
              "Eric Evans",
              6
      ));

      bookRepository.save(new Book(
              null,
              "The Pragmatic Programmer",
              "Andrew Hunt",
              0
      ));

      bookRepository.save(new Book(
              null,
              "Head First Design Patterns",
              "Eric Freeman",
              1
      ));

      bookRepository.save(new Book(
              null,
              "Algorithms",
              "Robert Sedgewick",
              0
      ));
      IO.println("Seed executado.");
    }
  }
}