# Atividade módulo 14 - Manipulação de dados (JPA)

Este projeto trata de uma API REST para Gerenciamento de projetos. O objetivo principal da atividade foi a implementação de queries derivadas.

Foram implementadas as queries, services e controllers conforme consta abaixo: 
* **ProjetoRepository**: buscar pela descrição do projeto;
* **RecursoRepository**: buscar pelo nome do recurso;
* **TarefaRepository**: buscar pelo status da tarefa.


## Como rodar o projeto

1. Clone o repositório;
2. Realize as configurações do banco - arquivo `application.properties`: 
- alterar nas partes sinalizadas em MAIÚSCULO

```
spring.datasource.url=jdbc:postgresql://localhost:5432/NOME_BANCO_DE_DADOS
spring.datasource.username=NOME_DO_USUARIO
spring.datasource.password=SUA_SENHA
```

3. Realize as requisições;

> Para facilitar os testes, foi adicionada a **documentação Swagger** que você pode estar acessando pela URL a seguir: 

`http://localhost:8080/swagger-ui/index.html`