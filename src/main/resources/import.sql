INSERT INTO role(name)VALUES('ROLE_USER'),('ROLE_ADMIN')
INSERT INTO USER_API(password,user_name) VALUES ('$2a$10$Xpt6I9eHtG0ha.JZruS4u.rmb5E7DhDD6R22Jubu0UEZ9n2uemyQi','ludo')
INSERT INTO USER_API(password,user_name)VALUES ('$2a$10$Xpt6I9eHtG0ha.JZruS4u.rmb5E7DhDD6R22Jubu0UEZ9n2uemyQi','Greg')
INSERT INTO USER_API_ROLES(user_api_id,roles_id)VALUES(1,1),(1,2),(2,1)
INSERT INTO category(name)VALUES('tea'),('coffee'),('miscellanous')
INSERT INTO product (image_url,name,price,quantity,reference,category_id)VALUES('https://picsum.photos/200/300/?random','Wulong chinese tea',12.80,5,'p560dc67IOPER',1),('https://picsum.photos/200/300/?random','Chinese green tea',9.60,14,'p560dc67IOPDR',1),('https://picsum.photos/200/300/?random','Arabica coffee',9.50,8,'GH789JKL678HG',2),('https://picsum.photos/200/300/?random','Cohiba cigars',34.40,42,'DFG678GHJERT4',3)