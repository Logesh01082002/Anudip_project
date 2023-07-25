package com.example.miniproject.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.miniproject.springproject.entity.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

}
