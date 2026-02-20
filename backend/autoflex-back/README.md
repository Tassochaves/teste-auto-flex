# AutoFlex API - Back-end (Spring Boot)

Esta é a API REST central do Sistema AutoFlex, responsável pelo gerenciamento de inventário e pela lógica de otimização de produção.

---

## Tecnologias e Ferramentas

- **Java 21**: Utilizando as funcionalidades mais recentes da versão LTS.
- **Spring Boot 4.0.2**: Framework base para a construção da arquitetura RESTful.
- **Spring Data JPA**: Para mapeamento objeto-relacional (ORM) e persistência.
- **Lombok**: Para redução de código boilerplate (Getters, Setters, Construtores).
- **H2 Database**: Banco de dados em memória utilizado temporariamente para agilizar a avaliação do teste.
- **SpringDoc OpenAPI (Swagger)**: Será utilizado para documentação interativa dos endpoints.
- **Bean Validation (Hibernate Validator)**: Garantia de integridade dos dados (ex: preços e quantidades positivas).

#

## Arquitetura

O projeto segue o padrão de **Arquitetura em Camadas** para garantir a separação de responsabilidades:

1.  **Camada de Controller**: Gerencia as requisições HTTP e mapeia os dados para os serviços.
2.  **Camada de Service**: Contém as regras de negócios.
3.  **Camada de Repository**: Interface de comunicação direta com o banco de dados via Spring Data.
4.  **Camada de DTO (Data Transfer Object)**: Utilizada para trafegar dados entre o cliente e o servidor sem expor as entidades do banco.

#

## Como Executar

### Pré-requisitos
- JDK 21
- Maven 3.x instalado (ou utilizar o `./mvnw` incluso)

### Passos para execução
1. Acesse a pasta do backend via terminal:
   ```bash
   cd backend/autoflex-back

2. Execute a aplicação com o Maven ou pela interface gráfica de sua IDE:
    ```bash
    ./mvnw spring-boot:run

3. A [URL] base da API estará disponível em: http://localhost:8080
4. A página da interface do usuário Swagger estará disponível em [URL]: http://localhost:8080/swagger-ui/index.html
