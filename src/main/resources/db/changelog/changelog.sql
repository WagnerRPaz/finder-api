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


-- changeset wagner:027
CREATE TABLE category(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(500) NOT NULL
);

-- changeset wagner:028
INSERT INTO category (name, description) VALUES('Pedreiro', 'Profissional responsável pela execução de atividades de construção e manutenção de edifícios, casas, estruturas e obras em geral.'),
                                               ('Pintor', 'Profissional responsável por utilizar técnicas de pintura para aplicar tintas em superfícies, com o objetivo de criar efeitos estéticos e/ou proteger e preservar os materiais.'),
                                               ('Carpinteiro', 'Profissional responsável por construir e reparar estruturas e outros objetos compostos por madeira. Em sua atuação, eles cortam, lixam, montam e instalam móveis e outros materiais.'),
                                               ('Faxineiro', 'Profissional responsável por realizar a limpeza e a conservação de ambientes, sejam eles residenciais, comerciais, industriais ou públicos.'),
                                               ('Eletricista', 'Profissional responsável pela implementação, manutenção e reparação de instalações elétricas, tanto residenciais quanto industriais.'),
                                               ('Encanador', 'Profissional responsável por instalar e prover a manutenção de sistemas hidráulicos (água e esgoto) de residências, estabelecimentos e indústrias.'),
                                               ('Jardineiro', 'Profissional responsável pela implantação, criação e manutenção de jardins, poda de árvores, cuidado de flores de ambiente interno e externo e corte de grama.'),
                                               ('Babá', 'Profissional que cuida de bebês e crianças, zelando pelo bem-estar, saúde, alimentação, higiene pessoal, educação, cultura, recreação e lazer.'),
                                               ('Cozinheiro', 'Profissional responsável por preparar pratos, atentando para as especificações da comanda ou cardápio.'),
                                               ('Vidraceiro', 'Profissional responsável pela instalação, reparo e manutenção de produtos de vidro.'),
                                               ('Marido de aluguel', 'Profissional responsável por fazer pequenos consertos e reparos em residências.'),
                                               ('Instalação de eletrônicos', 'Profissional responsável pela instalação, manutenção e reparo de dispositivos eletrônicos.');
-- changeset wagner:030
CREATE TABLE worker(
    worker_id INT PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(80) NOT NULL,
    birth_data DATE NOT NULL,
    phone INT NOT NULL,
    email VARCHAR(80) NOT NULL,
    category_id INT NOT NULL,
    experience INT NOT NULL,
    summary VARCHAR(500),
    FOREIGN KEY (category_id) REFERENCES category(id)
);