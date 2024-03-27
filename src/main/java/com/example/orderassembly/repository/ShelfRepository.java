package com.example.orderassembly.repository;

import com.example.orderassembly.model.Shelf;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShelfRepository extends JpaRepository<Shelf, Long> {
}
