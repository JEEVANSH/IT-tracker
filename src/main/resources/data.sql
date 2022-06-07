----Admin
INSERT INTO admin(id,email,name)VALUES
(1,"admin_a@gmail.com","admin_a"),(2,"admin_b@gmail.com","admin_b"),
(3,"admin_c@gmail.com","admin_c"),(4,"admin_d@gmail.com","admin_d");

----Users
INSERT INTO users (user_id,name,email) 
VALUES(101,"user_a","user_a@gmail.com"),(102,"user_b","user_b@gmail.com"),
(103,"user_c","user_c@gmail.com"),(104,"user_d","user_4@gmail.com");

----Status
INSERT INTO status (status_id,status_msg)
VALUES(1,"Open"),(2,"Assigned"),(3,"In Progess"),(4,"Completed");

----priority
INSERT INTO priority (priority_id,priority_msg)
VALUES (1,"Low"),(2,"Medium"),(3,"High"),(4,"Critical");

----Category
INSERT INTO category (category_id,category_msg) 
VALUES(1,"Hardware"),(2,"Software"),(3,"Access Management");

----SubCategory
INSERT INTO sub_category (sub_category_id,sub_category_msg,category_id) 
VALUES
(1,"Allocate Laptop",(SELECT category_id FROM category WHERE category_id =1)),
(2,"Allocate Hardware",(SELECT category_id FROM category WHERE category_id =1)),
(3,"Hardware Repalcement",(SELECT category_id FROM category WHERE category_id =1)),
(4,"Software Installation",(SELECT category_id FROM category WHERE category_id =2)),
(5,"Antivirus",(SELECT category_id FROM category WHERE category_id =2)),
(6,"Email password update",(SELECT category_id FROM category WHERE category_id =2)),
(7,"Laptop slowness issue",(SELECT category_id FROM category WHERE category_id =2)),
(8,"Software issue",(SELECT category_id FROM category WHERE category_id =2)),
(9,"Software Access",(SELECT category_id FROM category WHERE category_id =3)),
(10,"Wi-fi Access",(SELECT category_id FROM category WHERE category_id =3)),
(11,"Database Access",(SELECT category_id FROM category WHERE category_id =3)),
(12,"VPN Access",(SELECT category_id FROM category WHERE category_id =3));

