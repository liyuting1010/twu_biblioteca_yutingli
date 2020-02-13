CREATE TABLE books
(
  id     SERIAL PRIMARY KEY,
  name   VARCHAR(250) NOT NULL,
  author VARCHAR(250)
);

CREATE TABLE movies
(
  id            SERIAL PRIMARY KEY,
  name          VARCHAR(250) NOT NULL,
  category VARCHAR(250)
);

INSERT INTO books(name, author)
VALUES
('Glimpses of World History', 'Jawaharlal Nehru'),
('Prison Diary', 'Jay Prakash Narayan'),
('Why Socialism', 'Jayaprakash Narayan');

INSERT INTO movies(name, category)
VALUES
('DANGAL', 'Comedy'),
('Hichki', 'Action'),
('Jodhaa Akbar', 'Historical');
