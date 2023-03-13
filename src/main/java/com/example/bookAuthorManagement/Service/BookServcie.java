package com.example.bookAuthorManagement.Service;

import com.example.bookAuthorManagement.Model.Author;
import com.example.bookAuthorManagement.Model.Book;
import com.example.bookAuthorManagement.Model.Publish;
import com.example.bookAuthorManagement.Repository.AuthorRepository;
import com.example.bookAuthorManagement.Repository.BookRepository;
import com.example.bookAuthorManagement.Repository.PublishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BookServcie {
    @Autowired
    BookRepository bookRepository ;

    @Autowired
    AuthorRepository authorRepository ;

    @Autowired
    PublishRepository publishRepository ;

    public String addBook(String name,String authorName ,int pages,int year){

        Book book = new Book() ;
        book.setBookName(name);
        book.setAuthorName(authorName);
        book.setNoOfPages(pages);
        book.setYearOfPublishing(year) ;

        Author author = authorRepository.findByName(authorName) ;
        book.setAuthor(author);


        List<Book> bookList = author.getBookList() ;
        bookList.add(book) ;
        author.setBookList(bookList);

        Publish publish = new Publish() ;
        publish.setYearOfPublishing(year);

        book = bookRepository.save(book);
        author =authorRepository.save(author) ;
        publish = publishRepository.save(publish) ;

        return "Book added successfully" ;
    }

    public List<Book> mostrecentbook(){

        List<Book> bookList = new ArrayList<>() ;
        List<Author> authorList = authorRepository.findAll() ;
        int size =0 ;
        for(Author author :authorList){

            List<Book> bookList1 = author.getBookList() ;
            size = bookList1.size() ;
            bookList.add(bookList1.get(size-1)) ;
        }
        return bookList ;
    }
}
