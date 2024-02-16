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
