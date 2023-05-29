package com.anudip.library1project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.anudip.library1project.models.Book;

public interface Bookrepository extends JpaRepository<Book, Long> {
}
