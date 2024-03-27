package com.example.orderassembly.controller;

import com.example.orderassembly.model.Shelf;
import com.example.orderassembly.service.ShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shelves")
public class ShelfController {

    @Autowired
    private ShelfService shelfService;

    @GetMapping
    public List<Shelf> getAllShelves() {
        return shelfService.getAllShelves();
    }

    @PostMapping
    public Shelf createShelf(@RequestBody Shelf shelf) {
        return shelfService.createShelf(shelf);
    }
}
