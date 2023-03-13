package com.example.bookAuthorManagement.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="Author")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String name ;
    private int age ;
    private String gender ;
    private double rating ;

    //Author is parent wrt book
    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    List<Book> bookList = new ArrayList<>() ;

    @ManyToOne
    @JoinColumn
    private Publish publish ;
}
