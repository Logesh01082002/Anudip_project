package com.example.miniproject.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.miniproject.springproject.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
