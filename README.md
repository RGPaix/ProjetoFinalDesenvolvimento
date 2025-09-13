## 📋 Descrição

Sistema completo de gerenciamento de vendas desenvolvido em **Java Spring Boot** com API REST documentada via Swagger. O sistema permite o controle completo do ciclo de vendas, desde o cadastro de clientes e produtos até a finalização de pedidos.

## 🎯 Objetivos

- Implementar um sistema CRUD completo para gestão de vendas
- Aplicar conceitos de API REST com Spring Boot
- Demonstrar relacionamentos entre entidades (Cliente, Produto, Pedido)
- Utilizar documentação automatizada com Swagger/OpenAPI
- Aplicar boas práticas de desenvolvimento com padrão MVC

## 🏗️ Arquitetura do Sistema

```
┌─────────────┐    ┌─────────────┐    ┌─────────────┐
│   CLIENTE   │    │   PRODUTO   │    │   PEDIDO    │
│             │    │             │    │             │
│ - ID        │    │ - ID        │    │ - ID        │
│ - Nome      │───▶│ - Nome      │◄───│ - Cliente   │
│ - Email     │    │ - Preço     │    │ - Produtos  │
│ - Telefone  │    │ - Estoque   │    │ - Data      │
└─────────────┘    └─────────────┘    │ - Total     │
                                     └─────────────┘
```

## 📁 Estrutura do Projeto

```
demo/
├── src/
│   └── main/
│       ├── java/com/example/
│       │   ├── controllers/        # Controllers REST
│       │   │   ├── ClienteController.java
│       │   │   ├── ProdutoController.java
│       │   │   └── PedidoController.java
│       │   ├── models/             # Entidades JPA
│       │   │   ├── Cliente.java
│       │   │   ├── Produto.java
│       │   │   ├── Pedido.java
│       │   │   └── config/
│       │   │       └── SwaggerConfig.java
│       │   ├── repositories/       # Repositories JPA
│       │   │   ├── ClienteRepository.java
│       │   │   ├── ProdutoRepository.java
│       │   │   └── PedidoRepository.java
│       │   ├── services/           # Lógica de negócio
│       │   │   ├── ClienteService.java
│       │   │   ├── ProdutoService.java
│       │   │   └── PedidoService.java
│       │   └── DemoApplication.java
│       └── resources/
│           ├── application.properties
│           └── data.sql
├── target/                        # Arquivos compilados
├── pom.xml                        # Dependências Maven
└── README.md                      # Este arquivo
```

## 🚀 Funcionalidades

### 👤 Gestão de Clientes
- ✅ Cadastro de novos clientes
- ✅ Listagem de todos os clientes
- ✅ Busca de cliente por ID
- ✅ Atualização de dados do cliente
- ✅ Exclusão de clientes

### 📦 Gestão de Produtos
- ✅ Cadastro de produtos com preço e estoque
- ✅ Listagem de produtos disponíveis
- ✅ Controle de estoque automático
- ✅ Atualização de preços e quantidades
- ✅ Categorização de produtos

### 🛒 Gestão de Pedidos
- ✅ Criação de novos pedidos
- ✅ Associação de produtos aos pedidos
- ✅ Cálculo automático do valor total
- ✅ Histórico de pedidos por cliente
- ✅ Relatórios de vendas

### 📚 Documentação
- ✅ Documentação automática via Swagger UI
- ✅ Endpoints testáveis pela interface web
- ✅ Especificação OpenAPI 3.0

## 💻 Tecnologias Utilizadas

- **Backend**: Java 17+ / Spring Boot 3.x
- **Framework Web**: Spring Web MVC
- **Banco de Dados**: H2 Database (desenvolvimento) / MySQL (produção)
- **ORM**: Spring Data JPA / Hibernate
- **Documentação**: Swagger 3 / SpringDoc OpenAPI
- **Build**: Maven 3.8+
- **Validation**: Bean Validation (Hibernate Validator)

## ⚡ Pré-requisitos

