--DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  phone VARCHAR(250)  NOT NULL,
  email VARCHAR(250)  UNIQUE NOT NULL
);

INSERT INTO users (id, first_name, last_name, phone, email) VALUES
  (0,'john', 'smith', '0011222', 'john@smith.com');