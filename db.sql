CREATE TABLE products (
                          product_id SERIAL PRIMARY KEY,
                          name VARCHAR(255) NOT NULL
);

CREATE TABLE shelves (
                         shelf_id SERIAL PRIMARY KEY,
                         name VARCHAR(255) NOT NULL
);

CREATE TABLE orders (
                        order_id SERIAL PRIMARY KEY,
                        product_id INT NOT NULL,
                        quantity INT NOT NULL,
                        additional_shelf VARCHAR(255),
                        order_number VARCHAR(255) NOT NULL,
                        FOREIGN KEY (product_id) REFERENCES products(product_id)
);

CREATE TABLE product_shelf_mapping (
                                       product_id INT NOT NULL,
                                       shelf_id INT NOT NULL,
                                       is_primary_shelf BOOLEAN,
                                       FOREIGN KEY (product_id) REFERENCES products(product_id),
                                       FOREIGN KEY (shelf_id) REFERENCES shelves(shelf_id),
                                       PRIMARY KEY (product_id, shelf_id)
);
