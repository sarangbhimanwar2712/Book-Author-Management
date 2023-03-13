package com.example.bookAuthorManagement.Repository;

import com.example.bookAuthorManagement.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer>{
}
