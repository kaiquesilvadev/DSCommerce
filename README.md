# Sistema DSCommerce

## Visão Geral
O Sistema DSCommerce é uma aplicação voltada para cursos oferecidos pela DevSuperior no processo de aprendizado dos alunos. Desenvolvido com base em premissas que visam um modelo de domínio simples e abrangente, o sistema permite explorar vários tipos de relacionamentos entre as entidades de negócio.

## Instruções de Instalação

1. **Clone o repositório:**
    ```bash
    git clone https://github.com/seu-usuario/sistema-dscommerce.git
    cd sistema-dscommerce
    ```

2. **Instale as dependências:**
    ```bash
    npm install
    ```

3. **Execute o sistema:**
    ```bash
    npm start
    ```

## Premissas
- Modelo de domínio simples, mas abrangente.
- Exploração de vários tipos de relacionamentos entre entidades.
- Aplicação de conhecimentos importantes em fundamentos.

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

## Desenvolvedores
- [Seu Nome](https://github.com/seu-usuario)
- [Outro Nome](https://github.com/outro-usuario)

## Contribuições
Contribuições são bem-vindas! Sinta-se à vontade para abrir uma *issue* ou criar um *pull request*.