- Java JDK 17 ou superior
- Maven 3.8+ 
- IDE Java (IntelliJ IDEA, VS Code, Eclipse)
- Postman ou similar (opcional - para testes de API)

## 🛠️ Instalação e Execução

### 1. Clone o repositório
```bash
git clone https://github.com/RGPaix/Atividade09.git
cd Atividade09/demo
```

### 2. Compile o projeto
```bash
mvn clean compile
```

### 3. Execute a aplicação
```bash
mvn spring-boot:run
```

### 4. Acesse as interfaces

**Aplicação Principal:**
```
http://localhost:8080
```

**Documentação Swagger UI:**
```
http://localhost:8080/swagger-ui.html
```

**Console H2 Database (desenvolvimento):**
```
http://localhost:8080/h2-console
```

## 📖 API Endpoints

### Clientes
| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/api/clientes` | Lista todos os clientes |
| GET | `/api/clientes/{id}` | Busca cliente por ID |
| POST | `/api/clientes` | Cria novo cliente |
| PUT | `/api/clientes/{id}` | Atualiza cliente |
| DELETE | `/api/clientes/{id}` | Remove cliente |

### Produtos
| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/api/produtos` | Lista todos os produtos |
| GET | `/api/produtos/{id}` | Busca produto por ID |
| POST | `/api/produtos` | Cria novo produto |
| PUT | `/api/produtos/{id}` | Atualiza produto |
| DELETE | `/api/produtos/{id}` | Remove produto |

### Pedidos
| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/api/pedidos` | Lista todos os pedidos |
| GET | `/api/pedidos/{id}` | Busca pedido por ID |
| POST | `/api/pedidos` | Cria novo pedido |
| GET | `/api/pedidos/cliente/{id}` | Pedidos por cliente |

## 🧪 Testando a API

### Exemplo de requisição - Criar Cliente:
```bash
curl -X POST http://localhost:8080/api/clientes \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "João Silva",
    "email": "joao@email.com",
    "telefone": "(11) 99999-9999"
  }'
```

### Exemplo de requisição - Criar Produto:
```bash
curl -X POST http://localhost:8080/api/produtos \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Notebook Dell",
    "preco": 2500.00,
    "estoque": 10
  }'
```

## ⚙️ Configuração

**application.properties:**
```properties
# Configurações do servidor
server.port=8080

# Configurações do banco H2 (desenvolvimento)
spring.datasource.url=jdbc:h2:mem:vendas
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.h2.console.enabled=true

# Configurações JPA
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true

# Swagger/OpenAPI
springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
```

## 🔍 Validações Implementadas

- **Cliente**: Nome obrigatório, email válido, telefone no formato correto
- **Produto**: Nome obrigatório, preço positivo, estoque não negativo  
- **Pedido**: Cliente válido, pelo menos um produto, quantidades válidas

## 📊 Relatórios Disponíveis

- Total de vendas por período
- Produtos mais vendidos
- Clientes com maior volume de compras
- Controle de estoque baixo

## 🚀 Melhorias Futuras

- [ ] Autenticação e autorização (Spring Security)
- [ ] Cache com Redis
- [ ] Testes unitários e de integração
- [ ] Deploy com Docker
- [ ] Frontend em React/Angular
- [ ] Notificações por email
- [ ] Dashboard analítico

## 🧪 Executando Testes

```bash
# Executar todos os testes
mvn test

# Executar testes com cobertura
mvn jacoco:prepare-agent test jacoco:report
```

## 👨‍💻 Autor

**Desenvolvido por:** [@RGPaix](https://github.com/RGPaix)  
**Disciplina:** Desenvolvimento de Sistemas Web / Spring Boot  
**Tema:** Sistema de Gestão de Vendas com API REST

## 📚 Referências

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Swagger/OpenAPI](https://swagger.io/)
- [REST API Best Practices](https://restfulapi.net/)

## 📞 Contato

- GitHub: [@RGPaix](https://github.com/RGPaix)
- Issues: [Reportar problemas](https://github.com/RGPaix/Atividade09/issues)

---

⭐ **Sistema completo de vendas com documentação interativa via Swagger UI!**
