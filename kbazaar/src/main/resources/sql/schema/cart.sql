CREATE TABLE IF NOT EXISTS cart (
	cart_id SERIAL NOT NULL,
	shopper_id int NULL,
	promotions varchar NULL,
	CONSTRAINT cart_pk PRIMARY KEY (cart_id)
);
