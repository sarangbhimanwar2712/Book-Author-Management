package com.example.bookAuthorManagement.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "Books")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    private String bookName ;
    private String authorName ;
    private int noOfPages ;
    private int yearOfPublishing ;

    //As book is child wrt to author
    @ManyToOne
    @JoinColumn
    private Author author ;

    @ManyToOne
    @JoinColumn
    private Publish publish ;
}
