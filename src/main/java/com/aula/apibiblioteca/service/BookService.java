package com.aula.apibiblioteca.service;

import com.aula.apibiblioteca.dto.book.BookPatchDTO;
import com.aula.apibiblioteca.model.book.Book;
import com.aula.apibiblioteca.repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

  private final BookRepository bookRepository;

  public Page<Book> findAll(@PageableDefault(size = 10, sort = "title") Pageable pageable) {
    return bookRepository.findAll(pageable);
  }

  public Book findById(String id) {
    return bookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Livro não encontrado."));
  }

  public Book save(Book user) {
    return bookRepository.save(user);
  }

  public Book update(String id, Book user) {
    Book bookTemp = findById(id);
    bookTemp.update(user);
    bookRepository.save(bookTemp);
    return bookTemp;
  }

  public Book patch(String id, BookPatchDTO dto) {
    Book bookTemp = findById(id);
    bookTemp.patch(dto);
    bookRepository.save(bookTemp);
    return bookTemp;
  }

  public void delete(String id) {
    findById(id);
    bookRepository.deleteById(id);
  }
}
