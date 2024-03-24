CREATE TABLE IF NOT EXISTS cart_item (
    id SERIAL PRIMARY KEY,
    cart_id int NOT NULL,
    product_id int NOT NULL,
    quantity int4 NULL
);
