package com.example.bookAuthorManagement.Repository;

import com.example.bookAuthorManagement.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {

    public Author findByName(String author) ;
}
