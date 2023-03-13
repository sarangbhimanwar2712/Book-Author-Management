package com.example.bookAuthorManagement.Controller;

import com.example.bookAuthorManagement.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Authors")
public class AuthorController {

    @Autowired
    AuthorService authorService ;

    @PostMapping("/add")
    public String addAuthor(@RequestParam String name ,@RequestParam int age ,@RequestParam String gender ,@RequestParam double rating){

        return authorService.addAuthor(name,age,gender,rating) ;
    }

    @GetMapping("/getBookByAuthor")
    public int getBooksByAuthorOfRating( @RequestParam double rating){

        return authorService.getBooksByAuthorOfRating(rating) ;
    }

    @GetMapping("booksInYear")
    public int getBooksInYear(@RequestParam int authorId ,@RequestParam int year){
        return authorService.totalNoOfBooks(authorId,year) ;
    }
}
