package com.example.bookAuthorManagement.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.LifecycleState;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Publish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    private int yearOfPublishing ;

    //Publisher is parent wrt to book and author
    @OneToMany
    List<Book> bookList = new ArrayList<>() ;

    @OneToMany
    List<Author> authorList = new ArrayList<>() ;
}
