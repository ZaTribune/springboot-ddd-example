INSERT INTO customer (id, first_name, last_name, display_name, type, state)
VALUES (1, 'John', 'Doe', 'Johny Doe', 'STANDARD', 'ACTIVE');
INSERT INTO customer (id, first_name, last_name, display_name, type, state)
VALUES (2, 'Bill', 'Gates', 'Billy the beast', 'STANDARD', 'DISABLED');

INSERT INTO address (id, flat_number, street, postal_code, city, country, customer)
VALUES (1, '16a', 'Losers street', '512345', 'Texas', 'USA', 1);
INSERT INTO address (id, flat_number, street, postal_code, city, country, customer)
VALUES (2, '98', 'Dolphin street', '511111', 'Dubai', 'UAE', 1);
INSERT INTO address (id, flat_number, street, postal_code, city, country, customer)
VALUES (3, '123', 'Ramsis street', '412536', 'Cairo', 'EGY', 1);
INSERT INTO address (id, flat_number, street, postal_code, city, country, customer)
VALUES (4, '000', 'Do not ask me', '000000', 'Jeffery Epstein Island', 'USA', 2);


INSERT INTO product (id, name, company, price, quantity)
VALUES (1, 'Samsung Galaxy S23', 'Samsung', 3112.50, 15);
INSERT INTO product (id, name, company, price, quantity)
VALUES (2, 'Iphone 14 pro max', 'Apple', 2000, 5);
INSERT INTO product (id, name, company, price, quantity)
VALUES (3, 'Xiaomi Note 11', 'Xiaomi', 800, 22);
INSERT INTO product (id, name, company, price, quantity)
VALUES (4, 'Nokia whatever', 'Nokia', 1500, 82);


