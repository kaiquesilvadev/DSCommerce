# Sistema DSCommerce

![Java](https://img.shields.io/badge/Java-11-orange.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.5.4-brightgreen.svg)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue.svg)
![H2](https://img.shields.io/badge/H2-Database-lightgrey.svg)

## Visão Geral
O Sistema DSCommerce é uma aplicação voltada para cursos oferecidos pela DevSuperior no processo de aprendizado dos alunos. Desenvolvido com base em premissas que visam um modelo de domínio simples e abrangente, o sistema permite explorar vários tipos de relacionamentos entre as entidades de negócio.

## Instruções de Instalação

1. **Clone o repositório:**
    ```bash
    git clone https://github.com/kaiquesilvadev/DSCommerce
    cd DSCommerce
    ```

2. **Instale as dependências:**
    ```bash
    npm install
    ```

3. **Execute o sistema:**
    ```bash
    npm start
    ```

## Diagrama de Classes

- O diagrama de classes apresenta a estrutura do projeto e as relações entre as diferentes classes e entidades. Ele fornece uma visão visual do design da aplicação e ajuda a entender como as partes do sistema interagem entre si

![UML](https://github.com/kaiquesilvadev/DSCommerce/blob/main/print/uml.png)

## Estrutura do Projeto

- **presentation:** Camada de Apresentação
  - Responsável pela interação do usuário.
  - Implementação de interfaces intuitivas e amigáveis.

- **application:** Camada de Aplicação
  - Contém a lógica de negócios do DSCommerce.
  - Gerencia casos de uso, orquestrando a interação entre diferentes componentes.

- **domain:** Camada de Domínio
  - Representa o núcleo do sistema, contendo entidades e regras de negócio.
  - Modelagem de conceitos específicos do DSCommerce.

- **infrastructure:** Camada de Infraestrutura
  - Lida com aspectos técnicos e de implementação.
  - Implementação de acesso a banco de dados, APIs externas, etc.

## Premissas
- Modelo de domínio simples, mas abrangente.
- Exploração de vários tipos de relacionamentos entre entidades.
- Aplicação de conhecimentos importantes em fundamentos.

![UML](https://github.com/kaiquesilvadev/DSCommerce/blob/main/print/camadas.png)

## Funcionalidades Principais

1. **Manter Produtos:**
   - CRUD de produtos com filtragem por nome (Admin).

2. **Manter Categorias:**
   - CRUD de categorias com filtragem por nome (Admin).

3. **Manter Usuários:**
   - CRUD de usuários com filtragem por nome (Admin).

4. **Gerenciar Carrinho:**
   - Adicionar, remover itens e alterar quantidades no carrinho (Público).

5. **Consultar Catálogo:**
   - Listar produtos disponíveis com filtragem por nome (Público).

6. **Sign up:**
   - Cadastro de novos usuários (Público).

7. **Login:**
   - Efetuar login no sistema (Público).

8. **Registrar Pedido:**
   - Salvar pedido a partir do carrinho de compras (Usuário logado).

9. **Atualizar Perfil:**
   - Atualizar dados do próprio cadastro (Usuário logado).

10. **Visualizar Pedidos:**
    - Visualizar histórico de pedidos (Usuário logado).

11. **Registrar Pagamento:**
    - Salvar dados de pagamento de um pedido (Admin).

12. **Reportar Pedidos:**
    - Gerar relatório de pedidos filtrados por data (Admin).

## Modelo Conceitual
- Cada item de pedido corresponde a um produto com quantidade e preço registrado.
- Usuários podem ter um ou mais "roles" (perfis de acesso).

## Casos de Uso (Visão Geral)
- [Consultar Catálogo](#consultar-catálogo)
- [Manter Produtos](#manter-produtos)
- [Manter Categorias](#manter-categorias)
- [Manter Usuários](#manter-usuários)
- [Gerenciar Carrinho](#gerenciar-carrinho)
- [Sign up](#sign-up)
- [Login](#login)
- [Registrar Pedido](#registrar-pedido)
- [Atualizar Perfil](#atualizar-perfil)
- [Visualizar Pedidos](#visualizar-pedidos)
- [Registrar Pagamento](#registrar-pagamento)
- [Reportar Pedidos](#reportar-pedidos)

## Contribuições
Contribuições são bem-vindas! Sinta-se à vontade para abrir uma *issue* ou criar um *pull request*.
