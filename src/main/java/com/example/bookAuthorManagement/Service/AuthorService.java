package com.example.bookAuthorManagement.Service;

import com.example.bookAuthorManagement.Model.Author;
import com.example.bookAuthorManagement.Model.Book;
import com.example.bookAuthorManagement.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository ;


    public String addAuthor(String name ,int age ,String gender ,double rating){

        Author author = new Author() ;
        author.setName(name);
        author.setAge(age);
        author.setGender(gender);
        author.setRating(rating);

        authorRepository.save(author) ;

        return "author added successfully" ;
    }

    public int getBooksByAuthorOfRating( double rating){
        List<Author> authorList = authorRepository.findAll() ;

        int count =0 ;
        for(Author author : authorList){
            if(author.getRating()>= rating){
                List<Book> bookList = author.getBookList() ;
                count += bookList.size() ;
            }
        }
        return count ;
    }

    public int totalNoOfBooks(int authorId,int year){

        Author author =authorRepository.findById(authorId).get() ;

        List<Book> bookList = author.getBookList() ;
        int count =0 ;
        for(Book book : bookList){

            if(book.getYearOfPublishing()==year){
                count++ ;
            }
        }
        return count ;
    }
}
