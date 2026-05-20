package com.aula.apibiblioteca.model.book;

import com.aula.apibiblioteca.dto.book.BookPatchDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
  @Id
  @UuidGenerator
  private String id;
  @Column(nullable = false, unique = true)
  private String title;
  @Column(nullable = false)
  private String author;
  private int amount = 0;

  public void update(Book book) {
    title = book.title;
    author = book.author;
    amount = book.amount;
  }

  public void patch(BookPatchDTO dto) {
    if (dto.title() != null && !dto.title().isBlank()) {
      title = dto.title();
    }

    if (dto.author() != null && !dto.author().isBlank()) {
      author = dto.author();
    }

    if (dto.amount() > 0) {
      amount = dto.amount();
    }
  }
}
