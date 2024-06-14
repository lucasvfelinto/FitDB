# Projeto de E-commerce com Banco de Dados
# FitDB - Loja de Suplementação

# Integrantes

- José Franklin Alencar Dantas
- Marcus Gonçalves
- Lucas Felinto

Repositorio destinado ao projeto da disciplina de banco de dados II

## Características

### Linguagem
O sistema java, juntamente com SQL para a gestão do banco de dados.

### Contexto
Trata-se de um sistema de e-commerce para a venda de suplementação. 

## Requisitos do Sistema

1. **Criação e Destruição do Banco de Dados**
   - O sistema deve permitir a criação e destruição completa do banco de dados.

2. **Dados Iniciais**
   - O banco de dados deve iniciar com:
     - 20 produtos
     - 5 cargos
     - 100 clientes

3. **Cadastro**
   - O sistema deve permitir o cadastro de novos produtos e clientes.

4. **Triggers**
   - **Trigger 1**: Quando um vendedor vende mais de R$ 1000,00, ele é movido para a tabela de funcionários especiais e recebe um bônus de 5% do valor vendido. Um gatilho deve emitir uma mensagem informando o total necessário para custear o bônus salarial.
   - **Trigger 2**: Quando um cliente compra mais de R$ 500,00, ele é adicionado à tabela de clientes especiais e recebe um cashback de 2% do valor gasto. Um gatilho deve emitir uma mensagem informando o valor necessário para lidar com o cashback.
   - **Trigger 3**: Quando o cashback de um cliente especial é zerado, ele é removido da tabela de clientes especiais.

5. **Usuários**
   - **Administrador**: Com todas as permissões possíveis.
   - **Gerente**: Com permissões de busca, exclusão e edição dos registros.
   - **Funcionário**: Com permissão de adicionar novos registros e consultar os registros de venda.

6. **Views**
   - Implemente três views diferentes usando JOINs e GROUP BY.

7. **Procedimentos**
   - **Reajuste**: Recebe um percentual de reajuste salarial e uma categoria, e aplica o aumento salarial a todos os funcionários dessa categoria.
   - **Sorteio**: Sorteia aleatoriamente um cliente para receber um voucher de R$ 100. Se o cliente estiver na tabela de clientes especiais, ele recebe um voucher de R$ 200.
   - **Venda**: Reduz em 1 a quantidade do produto na base de dados sempre que uma venda é realizada.
   - **Estatísticas**: Exibe as seguintes estatísticas da tabela de vendas:
     - Produto mais vendido
     - Vendedor associado ao produto mais vendido
     - Produto menos vendido
     - Valor ganho com o produto mais vendido
     - Mês de maior e menor venda do produto mais vendido
     - Valor ganho com o produto menos vendido
     - Mês de maior e menor venda do produto menos vendido
