package com.example.bookAuthorManagement.Controller;

import com.example.bookAuthorManagement.Model.Book;
import com.example.bookAuthorManagement.Service.BookServcie;
import org.springframework.aop.target.LazyInitTargetSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Book")
public class BookController {

    @Autowired
    BookServcie bookServcie ;

    @PostMapping("add")
    public String addBook(@RequestParam String name, @RequestParam String authorName , @RequestParam int pages, @RequestParam int year){
        return bookServcie.addBook(name,authorName,pages,year) ;
    }

    @GetMapping("/recentbooks")
    public List<Book> mostrecentbook(){
        return bookServcie.mostrecentbook() ;
    }


}
