INSERT INTO cart (quantity,product_sku) VALUES
	 (2,'MOBILE-APPLE-IPHONE-12-PRO') ON CONFLICT DO NOTHING;
INSERT INTO cart (quantity,product_sku) VALUES
	 (1,'MOBILE-SAMSUNG-GALAXY-S21-ULTRA') ON CONFLICT DO NOTHING;
