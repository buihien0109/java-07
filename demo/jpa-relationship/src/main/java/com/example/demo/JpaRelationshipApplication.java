package com.example.demo;

import com.example.demo.entity.Address;
import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AuthorService;
import com.example.demo.service.UserService;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JpaRelationshipApplication {
    public static void main(String[] args) {
        SpringApplication.run(JpaRelationshipApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(UserService userService, AuthorService authorService) {
        return args -> {
            // One to one
//            userService.saveAddress(new Address(null, "ha noi"));
//            userService.saveAddress(new Address(null, "hai phong"));
//            userService.saveAddress(new Address(null, "thai binh"));
//
//            userService.saveUser(new User(null, "hien", "hien@gmail.com", "111", null));
//            userService.saveUser(new User(null, "hang", "hang@gmail.com", "222", null));
//            userService.saveUser(new User(null, "duy", "duy@gmail.com", "333", null));
//
//            userService.addAddressToUser("hien", "ha noi");
//            userService.addAddressToUser("hang", "hai phong");
//            userService.addAddressToUser("duy", "thai binh");

            // One to many
            authorService.saveAuthor(new Author(null, "hien"));
            authorService.saveAuthor(new Author(null, "hang"));

            authorService.saveBook(new Book(null, "book 1", null));
            authorService.saveBook(new Book(null, "book 2", null));
            authorService.saveBook(new Book(null, "book 3", null));
            authorService.saveBook(new Book(null, "book 4", null));
            authorService.saveBook(new Book(null, "book 5", null));

            authorService.addBookToAuthor("hien", "book 1");
            authorService.addBookToAuthor("hien", "book 2");
            authorService.addBookToAuthor("hang", "book 3");
            authorService.addBookToAuthor("hang", "book 4");
            authorService.addBookToAuthor("hang", "book 5");
        };
    }
}
