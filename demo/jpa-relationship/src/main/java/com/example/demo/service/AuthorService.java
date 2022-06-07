package com.example.demo.service;

import com.example.demo.entity.Author;
import com.example.demo.entity.Book;

import java.util.List;

public interface AuthorService {
    Book saveBook(Book book);
    Author saveAuthor(Author author);
    void addBookToAuthor(String authorName, String bookName);

    List<Book> getBooks();
    Book getBook(Long id);
    List<Author> getAuthors();
    Author getAuthor(Long id);
}
