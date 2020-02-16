DROP TABLE IF EXISTS books;

CREATE TABLE IF NOT EXISTS books
(
  id     SERIAL PRIMARY KEY,
  name   VARCHAR(250) NOT NULL,
  author VARCHAR(250),
  count  INTEGER NOT NULL CHECK ( count >= 0 )
);

INSERT INTO books(name, author, count)
VALUES
('Glimpses of World History', 'Jawaharlal Nehru', 4),
('Prison Diary', 'Jay Prakash Narayan', 1),
('Why Socialism', 'Jayaprakash Narayan', 0);

DROP TABLE IF EXISTS users;

CREATE TABLE IF NOT EXISTS users
(
  id       SERIAL PRIMARY KEY,
  username     VARCHAR(250) NOT NULL,
  password VARCHAR(250)
);

INSERT INTO users(username, password)
VALUES ('Yuting1', 'password1'),
       ('Yuting2', 'password2'),
       ('Yuting3', 'password3');

