package com.example.orderassembly.service;

import com.example.orderassembly.model.Shelf;
import com.example.orderassembly.repository.ShelfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShelfService {

    @Autowired
    private ShelfRepository shelfRepository;

    public List<Shelf> getAllShelves() {
        return shelfRepository.findAll();
    }

    public Shelf createShelf(Shelf shelf) {
        return shelfRepository.save(shelf);
    }
}
