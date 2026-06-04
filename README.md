# 📋 Task Manager Project

Sistema de gerenciamento de tarefas desenvolvido em Java com MySQL.

---

## 🚀 Tecnologias utilizadas

- Java (JDK 21+)
- MySQL
- JDBC
- NetBeans
- Git & GitHub

---

## 🗄️ Banco de dados

O projeto utiliza MySQL como banco de dados local.

### 📌 Criar o banco:

```sql
CREATE DATABASE taskmanager_db;
📁 Arquivo do banco (.sql)

O arquivo do banco está localizado no projeto em:

src/taskmanagerproject/database.sql
📥 Como importar o banco
Abra o MySQL Workbench
Vá em Server → Data Import
Selecione o arquivo:
src/taskmanagerproject/database.sql
Escolha o banco:
taskmanager_db
Clique em Start Import
⚙️ Configuração do banco

O usuário e senha do MySQL devem ser configurados no arquivo DBConnection.java conforme o ambiente local.

Exemplo:
user: root  
password: sua_senha
▶️ Como executar o projeto
Clone o repositório
Abra o projeto na sua IDE (NetBeans ou IntelliJ)
Certifique-se de que o MySQL está rodando
Crie o banco de dados:
CREATE DATABASE taskmanager_db;
Importe o arquivo:
src/taskmanagerproject/database.sql
Execute a classe principal (Main)
## 📌 Estrutura do projeto

Projeto Java (NetBeans) organizado da seguinte forma:

TaskManagerProject/
├── build/
├── dist/
├── nbproject/
├── src/
│ └── taskmanagerproject/
│ ├── controllers/
│ ├── models/
│ ├── views/
│ └── database.sql
├── test/
├── build.xml
├── manifest.mf

✨ Funcionalidades
Cadastro de usuários
Login de usuários
Criação de tarefas
Listagem de tarefas
Edição de tarefas
Exclusão de tarefas
⚠️ Observações
O banco de dados não é online, precisa ser criado localmente
O MySQL deve estar instalado e rodando
O arquivo database.sql já contém toda a estrutura necessária
👤 Autor

Projeto desenvolvido por Gustavo E
Curso: Desenvolvimento Java (iRede)


---



