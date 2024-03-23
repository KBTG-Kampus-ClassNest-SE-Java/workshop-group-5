INSERT INTO cart (shopper_id,products,promotions) VALUES
	 (1,'[{"id":8,"sku":"MOBILE-OPPO-FIND-X3-PRO","quantity":2}]',NULL) ON CONFLICT DO NOTHING;
INSERT INTO cart (shopper_id,products,promotions) VALUES
	 (2,'[{"id":8,"sku":"MOBILE-OPPO-FIND-X3-PRO","quantity":2}]',NULL) ON CONFLICT DO NOTHING;
