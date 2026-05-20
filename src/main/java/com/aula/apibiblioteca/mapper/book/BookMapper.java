package com.aula.apibiblioteca.mapper.book;


import com.aula.apibiblioteca.dto.book.BookRequestDTO;
import com.aula.apibiblioteca.dto.book.BookResponseDTO;
import com.aula.apibiblioteca.model.book.Book;

public class BookMapper {

  public static Book toEntity(BookRequestDTO dto) {
    Book book = new Book();
    book.setTitle(dto.title());
    book.setAuthor(dto.author());
    book.setAmount(dto.amount());
    return book;
  }

  public static BookResponseDTO toDTO(Book book) {
    return new BookResponseDTO(book.getId(), book.getTitle(), book.getAuthor(), book.getAmount());
  }
}
