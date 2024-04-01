# Finder API
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)

O projeto Finder foi desenvolvido como parte do meu Trabalho de Conclusão de Curso (TCC). Essa é a parte do backend da aplicação, que nada mais é do que uma API que conecta indivíduos ou empresas que precisam de habilidades ou serviços específicos com prestadores qualificados.

## Funcionalidades

- **Cadastro de Usuários**
- **Cadastro de Tipo de Serviço**
- **Cadastro de Prestadores de Serviços**
- **Avaliação dos Prestadores de Serviços**
- **Autenticação**

## Tecnologias Utilizadas
  - Java 17
  - Spring Boot
  - Spring Security
  - JWT

## Banco de Dados
Esse projeto utiliza [MySQL](https://www.mysql.com/) como banco de dados. As migrations necessárias são gerenciadas usando Liquibase.

## Autenticação
A API usa Spring Security para controle de autenticação. As seguintes funções estão disponíveis:
```
USER -> Função padrão dada a novos usuários para realizar a autenticação.
ADMIN -> A função ADMIN é praticamente apenas para o desenvolvedor, possuindo telas que somente o mesmo poderá visualizar, assim como ações, botões e etc.
```

## Instalação

Para usar a API do Finder, siga estes passos:

1. Clone o repositório:
```
git clone https://github.com/WagnerRPaz/finder-api.git
```
2. Instale as dependências com o Maven
3. Instale o banco de dados MySQL
