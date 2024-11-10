use todo_db;
INSERT INTO user (uuid,last_name,first_name,user_name,email ,password)VALUES
('00000000000000000000000000000001', 'user1' , 'name1' ,'user1', 'user1@gmail.com' , 'password'),
('00000000000000000000000000000002', 'user2' , 'name2' ,'user2', 'user2@gmail.com' , 'password');

INSERT INTO role (name)VALUES
('ROLE_ADMIN'),
('ROLE_USER');

INSERT INTO user_role (user_id,role_id)VALUES
(1,1),
(2,2);