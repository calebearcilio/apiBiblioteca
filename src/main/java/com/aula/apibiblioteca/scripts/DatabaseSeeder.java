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

      User user1 = new User();
      user1.setName("Calebe");
      user1.setEmail("calebe@email.com");
      User user2 = new User();
      user2.setName("Maria");
      user2.setEmail("maria@email.com");

      userRepository.save(user1);
      userRepository.save(user2);

      Book book1 = new Book();
      book1.setTitle("Harry Potter");
      book1.setAuthor("J.K. Rowling");
      book1.setAmount(10);
      Book book2 = new Book();
      book2.setTitle("Senhor dos Anéis");
      book2.setAuthor("J.R.R. Tolkien");
      bookRepository.save(book1);
      bookRepository.save(book2);

      System.out.println("Seed executado.");
    }
  }
}