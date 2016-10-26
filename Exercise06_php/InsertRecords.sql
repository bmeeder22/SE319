/*
-- Query: select * from users
LIMIT 0, 10000

-- Date: 2016-10-25 19:38
*/
INSERT INTO `users` (`username`,`password`,`email`,`phone`,`librarian`,`first_name`,`last_name`) VALUES ('librarian','password','neig@test.gmail.com',1234567890,1,'Librarian','User');
INSERT INTO `users` (`username`,`password`,`email`,`phone`,`librarian`,`first_name`,`last_name`) VALUES ('neig','test','neig@test.gmail.com',1234567890,1,'Noah','Eigenfeld');
INSERT INTO `users` (`username`,`password`,`email`,`phone`,`librarian`,`first_name`,`last_name`) VALUES ('student','password','neig@test.gmail.com',1234567890,0,'Student','User');
/*
-- Query: select * from books
LIMIT 0, 10000

-- Date: 2016-10-25 19:38
*/
INSERT INTO `books` (`book_id`,`book_title`,`author`,`availability`) VALUES (0,'Moby Dick','Herman Melville',1);
INSERT INTO `books` (`book_id`,`book_title`,`author`,`availability`) VALUES (1,'Tom Sawyer','Mark Twain',1);
INSERT INTO `books` (`book_id`,`book_title`,`author`,`availability`) VALUES (2,'Wolf in White Van','John Darnielle',1);
INSERT INTO `books` (`book_id`,`book_title`,`author`,`availability`) VALUES (3,'Hamlet','William Shakespeare',1);
INSERT INTO `books` (`book_id`,`book_title`,`author`,`availability`) VALUES (4,'King Lear','William Shakespeare',1);
INSERT INTO `books` (`book_id`,`book_title`,`author`,`availability`) VALUES (5,'Something Wicked This Way Comes','Ray Bradbury',1);
INSERT INTO `books` (`book_id`,`book_title`,`author`,`availability`) VALUES (6,'The Cat in the Hat','Dr. Seuss',1);
INSERT INTO `books` (`book_id`,`book_title`,`author`,`availability`) VALUES (7,'Invisible Man','Ralph Ellison',1);
INSERT INTO `books` (`book_id`,`book_title`,`author`,`availability`) VALUES (8,'The Winds of Winter','George R. R. Martin',1);
INSERT INTO `books` (`book_id`,`book_title`,`author`,`availability`) VALUES (9,'The Origin of Species','Charles Darwin',1);
INSERT INTO `books` (`book_id`,`book_title`,`author`,`availability`) VALUES (10,'A Brief History of Time','Stephen Hawking',1);
INSERT INTO `books` (`book_id`,`book_title`,`author`,`availability`) VALUES (11,'Guns, Germs, and Steel','Jared Diamond',1);
INSERT INTO `books` (`book_id`,`book_title`,`author`,`availability`) VALUES (12,'Artsy Fartsy Book of Sculptures','The Artist Formerly Known As Jay',1);
INSERT INTO `books` (`book_id`,`book_title`,`author`,`availability`) VALUES (13,'Artsy Fartsy Book of Paintings','The Artist Formerly Known As Jay',1);
INSERT INTO `books` (`book_id`,`book_title`,`author`,`availability`) VALUES (14,'Artsy Fartsy Book of Architecture','The Artist Formerly Known As Jay',1);
INSERT INTO `books` (`book_id`,`book_title`,`author`,`availability`) VALUES (15,'Artsy Fartsy Book of Video Games','The Artist Formerly Known As Jay',1);
INSERT INTO `books` (`book_id`,`book_title`,`author`,`availability`) VALUES (16,'Sports, sports, sports','Jeff Goldblum',1);
INSERT INTO `books` (`book_id`,`book_title`,`author`,`availability`) VALUES (17,'I like Baseball','Jeff Goldblum',1);
INSERT INTO `books` (`book_id`,`book_title`,`author`,`availability`) VALUES (18,'I hate Baseball','Jeff Goldblum',1);
INSERT INTO `books` (`book_id`,`book_title`,`author`,`availability`) VALUES (19,'I Have a Complicated Relationship with Baseball','Jeff Goldblum',1);
INSERT INTO `books` (`book_id`,`book_title`,`author`,`availability`) VALUES (20,'Who Cares About Baseball?','Jeff Goldblum',1);
INSERT INTO `books` (`book_id`,`book_title`,`author`,`availability`) VALUES (21,'Nobody, Thats Who','Jeff Goldblum',1);
INSERT INTO `books` (`book_id`,`book_title`,`author`,`availability`) VALUES (22,'Especially Not Me','Jeff Goldblum',1);
INSERT INTO `books` (`book_id`,`book_title`,`author`,`availability`) VALUES (23,'I Love Football Now','Jeff Goldblum',1);
/*
-- Query: select * from shelves
LIMIT 0, 10000

-- Date: 2016-10-25 19:38
*/
INSERT INTO `shelves` (`shelf_id`,`shelf_name`,`book_id`) VALUES (1,'Art',12);
INSERT INTO `shelves` (`shelf_id`,`shelf_name`,`book_id`) VALUES (1,'Art',13);
INSERT INTO `shelves` (`shelf_id`,`shelf_name`,`book_id`) VALUES (1,'Art',14);
INSERT INTO `shelves` (`shelf_id`,`shelf_name`,`book_id`) VALUES (1,'Art',15);
INSERT INTO `shelves` (`shelf_id`,`shelf_name`,`book_id`) VALUES (2,'Science',11);
INSERT INTO `shelves` (`shelf_id`,`shelf_name`,`book_id`) VALUES (2,'Science',10);
INSERT INTO `shelves` (`shelf_id`,`shelf_name`,`book_id`) VALUES (2,'Science',9);
INSERT INTO `shelves` (`shelf_id`,`shelf_name`,`book_id`) VALUES (3,'Sports',16);
INSERT INTO `shelves` (`shelf_id`,`shelf_name`,`book_id`) VALUES (3,'Sports',17);
INSERT INTO `shelves` (`shelf_id`,`shelf_name`,`book_id`) VALUES (3,'Sports',18);
INSERT INTO `shelves` (`shelf_id`,`shelf_name`,`book_id`) VALUES (3,'Sports',19);
INSERT INTO `shelves` (`shelf_id`,`shelf_name`,`book_id`) VALUES (3,'Sports',20);
INSERT INTO `shelves` (`shelf_id`,`shelf_name`,`book_id`) VALUES (3,'Sports',21);
INSERT INTO `shelves` (`shelf_id`,`shelf_name`,`book_id`) VALUES (3,'Sports',22);
INSERT INTO `shelves` (`shelf_id`,`shelf_name`,`book_id`) VALUES (3,'Sports',23);
INSERT INTO `shelves` (`shelf_id`,`shelf_name`,`book_id`) VALUES (4,'Literature',0);
INSERT INTO `shelves` (`shelf_id`,`shelf_name`,`book_id`) VALUES (4,'Literature',1);
INSERT INTO `shelves` (`shelf_id`,`shelf_name`,`book_id`) VALUES (4,'Literature',2);
INSERT INTO `shelves` (`shelf_id`,`shelf_name`,`book_id`) VALUES (4,'Literature',3);
INSERT INTO `shelves` (`shelf_id`,`shelf_name`,`book_id`) VALUES (4,'Literature',4);
INSERT INTO `shelves` (`shelf_id`,`shelf_name`,`book_id`) VALUES (4,'Literature',5);
INSERT INTO `shelves` (`shelf_id`,`shelf_name`,`book_id`) VALUES (4,'Literature',6);
INSERT INTO `shelves` (`shelf_id`,`shelf_name`,`book_id`) VALUES (4,'Literature',7);
INSERT INTO `shelves` (`shelf_id`,`shelf_name`,`book_id`) VALUES (4,'Literature',8);
