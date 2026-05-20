package com.aula.apibiblioteca.controller;

import com.aula.apibiblioteca.dto.book.BookPatchDTO;
import com.aula.apibiblioteca.dto.book.BookRequestDTO;
import com.aula.apibiblioteca.dto.book.BookResponseDTO;
import com.aula.apibiblioteca.mapper.book.BookMapper;
import com.aula.apibiblioteca.model.book.Book;
import com.aula.apibiblioteca.service.BookService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

  private final BookService bookService;

  @GetMapping
  public ResponseEntity<Page<BookResponseDTO>> getAll(Pageable pageable) {
    Page<BookResponseDTO> books = bookService.findAll(pageable).map(book -> BookMapper.toDTO(book));
    return ResponseEntity.ok(books);
  }

  @GetMapping("/{id}")
  public ResponseEntity<BookResponseDTO> getById(@PathVariable String id) {
    try {
      Book book = bookService.findById(id);
      return ResponseEntity.ok(BookMapper.toDTO(book));
    } catch (Exception e) {
      if (e instanceof EntityNotFoundException) {
        return ResponseEntity.notFound().build();
      }

      return ResponseEntity.internalServerError().build();
    }
  }

  @PostMapping
  public ResponseEntity<BookResponseDTO> post(@RequestBody @Valid BookRequestDTO dto) {
    try {
      Book book = BookMapper.toEntity(dto);
      var bookCreated = bookService.save(book);
      return ResponseEntity.status(201).body(BookMapper.toDTO(bookCreated));
    } catch (Exception e) {
      if (e instanceof DataIntegrityViolationException) {
        return ResponseEntity.status(409).build();
      }
      IO.print(e);
      return ResponseEntity.internalServerError().build();
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<BookResponseDTO> update(@PathVariable String id, @RequestBody @Valid BookRequestDTO dto) {
    try {
      var updateBook = bookService.update(id, BookMapper.toEntity(dto));
      return ResponseEntity.ok(BookMapper.toDTO(updateBook));
    } catch (Exception e) {
      if (e instanceof EntityNotFoundException) {
        return ResponseEntity.notFound().build();
      }

      return ResponseEntity.internalServerError().build();
    }
  }

  @PatchMapping("/{id}")
  public ResponseEntity<BookResponseDTO> patch(@PathVariable String id, @RequestBody BookPatchDTO dto) {
    try {
      Book updatedBook = bookService.patch(id, dto);
      return ResponseEntity.ok(BookMapper.toDTO(updatedBook));
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
      bookService.delete(id);
      return ResponseEntity.ok().build();
    } catch (Exception e) {
      if (e instanceof EntityNotFoundException) {
        return ResponseEntity.notFound().build();
      }

      return ResponseEntity.internalServerError().build();
    }
  }
}
