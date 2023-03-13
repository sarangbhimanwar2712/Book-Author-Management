package com.example.bookAuthorManagement.Repository;

import com.example.bookAuthorManagement.Model.Publish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublishRepository extends JpaRepository<Publish ,Integer> {
}
