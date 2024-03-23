CREATE TABLE IF NOT EXISTS cart (
	shopper_id int4 NOT NULL,
	products text NULL,
	promotions text NULL,
	CONSTRAINT cart_pk PRIMARY KEY (shopper_id)
);
