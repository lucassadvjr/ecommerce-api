# ecommerce-api

Projeto backend de e-commerce feito em **Java + Spring Boot** para praticar desenvolvimento de API REST, organização em camadas e integração com API externa.

## O que o projeto faz

Atualmente a aplicação:

- lista produtos
- busca produto por id
- consome dados de uma API externa
- converte os dados para um modelo interno
- trata erro de produto não encontrado
- possui testes unitários na camada de service

---

## Tecnologias usadas

- Java 17
- Spring Boot
- Maven
- Lombok
- RestTemplate
- JUnit 5
- Mockito

---

## Estrutura do projeto

O projeto foi separado em camadas para deixar o código mais organizado:

- **Controller** → recebe as requisições
- **Service** → faz a lógica da aplicação
- **Mapper** → converte os dados
- **Integration** → chama a API externa
- **Exception** → trata erros da aplicação

---

## Endpoints

### Listar produtos

```http
GET /products
