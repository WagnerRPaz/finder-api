-- liquibase formatted sql
-- changeset wagner:017
CREATE TABLE users(
        id INT PRIMARY KEY AUTO_INCREMENT,
        nome VARCHAR(50) NOT NULL,
        email VARCHAR(50) NOT NULL,
        password VARCHAR(100) NOT NULL,
        telefone INT NOT NULL,
        role VARCHAR(10) NOT NULL
);

-- changeset wagner:018
INSERT INTO users (nome,email, password, telefone, role) VALUES('Wagner','wagner@gmail.com', '123456ww', 999999999,'USER');


-- changeset wagner:021
CREATE TABLE category(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL
);

-- changeset wagner:023
INSERT INTO category (name) VALUES('Pedreiro'),( 'Pintor'), ('Carpinteiro'), ('Faxineiro'), ('Eletricista'), ('Encanador');
-- changeset wagner:024
CREATE TABLE worker(
    worker_id INT PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(80) NOT NULL,
    birth_data DATE NOT NULL,
    phone INT NOT NULL,
    email VARCHAR(80) NOT NULL,
    category_id INT NOT NULL,
    experience INT NOT NULL,
    FOREIGN KEY (category_id) REFERENCES category(id)
);
INSERT INTO worker (full_name, birth_data, phone, email, category_id, experience) VALUES ('Zézinho da Silva', '1970-03-11', 989898987, 'jose@gmail.com', 1 , 12);