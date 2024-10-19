# API de cadastro de sócios do Clube Selva.

Java RESTful API.

## Diagrama de classes.

```mermaid
classDiagram
    class User {
        - String nome
        - String telefone
        - String email
        - String carteirinha
        - String categoria
    }

    class Endereco {
        - String logradouro
        - String numero
        - String bairro
        - String cidade
        - String uf
    }

    User --> Endereco : has
```mermaid
