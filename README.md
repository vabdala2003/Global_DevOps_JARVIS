# Jarvis API Springboot em nuvem com Azure Pipelines 

### obs: arquitetura do projeto no repositório

---

## O que é esse projeto e o que alcançamos?
JARVIS vem como uma solução para provar produtos de forma mais fácil em comércios de roupa. Utilizando de AI e Banco de dados como tecnologias principais, leva a facilidade aos usuários e maior
rentabilidade para os comércios e nossa organização.

Este projeto realiza todo o processo de automatização devops para o deploy de uma aplicação Springboot API. Obtivemos diversos benefícios desse sistema, pois além de agilizar os requerimentos 
para um build e deploy, ensinou nosso time muito sobre a cultura ágil de DevOps.

1. API feita com sucesso integrada a nuvem com Azure Server 
2. CI organizado por tasks efetivas que geram o artefato
3. CD Funcional que realiza o deploy diretamente na nuvem


## CI/CD Pipeline

Este projeto utiliza uma pipeline de CI/CD automatizada, acionada a partir de qualquer alteração no código hospedado no repositório REPOS. O processo consiste nas seguintes etapas:

1. **Integração Contínua (CI)**: Compila a API e executa testes para garantir a estabilidade da aplicação.
2. **Entrega Contínua (CD)**: Realiza o upload do artefato gerado diretamente para o Azure App Service, onde a API é implantada.

### Como Engatilhar a Pipeline

Para engatilhar a pipeline, faça uma alteração simples no código e realize o commit. O processo de CI/CD será iniciado automaticamente. 

#### Acompanhamento da Pipeline

Você pode monitorar os logs de execução na aba **Pipelines** e **Releases** do Azure DevOps para verificar o progresso e resultados do processo.

---

## Testando a API

Após a conclusão da pipeline, a API estará disponível para testes. Utilize ferramentas como **Postman** ou **Insomnia** para realizar requisições e validar as funcionalidades da API.

Para verificar a persistência dos dados em nuvem, você pode executar o seguinte comando SQL:

```bash
sqlcmd -S serverjarvis.database.windows.net -d Global_JARVIS_DB -U azureadmin -P PWserverGlobal!Jarvis
```
Para checar o nome de todas as tabelas:

```bash
SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_TYPE = 'BASE TABLE';
GO
```

# Endpoints e Exemplos de Requisições
Base: https://appjarvisglobal-asard4bagagdgvay.eastus2-01.azurewebsites.net/api

## Requisições POST

### Produto
- **URL**: `/produtos`
- **Exemplo JSON**:
  ```json
  {
  "nomeProduto": "Casaco",
  "categoria": "Vestuário",
  "preco": 120.50,
  "status": "Disponível",
  "descricao": "Casaco Sweater Max",
  "tamanho": "GG"
  }
  ```

### Cliente
- **URL**: `/clientes`
- **Exemplo JSON**:
  ```json
   {
    "nome": "João Silva",
    "cpf": "12345678901",
    "rg": "1234567890",
    "dataNascimento": "1985-06-15",
    "senha": "senha123"
  }
  ```

### Telefone
- **URL**: `/telefones`
- **Exemplo JSON**:
  ```json
  {
    "idCliente": 1,
    "numero": "11987654321",
    "ddd": "11",
    "descricao": "Residencial"
  }
  ```

## Requisições PUT

### Produtos
- **URL**: `/produtos/1`
- **Exemplo JSON**:
  ```json
  {
    "nomeProduto": "Camiseta",
    "categoria": "Vestuário",
    "preco": 78.00,
    "status": "Indisponível",
    "descricao": "Camiseta estampa Oakley",
    "tamanho": "L"
  }
  ```

### Clientes
- **URL**: `/clientes/1`
- **Exemplo JSON**:
  ```json
  {
    "nome": "João Silva Atualizado",
    "cpf": "12345678901",
    "rg": "1234567890",
    "dataNascimento": "1985-06-15",
    "senha": "novaSenha123"
  }
  ```

### Telefones
- **URL**: `/telefones/1`
- **Exemplo JSON**:
  ```json
  {
    "idCliente": 1,	
    "numero": "11987654322",
    "ddd": "11",
    "descricao": "Comercial"
  }
  ```

### Requisições GET
- **Clientes**: /clientes/1
- **Telefones**: /telefones/1
- **Produtos**: /produtos/1

### Requisições DELETE
- **Telefones**: /telefones/1
- **Clientes**: /clientes/1
- **Produtos**: /produtos/1
