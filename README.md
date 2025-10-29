# 📱 Cellphone API

API REST desenvolvida em **Spring Boot** para o gerenciamento de **celulares** e **marcas**.  
Permite realizar operações de CRUD e consultas filtradas por modelo ou marca.

---

## ⚙️ Tecnologias Utilizadas
- **Java 17**
- **Spring Boot 2.7+**
- **Spring Data JPA**
- **Hibernate**
- **ModelMapper**
- **Validation API (Jakarta Validation)**
- **Banco de dados H2 / PostgreSql (dependendo do profile)**

---

## 🚀 Endpoints Disponíveis

### 🔹 **Celulares**
Rota base: `/celulares`

#### 1. **Buscar celular por ID**

GET /celulares/{id}

**Descrição:** Retorna um celular específico pelo seu ID.  
**Exemplo de requisição:**


GET /celulares/3

**Resposta:**
```json
{
  "id": 3,
  "modelo": "Galaxy S24",
  "ano": 2024,
  "marca": {
    "id": 1,
    "nome": "Samsung"
  }
}
```

2. Listar celulares por ID da marca
GET /celulares?marca={id}


Descrição: Retorna todos os celulares pertencentes a uma marca.
Exemplo de requisição:

GET /celulares?marca=2


Resposta:
```json
[
  {
    "id": 4,
    "modelo": "Moto G35",
    "ano": 2024,
    "marca": { "id": 2, "nome": "Motorola" }
  },
  {
    "id": 5,
    "modelo": "Moto G100",
    "ano": 2023,
    "marca": { "id": 2, "nome": "Motorola" }
  }
]
```

3. Buscar celular pelo modelo
GET /celulares/modelo/{modelo}


Descrição: Retorna um celular a partir do nome do modelo (ignora maiúsculas/minúsculas).
Exemplo:

GET /celulares/modelo/moto-g35

4. Listar celulares pelo nome da marca
GET /celulares/marca/{marca}


Descrição: Lista todos os celulares de uma marca, informando o nome da marca.
Exemplo:

GET /celulares/marca/Motorola

5. Criar novo celular
POST /celulares


Descrição: Cadastra um novo celular vinculado a uma marca existente.
Corpo (JSON):
```json
{
  "modelo": "iPhone 15",
  "ano": 2024,
  "marca": {
    "id": 3,
    "nome": "Apple"
  }
}
```

Resposta:
```json
{
  "id": 10,
  "modelo": "iPhone 15",
  "ano": 2024,
  "marca": { "id": 3, "nome": "Apple" }
}
```
6. Atualizar um celular
PUT /celulares/{id}


Descrição: Atualiza as informações de um celular existente.
Exemplo de requisição:

PUT /celulares/4


Corpo (JSON):
```json
{
  "modelo": "Moto G40",
  "ano": 2025,
  "marca": { "id": 2, "nome": "Motorola" }
}
```
7. Excluir um celular
DELETE /celulares/{id}


Descrição: Remove um celular do banco de dados.
Exemplo:

DELETE /celulares/5


Resposta:

204 No Content

🔹 Marcas

Rota base: /marcas

1. Listar todas as marcas
GET /marcas


Descrição: Retorna todas as marcas cadastradas.
Resposta:
```json
[
  { "id": 1, "nome": "Samsung" },
  { "id": 2, "nome": "Motorola" },
  { "id": 3, "nome": "Apple" }
]
```
2. Buscar marca por nome
GET /marcas/nome/{nome}


Descrição: Retorna uma marca específica pelo nome.
Exemplo:

GET /marcas/nome/Motorola

3. Buscar marca por ID
GET /marcas/{id}


Descrição: Retorna uma marca a partir do ID.
Exemplo:

GET /marcas/3

4. Criar uma nova marca
POST /marcas


Descrição: Cria uma nova marca de celulares.
Corpo (JSON):
```json
{
  "nome": "Xiaomi"
}
```
5. Atualizar uma marca existente
PUT /marcas/{id}


Descrição: Atualiza o nome de uma marca existente.
Exemplo:

PUT /marcas/3


Corpo (JSON):
```json
{
  "nome": "Apple Inc."
}
```
6. Excluir uma marca
DELETE /marcas/{id}


Descrição: Exclui uma marca do sistema.
Exemplo:

DELETE /marcas/2

🧱 Estrutura de Dados
🟢 Celular
Campo	Tipo	Descrição
id	Long	Identificador do celular
modelo	String	Nome do modelo
ano	Integer	Ano de lançamento
marca	Marca	Marca associada
🟣 Marca
Campo	Tipo	Descrição
id	Long	Identificador da marca
nome	String	Nome da marca
🧪 Exemplo de fluxo completo

Criar uma marca

POST /marcas
```json
{
  "nome": "Motorola"
}
```

Criar um celular vinculado

POST /celulares
```json
{
  "modelo": "Moto G35",
  "ano": 2024,
  "marca": { "id": 1, "nome": "Motorola" }
}
```


Buscar todos os celulares da marca

GET /celulares?marca=1

