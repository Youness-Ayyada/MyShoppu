insert into public.user(id, username, password, first_name, last_name, email_address, address, active)
    values (0, 'root', '$2a$10$XpLVTvFHekyqAIvKkPIwuuKXiL/3RNswPldw85T6MtDFQcxo2OUve', 'Root', 'Root', 'root@local.host', 'root address', true);
insert into user_type(id, username, user_type, active) values (0, 'root', 'ROLE_SUPERADMIN', true);

insert into shop(id, name, active) values (0, 'MohammedShop', true);
insert into shop(id, name, active) values (1, 'Salih coordonnier', true);
insert into shop(id, name, active) values (2, 'Confiture Mehdi', true);

insert into category(id, name, active) values (0, 'Root', true);
insert into category(id, name, parent_category_id, active) values (1, 'Kitchen', 0, true);
insert into category(id, name, parent_category_id, active) values (2, 'Food', 1, true);
insert into category(id, name, parent_category_id, active) values (3, 'Ustensiles', 1, true);
insert into category(id, name, parent_category_id, active) values (4, 'Clothes', 0, true);
insert into category(id, name, parent_category_id, active) values (5, 'Shoes', 4, true);
insert into category(id, name, parent_category_id, active) values (6, 'Home', 0, true);
insert into category(id, name, parent_category_id, active) values (7, 'Carpet', 6, true);
insert into category(id, name, parent_category_id, active) values (8, 'Bikes', 0, true);
insert into category(id, name, parent_category_id, active) values (9, 'Dirt Bikes', 5, true);
insert into category(id, name, parent_category_id, active) values (10, 'Books', 0, true);
insert into category(id, name, parent_category_id, active) values (11, 'Literature', 10, true);
insert into category(id, name, parent_category_id, active) values (12, 'Fiction', 10, true);
insert into category(id, name, parent_category_id, active) values (13, 'Science', 10, true);

insert into product(id, name, description, image, barcode, shop_id, category_id, price, quantity, weight, discount, active) 
    values (0, 'tajine', 'traditional tajine made of clay with a moroccan design', 'oldtajine.jpg', '123456', 0, 3, 45, 5, 250, 0, true);
insert into product(id, name, description, image, barcode, shop_id, category_id, price, quantity, weight, discount, active)
    values (1, 'Traditional sandals', ' leathermade red sandals with a moroccan style', 'redsandals.jpg', '654321', 1, 5, 900, 5, 200, 0, true);
insert into product(id, name, description, image, barcode, shop_id, category_id, price, quantity, weight, discount, active) 
    values (2, 'Strwberry jam', 'homemade strawberry jam', 'strawberryjam.jpg', '743987', 2, 2, 1100, 5, 200, 0, true);
insert into product(id, name, description, image, barcode, shop_id, category_id, price, quantity, weight, discount, active) 
    values (3, 'Red Carpet', 'Red traditional Carpet.', 'redcarpet.jpg', '769654', 0, 7, 1300, 5, 200, 0, true);