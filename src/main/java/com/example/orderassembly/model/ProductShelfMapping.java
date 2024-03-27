package com.example.orderassembly.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_shelf_mapping")
public class ProductShelfMapping {

    @EmbeddedId
    private ProductShelfMappingId id;

    @ManyToOne
    @MapsId("productId")
    private Product product;

    @ManyToOne
    @MapsId("shelfId")
    private Shelf shelf;

    @Column(nullable = false)
    private boolean isPrimaryShelf;
}
