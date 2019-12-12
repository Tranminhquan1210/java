CREATE TABLE role (
  id int not null primary key,
  name varchar(50),
  description varchar(50)
);

INSERT INTO role (id, name, description) VALUES (1, 'ADMIN', 'Administrator');
INSERT INTO role (id, name, description) VALUES (2, 'MNG', 'Manager');
INSERT INTO role (id, name, description) VALUES (3, 'PL', 'Project Leader');
INSERT INTO role (id, name, description) VALUES (4, 'DEV', 'Developer');

CREATE TABLE user (
  id int not null primary key,
  username varchar(50),
  password varchar(50),
  email varchar(100),
  first_name varchar(50),
  last_name varchar(50)
);

INSERT INTO user (id, username, password, email) VALUES (1, 'admin', '123456', 'admin@gmail.com');
INSERT INTO user (id, username, password, email) VALUES (2, 'vdlson', '123456', 'vdlson@gmail.com');
INSERT INTO user (id, username, password, email) VALUES (3, 'lam-son', '123456', 'lam-son@gmail.com');

CREATE TABLE user_role (
  user_id int not null,
  role_id int not null,
  CONSTRAINT user_role_pk PRIMARY KEY (user_id, role_id)
);

INSERT INTO user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO user_role (user_id, role_id) VALUES (3, 3);