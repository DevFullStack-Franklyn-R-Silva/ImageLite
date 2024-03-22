# ImageLite
![GIF](midia/imagelite.gif)

ImageLite é um projeto full-stack que utiliza React com TypeScript para o frontend, Spring Boot Java para o backend, Docker para containerização, PostgreSQL como banco de dados, Tailwind CSS para estilização, Next.js para renderização do lado do cliente, e JWT para autenticação. Este projeto inclui uma galeria de imagens para armazenamento.

## Estrutura do Projeto

O projeto está organizado em duas pastas principais:

1. **imagelite**: Contém o código do frontend, desenvolvido em React com TypeScript.

2. **imageliteapi**: Contém o código do backend, construído com Spring Boot Java, incluindo a autenticação JWT.

## Tecnologias Utilizadas

- **Frontend**:

  - React
  - TypeScript
  - Next.js
  - Tailwind CSS

- **Backend**:

  - Spring Boot (Java)
  - JWT (JSON Web Token) para autenticação

- **Banco de Dados**:

  - PostgreSQL

- **Containerização**:
  - Docker

## Iniciando o Projeto

Certifique-se de ter o Docker instalado em sua máquina antes de iniciar.

1. **Backend**:

   - Navegue até a pasta `imageliteapi`.
   - Execute o comando `./mvnw spring-boot:run` para iniciar o backend.

2. **Frontend**:

   - Navegue até a pasta `imagelite`.
   - Execute o comando `npm install` para instalar as dependências.
   - Em seguida, execute `npm run dev` para iniciar o servidor de desenvolvimento.

3. **Acesso ao Projeto**:
   - O frontend estará disponível em [http://localhost:3000](http://localhost:3000).
   - O backend estará disponível em [http://localhost:8080](http://localhost:8080).
   - O PGAdmin (interface do PostgreSQL) estará disponível em [http://localhost:15432](http://localhost:15432). Use o email `admin@admin.com` e senha `admin` para fazer login.

## Contribuindo

Sinta-se à vontade para contribuir para o desenvolvimento do ImageLite. Faça um fork do repositório, faça suas modificações e envie um pull request.
