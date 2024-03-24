CREATE TABLE IF NOT EXISTS cart (
	cart_id varchar NOT NULL,
	shopper_id int4 NULL,
	promotions varchar NULL,
	CONSTRAINT cart_pk PRIMARY KEY (cart_id)
);
