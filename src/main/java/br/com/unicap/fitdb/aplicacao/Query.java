package main.java.br.com.unicap.fitdb.aplicacao;

public class Query {
    String [] sqlQueries;
    String useDatabase = "USE loja_fit;\n";

    String createClienteTable = "CREATE TABLE cliente (\n"
        + "id INT AUTO_INCREMENT PRIMARY KEY,\n"
        + "nome VARCHAR(100) NOT NULL,\n"
        + "sexo ENUM('M', 'F', 'O') NOT NULL,\n"
        + "idade INT NOT NULL,\n"
        + "nascimento DATE NOT NULL\n"
        + ");\n";
    
    String createClienteEspecialTable = "CREATE TABLE clienteespecial (\n"
        + "id INT AUTO_INCREMENT PRIMARY KEY,\n"
        + "id_cliente INT,\n"
        + "cashback DECIMAL(10, 2),\n"
        + "FOREIGN KEY (id_cliente) REFERENCES cliente(id)\n"
        + ");\n";
    
    String createFuncionarioTable = "CREATE TABLE funcionario (\n"
        + "id INT AUTO_INCREMENT PRIMARY KEY,\n"
        + "nome VARCHAR(100) NOT NULL,\n"
        + "idade INT NOT NULL,\n"
        + "sexo ENUM('M', 'F', 'O') NOT NULL,\n"
        + "cargo ENUM('vendedor', 'gerente', 'CEO') NOT NULL,\n"
        + "salario DECIMAL(10, 2) NOT NULL,\n"
        + "nascimento DATE NOT NULL\n"
        + ");\n";
    
    String createFuncionarioEspecialTable = "CREATE TABLE funcionarioespecial (\n"
        + "id INT AUTO_INCREMENT PRIMARY KEY,\n"
        + "id_funcionario INT,\n"
        + "bonus DECIMAL(10, 2),\n"
        + "FOREIGN KEY (id_funcionario) REFERENCES funcionario(id)\n"
        + ");\n";
    
    String createProdutoTable = "CREATE TABLE produto (\n"
        + "id INT AUTO_INCREMENT PRIMARY KEY,\n"
        + "nome VARCHAR(100) NOT NULL,\n"
        + "quantidade INT NOT NULL,\n"
        + "descricao TEXT,\n"
        + "valor DECIMAL(10, 2) NOT NULL\n"
        + ");\n";
    
    String createVendaTable = "CREATE TABLE venda (\n"
        + "id INT AUTO_INCREMENT PRIMARY KEY,\n"
        + "id_vendedor INT,\n"
        + "id_cliente INT,\n"
        + "id_produto INT,\n"
        + "quantidade INT NOT NULL,\n"
        + "data DATE NOT NULL,\n"
        + "FOREIGN KEY (id_vendedor) REFERENCES funcionario(id),\n"
        + "FOREIGN KEY (id_cliente) REFERENCES cliente(id),\n"
        + "FOREIGN KEY (id_produto) REFERENCES produto(id)\n"
        + ");\n";

    String createUsersTable = "CREATE TABLE usuarios (\n" +
        "    id INT AUTO_INCREMENT PRIMARY KEY,\n" +
        "    username VARCHAR(50) NOT NULL UNIQUE,\n" +
        "    password VARCHAR(255) NOT NULL,\n" +
        "    role ENUM('admin', 'manager', 'employee') NOT NULL,\n" +
        "    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP\n" +
    ");";
    
    
    String insertProdutos = "INSERT INTO produto (nome, quantidade, descricao, valor) VALUES \n"
        + "('Proteína Whey', 50, 'Suplemento de proteína de soro de leite', 120.00),\n"
        + "('Creatina', 30, 'Suplemento de creatina monohidratada', 60.00),\n"
        + "('BCAA', 40, 'Aminoácidos de cadeia ramificada', 80.00),\n"
        + "('Pré-treino', 25, 'Suplemento pré-treino com cafeína', 90.00),\n"
        + "('Glutamina', 20, 'Suplemento de glutamina', 70.00),\n"
        + "('Omega 3', 60, 'Suplemento de óleo de peixe', 50.00),\n"
        + "('Multivitamínico', 100, 'Complexo multivitamínico', 40.00),\n"
        + "('ZMA', 15, 'Suplemento de zinco, magnésio e vitamina B6', 45.00),\n"
        + "('Termogênico', 35, 'Suplemento queimador de gordura', 100.00),\n"
        + "('Hipercalórico', 10, 'Suplemento para ganho de massa', 150.00),\n"
        + "('Colágeno', 25, 'Suplemento de colágeno hidrolisado', 55.00),\n"
        + "('Vitamina C', 80, 'Suplemento de vitamina C', 30.00),\n"
        + "('Cafeína', 50, 'Suplemento de cafeína em cápsulas', 75.00),\n"
        + "('Beta-Alanina', 20, 'Suplemento de beta-alanina', 65.00),\n"
        + "('Albumina', 40, 'Suplemento de proteína de clara de ovo', 45.00),\n"
        + "('Caseína', 30, 'Suplemento de proteína de caseína', 110.00),\n"
        + "('Maltodextrina', 60, 'Suplemento de carboidrato', 35.00),\n"
        + "('HMB', 15, 'Suplemento de ácido beta-hidroxi beta-metilbutírico', 85.00),\n"
        + "('L-Carnitina', 25, 'Suplemento de L-carnitina', 95.00),\n"
        + "('Arginina', 20, 'Suplemento de L-arginina', 50.00);\n";
    
    String insertFuncionarios = "INSERT INTO funcionario (nome, idade, sexo, cargo, salario, nascimento) VALUES \n"
        + "('Carlos Silva', 30, 'M', 'vendedor', 3000.00, '1993-01-01'),\n"
        + "('Ana Souza', 40, 'F', 'gerente', 5000.00, '1983-01-01'),\n"
        + "('Pedro Alves', 35, 'M', 'vendedor', 3200.00, '1988-01-01'),\n"
        + "('Maria Oliveira', 45, 'F', 'CEO', 10000.00, '1978-01-01'),\n"
        + "('João Santos', 28, 'M', 'vendedor', 2800.00, '1995-01-01');\n";
    
    String insertClientes = "INSERT INTO cliente (nome, sexo, idade, nascimento) VALUES \n"
        + "('Ana Silva', 'F', 28, '1996-03-14'),\n"
        + "('Bruno Oliveira', 'M', 34, '1990-07-22'),\n"
        + "('Carlos Souza', 'M', 45, '1979-01-10'),\n"
        + "('Daniela Costa', 'F', 22, '2002-05-25'),\n"
        + "('Eduardo Pereira', 'M', 31, '1993-12-03'),\n"
        + "('Fernanda Lima', 'F', 29, '1995-09-18'),\n"
        + "('Gabriel Martins', 'M', 27, '1997-11-05'),\n"
        + "('Helena Rodrigues', 'F', 36, '1988-04-09'),\n"
        + "('Igor Alves', 'M', 24, '2000-08-30'),\n"
        + "('Juliana Ferreira', 'F', 33, '1991-02-17'),\n"
        + "('Kleber Araújo', 'M', 39, '1985-06-12'),\n"
        + "('Larissa Mendes', 'F', 26, '1998-07-07'),\n"
        + "('Marcos Antunes', 'M', 42, '1982-03-19'),\n"
        + "('Natália Barros', 'F', 23, '2001-10-14'),\n"
        + "('Otávio Pinto', 'M', 37, '1987-11-21'),\n"
        + "('Patrícia Moraes', 'F', 31, '1993-01-02'),\n"
        + "('Quintino Santos', 'M', 40, '1984-12-15'),\n"
        + "('Raquel Teixeira', 'F', 27, '1997-04-11'),\n"
        + "('Sérgio Reis', 'M', 35, '1989-06-23'),\n"
        + "('Tatiane Ribeiro', 'F', 32, '1992-05-06'),\n"
        + "('Ubirajara Nunes', 'M', 50, '1974-08-19'),\n"
        + "('Vanessa Cardoso', 'F', 28, '1996-09-26'),\n"
        + "('Wagner Matos', 'M', 29, '1995-02-28'),\n"
        + "('Ximena Dias', 'F', 33, '1991-12-11'),\n"
        + "('Yuri Farias', 'M', 26, '1998-03-05'),\n"
        + "('Zélia Vasconcelos', 'F', 40, '1984-10-08'),\n"
        + "('Aline Borges', 'F', 30, '1994-07-15'),\n"
        + "('Bernardo Cunha', 'M', 38, '1986-02-22'),\n"
        + "('Cíntia Andrade', 'F', 24, '2000-01-20'),\n"
        + "('Diogo Campos', 'M', 35, '1989-09-30'),\n"
        + "('Eliane Lopes', 'F', 41, '1983-06-27'),\n"
        + "('Felipe Monteiro', 'M', 33, '1991-04-16'),\n"
        + "('Gustavo Assis', 'M', 27, '1997-05-04'),\n"
        + "('Heloísa Rocha', 'F', 36, '1988-02-14'),\n"
        + "('Ícaro Vasconcelos', 'M', 22, '2002-11-09'),\n"
        + "('Joana Dantas', 'F', 29, '1995-03-18'),\n"
        + "('Leandro Batista', 'M', 34, '1990-12-06'),\n"
        + "('Maria Eduarda Coelho', 'F', 25, '1999-08-21'),\n"
        + "('Nicolas Sousa', 'M', 32, '1992-09-14'),\n"
        + "('Olívia Fonseca', 'F', 30, '1994-10-19'),\n"
        + "('Paulo Viana', 'M', 37, '1987-05-11'),\n"
        + "('Quésia Freitas', 'F', 28, '1996-07-30'),\n"
        + "('Renato Guerra', 'M', 31, '1993-11-25'),\n"
        + "('Sandra Pires', 'F', 27, '1997-12-16'),\n"
        + "('Thiago Marques', 'M', 33, '1991-06-08'),\n"
        + "('Úrsula Guimarães', 'F', 38, '1986-01-13'),\n"
        + "('Vinícius Rocha', 'M', 24, '2000-05-27'),\n"
        + "('William Tavares', 'M', 40, '1984-04-22'),\n"
        + "('Yasmin Figueiredo', 'F', 23, '2001-07-09'),\n"
        + "('Zeca Andrade', 'M', 45, '1979-02-15'),\n"
        + "('Alice Oliveira', 'F', 26, '1998-11-02'),\n"
        + "('Bruno Machado', 'M', 30, '1994-01-28'),\n"
        + "('Catarina Neves', 'F', 29, '1995-06-03'),\n"
        + "('Diego Ferreira', 'M', 36, '1988-08-15'),\n"
        + "('Estela Barbosa', 'F', 31, '1993-10-04'),\n"
        + "('Fábio Menezes', 'M', 32, '1992-02-29'),\n"
        + "('Gabriela Silva', 'F', 27, '1997-01-09'),\n"
        + "('Heitor Lima', 'M', 39, '1985-12-17'),\n"
        + "('Isabela Pinto', 'F', 24, '2000-04-05'),\n"
        + "('Jorge Nascimento', 'M', 28, '1996-09-22'),\n"
        + "('Kelly Souza', 'F', 35, '1989-03-30'),\n"
        + "('Lucas Almeida', 'M', 30, '1994-12-25'),\n"
        + "('Mariana Dias', 'F', 25, '1999-06-12'),\n"
        + "('Natan Costa', 'M', 34, '1990-08-19'),\n"
        + "('Olga Ramos', 'F', 28, '1996-05-10'),\n"
        + "('Pedro Henrique Carvalho', 'M', 33, '1991-07-01'),\n"
        + "('Quirino Lemos', 'M', 40, '1984-11-24'),\n"
        + "('Rafaela Cruz', 'F', 27, '1997-02-11'),\n"
        + "('Samuel Santos', 'M', 31, '1993-10-29'),\n"
        + "('Tamara Azevedo', 'F', 22, '2002-12-08'),\n"
        + "('Ulisses Gomes', 'M', 29, '1995-01-05'),\n"
        + "('Verônica Martins', 'F', 30, '1994-11-16'),\n"
        + "('Wesley Moreira', 'M', 32, '1992-06-18'),\n"
        + "('Xavier Castro', 'M', 38, '1986-04-27'),\n"
        + "('Yara Mendes', 'F', 26, '1998-08-03'),\n"
        + "('Zélio Oliveira', 'M', 45, '1979-05-09'),\n"
        + "('Amélia Campos', 'F', 33, '1991-11-12'),\n"
        + "('Breno Gomes', 'M', 39, '1985-08-25'),\n"
        + "('Clarice Ferreira', 'F', 29, '1995-07-06'),\n"
        + "('Danilo Vieira', 'M', 31, '1993-09-03'),\n"
        + "('Elisa Araújo', 'F', 26, '1998-04-13'),\n"
        + "('Felipe Borges', 'M', 27, '1997-06-21'),\n"
        + "('Gabrielle Santos', 'F', 35, '1989-12-20'),\n"
        + "('Henrique Barros', 'M', 40, '1984-03-29'),\n"
        + "('Ivone Batista', 'F', 30, '1994-02-08'),\n"
        + "('José Matos', 'M', 32, '1992-01-26'),\n"
        + "('Karla Fernandes', 'F', 28, '1996-10-23'),\n"
        + "('Luan Souza', 'M', 34, '1990-05-17'),\n"
        + "('Márcia Cardoso', 'F', 36, '1988-11-08'),\n"
        + "('Nelson Rocha', 'M', 29, '1995-02-24'),\n"
        + "('Otávia Gomes', 'F', 25, '1999-03-31'),\n"
        + "('Paula Rodrigues', 'F', 28, '1996-07-20'),\n"
        + "('Ricardo Sampaio', 'M', 37, '1987-11-30'),\n"
        + "('Sabrina Lemos', 'F', 30, '1994-09-26'),\n"
        + "('Tiago Oliveira', 'M', 32, '1992-06-04'),\n"
        + "('Úrsula Cunha', 'F', 29, '1995-12-22'),\n"
        + "('Vitor Menezes', 'M', 26, '1998-01-18');\n";
    
        String createTrigger1 = "CREATE TRIGGER atualiza_apos_inserir_venda\n"
        + "AFTER INSERT ON venda\n"
        + "FOR EACH ROW\n"
        + "BEGIN\n"
        + "    DECLARE total_vendas DECIMAL(10, 2);\n"
        + "    DECLARE bonus DECIMAL(10, 2);\n"
        + "    DECLARE total_compras DECIMAL(10, 2);\n"
        + "    DECLARE cashback DECIMAL(10, 2);\n"
        + "    DECLARE msg_funcionario VARCHAR(255);\n"
        + "    DECLARE msg_cliente VARCHAR(255);\n"

        + "    -- Trigger para funcionário especial\n"
        + "    SELECT SUM(p.valor * v.quantidade) INTO total_vendas\n"
        + "    FROM venda v\n"
        + "    JOIN produto p ON v.id_produto = p.id\n"
        + "    WHERE v.id_vendedor = NEW.id_vendedor;\n"
        + "    IF total_vendas > 1000.00 THEN\n"
        + "        SET bonus = total_vendas * 0.05;\n"
        + "        INSERT INTO funcionarioespecial (id_funcionario, bonus) VALUES (NEW.id_vendedor, bonus);\n"
        + "        SELECT CONCAT('Bônus total necessário: ', SUM(bonus)) INTO msg_funcionario\n"
        + "        FROM funcionarioespecial;\n"
        + "        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = msg_funcionario;\n"
        + "    END IF;\n"

        + "    -- Trigger para cliente especial\n"
        + "    SELECT SUM(p.valor * v.quantidade) INTO total_compras\n"
        + "    FROM venda v\n"
        + "    JOIN produto p ON v.id_produto = p.id\n"
        + "    WHERE v.id_cliente = NEW.id_cliente;\n"
        + "    IF total_compras > 500.00 THEN\n"
        + "        SET cashback = total_compras * 0.02;\n"
        + "        INSERT INTO clienteespecial (id_cliente, cashback) VALUES (NEW.id_cliente, cashback);\n"
        + "        SELECT CONCAT('Valor total de cashback necessário: ', SUM(cashback)) INTO msg_cliente\n"
        + "        FROM clienteespecial;\n"
        + "        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = msg_cliente;\n"
        + "    END IF;\n"
        + "END;\n";

    String createTrigger2 = "CREATE TRIGGER remove_cliente_especial\n"
        + "AFTER UPDATE ON clienteespecial\n"
        + "FOR EACH ROW\n"
        + "BEGIN\n"
        + "    IF NEW.cashback = 0 THEN\n"
        + "        DELETE FROM clienteespecial WHERE id = NEW.id;\n"
        + "    END IF;\n"
        + "END;\n";



    /* 
    String createUsers = "CREATE USER 'admin'@'localhost' IDENTIFIED BY 'adminpassword';\n"
        + "GRANT ALL PRIVILEGES ON loja_fit.* TO 'admin'@'localhost';\n"
        + "CREATE USER 'manager'@'localhost' IDENTIFIED BY 'managerpassword';\n"
        + "GRANT SELECT, DELETE, UPDATE ON loja_fit.* TO 'manager'@'localhost';\n"
        + "CREATE USER 'employee'@'localhost' IDENTIFIED BY 'employeepassword';\n"
        + "GRANT INSERT, SELECT ON loja_fit.* TO 'employee'@'localhost';\n";
    */
    String createView1 = "CREATE VIEW produtos_mais_vendidos AS\n"
        + "SELECT p.nome, COUNT(v.id) AS total_vendas\n"
        + "FROM produto p\n"
        + "JOIN venda v ON p.id = v.id_produto\n"
        + "GROUP BY p.nome\n"
        + "ORDER BY total_vendas DESC;\n";

    String createView2 = "CREATE VIEW valor_ganho_produtos AS\n"
        + "SELECT p.nome, SUM(p.valor * v.quantidade) AS total_valor\n"
        + "FROM produto p\n"
        + "JOIN venda v ON p.id = v.id_produto\n"
        + "GROUP BY p.nome;\n";

    String createView3 = "CREATE VIEW clientes_mais_compraram AS\n"
        + "SELECT c.nome AS cliente, SUM(p.valor * v.quantidade) AS total_compras\n"
        + "FROM cliente c\n"
        + "JOIN venda v ON c.id = v.id_cliente\n"
        + "JOIN produto p ON v.id_produto = p.id\n"
        + "GROUP BY c.nome\n"
        + "ORDER BY total_compras DESC;\n";

    String createView4 = "CREATE VIEW vendas_mensais AS\n"
        + "SELECT YEAR(v.data) AS ano, MONTH(v.data) AS mes, SUM(p.valor * v.quantidade) AS total_vendas\n"
        + "FROM venda v\n"
        + "JOIN produto p ON v.id_produto = p.id\n"
        + "GROUP BY YEAR(v.data), MONTH(v.data)\n"
        + "ORDER BY ano, mes;\n";

    
    String createProcedure1 = "CREATE PROCEDURE realizar_venda(IN id_vendedor INT, IN id_cliente INT, IN id_produto INT, IN quantidade INT)\n"
        + "BEGIN\n"
        + "DECLARE produto_quantidade INT;\n"
        + "SELECT quantidade INTO produto_quantidade FROM produto WHERE id = id_produto;\n"
        + "IF produto_quantidade >= quantidade THEN\n"
        + "INSERT INTO venda (id_vendedor, id_cliente, id_produto, quantidade, data) VALUES (id_vendedor, id_cliente, id_produto, quantidade, CURDATE());\n"
        + "UPDATE produto SET quantidade = quantidade - quantidade WHERE id = id_produto;\n"
        + "ELSE\n"
        + "SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Quantidade insuficiente no estoque';\n"
        + "END IF;\n"
        + "END;\n";

String createProcedure2 = "CREATE PROCEDURE reajuste_salarial_positivo(IN percentual DECIMAL(5,2), IN categoria ENUM('vendedor', 'gerente', 'CEO'))\n"
        + "BEGIN\n"
        + "UPDATE funcionario\n"
        + "SET salario = salario + (salario * (percentual / 100))\n"
        + "WHERE cargo = categoria;\n"
        + "END;\n";

String createProcedure3 = "CREATE PROCEDURE reajuste_salarial_negativo(IN percentual DECIMAL(5,2), IN categoria ENUM('vendedor', 'gerente', 'CEO'))\n"
        + "BEGIN\n"
        + "UPDATE funcionario\n"
        + "SET salario = salario - (salario * (percentual / 100))\n"
        + "WHERE cargo = categoria;\n"
        + "END;\n";

String createProcedure4 = "CREATE PROCEDURE sorteio_premiacao()\n"
        + "BEGIN\n"
        + "DECLARE cliente_id INT;\n"
        + "DECLARE is_special BOOLEAN;\n"
        + "DECLARE premio DECIMAL(10, 2);\n"
        + "SET cliente_id = (SELECT id FROM cliente ORDER BY RAND() LIMIT 1);\n"
        + "SET is_special = (SELECT COUNT(*) FROM clienteespecial WHERE id_cliente = cliente_id) > 0;\n"
        + "IF is_special THEN\n"
        + "SET premio = 200.00;\n"
        + "ELSE\n"
        + "SET premio = 100.00;\n"
        + "END IF;\n"
        + "INSERT INTO premios (id_cliente, valor) VALUES (cliente_id, premio);\n"
        + "END;\n";

String createProcedure5 = "CREATE PROCEDURE Estatisticas()\n"
        + "BEGIN\n"
        + "SELECT p.nome AS 'Produto mais vendido'\n"
        + "FROM produto p\n"
        + "JOIN (\n"
        + "SELECT id_produto, SUM(quantidade) AS total_vendido\n"
        + "FROM venda\n"
        + "GROUP BY id_produto\n"
        + "ORDER BY total_vendido DESC\n"
        + "LIMIT 1\n"
        + ") AS mais_vendido ON p.id = mais_vendido.id_produto;\n"
        + "SELECT f.nome AS 'Vendedor associado ao produto mais vendido'\n"
        + "FROM funcionario f\n"
        + "JOIN (\n"
        + "SELECT v.id_vendedor\n"
        + "FROM venda v\n"
        + "JOIN (\n"
        + "SELECT id_produto, SUM(quantidade) AS total_vendido\n"
        + "FROM venda\n"
        + "GROUP BY id_produto\n"
        + "ORDER BY total_vendido DESC\n"
        + "LIMIT 1\n"
        + ") AS mais_vendido ON v.id_produto = mais_vendido.id_produto\n"
        + "GROUP BY v.id_vendedor\n"
        + "ORDER BY SUM(v.quantidade) DESC\n"
        + "LIMIT 1\n"
        + ") AS vendedor_mais_vendido ON f.id = vendedor_mais_vendido.id_vendedor;\n"
        + "SELECT p.nome AS 'Produto menos vendido'\n"
        + "FROM produto p\n"
        + "JOIN (\n"
        + "SELECT id_produto, SUM(quantidade) AS total_vendido\n"
        + "FROM venda\n"
        + "GROUP BY id_produto\n"
        + "ORDER BY total_vendido ASC\n"
        + "LIMIT 1\n"
        + ") AS menos_vendido ON p.id = menos_vendido.id_produto;\n"
        + "SELECT (mais_vendido.total_vendido * p.valor) AS 'Valor ganho com o produto mais vendido'\n"
        + "FROM (\n"
        + "SELECT id_produto, SUM(quantidade) AS total_vendido\n"
        + "FROM venda\n"
        + "GROUP BY id_produto\n"
        + "ORDER BY total_vendido DESC\n"
        + "LIMIT 1\n"
        + ") AS mais_vendido\n"
        + "JOIN produto p ON mais_vendido.id_produto = p.id;\n"
        + "SELECT YEAR(v.data) AS ano, MONTH(v.data) AS mes, SUM(v.quantidade) AS total_vendido\n"
        + "FROM venda v\n"
        + "WHERE v.id_produto = (\n"
        + "SELECT id_produto\n"
        + "FROM (\n"
        + "SELECT id_produto, SUM(quantidade) AS total_vendido\n"
        + "FROM venda\n"
        + "GROUP BY id_produto\n"
        + "ORDER BY total_vendido DESC\n"
        + "LIMIT 1\n"
        + ") AS mais_vendido\n"
        + ")\n"
        + "GROUP BY YEAR(v.data), MONTH(v.data)\n"
        + "ORDER BY total_vendido DESC\n"
        + "LIMIT 1;\n"
        + "SELECT YEAR(v.data) AS ano, MONTH(v.data) AS mes, SUM(v.quantidade) AS total_vendido\n"
        + "FROM venda v\n"
        + "WHERE v.id_produto = (\n"
        + "SELECT id_produto\n"
        + "FROM (\n"
        + "SELECT id_produto, SUM(quantidade) AS total_vendido\n"
        + "FROM venda\n"
        + "GROUP BY id_produto\n"
        + "ORDER BY total_vendido DESC\n"
        + "LIMIT 1\n"
        + ") AS mais_vendido\n"
        + ")\n"
        + "GROUP BY YEAR(v.data), MONTH(v.data)\n"
        + "ORDER BY total_vendido ASC\n"
        + "LIMIT 1;\n"
        + "SELECT (menos_vendido.total_vendido * p.valor) AS 'Valor ganho com o produto menos vendido'\n"
        + "FROM (\n"
        + "SELECT id_produto, SUM(quantidade) AS total_vendido\n"
        + "FROM venda\n"
        + "GROUP BY id_produto\n"
        + "ORDER BY total_vendido ASC\n"
        + "LIMIT 1\n"
        + ") AS menos_vendido\n"
        + "JOIN produto p ON menos_vendido.id_produto = p.id;\n"
        + "SELECT YEAR(v.data) AS ano, MONTH(v.data) AS mes, SUM(v.quantidade) AS total_vendido\n"
        + "FROM venda v\n"
        + "WHERE v.id_produto = (\n"
        + "SELECT id_produto\n"
        + "FROM (\n"
        + "SELECT id_produto, SUM(quantidade) AS total_vendido\n"
        + "FROM venda\n"
        + "GROUP BY id_produto\n"
        + "ORDER BY total_vendido ASC\n"
        + "LIMIT 1\n"
        + ") AS menos_vendido\n"
        + ")\n"
        + "GROUP BY YEAR(v.data), MONTH(v.data)\n"
        + "ORDER BY total_vendido DESC\n"
        + "LIMIT 1;\n"
        + "SELECT YEAR(v.data) AS ano, MONTH(v.data) AS mes, SUM(v.quantidade) AS total_vendido\n"
        + "FROM venda v\n"
        + "WHERE v.id_produto = (\n"
        + "SELECT id_produto\n"
        + "FROM (\n"
        + "SELECT id_produto, SUM(quantidade) AS total_vendido\n"
        + "FROM venda\n"
        + "GROUP BY id_produto\n"
        + "ORDER BY total_vendido ASC\n"
        + "LIMIT 1\n"
        + ") AS menos_vendido\n"
        + ")\n"
        + "GROUP BY YEAR(v.data), MONTH(v.data)\n"
        + "ORDER BY total_vendido ASC\n"
        + "LIMIT 1;\n"
        + "END;\n";



        public Query(){
            String [] queries = {
                useDatabase,
                createClienteTable,
                createClienteEspecialTable,
                createFuncionarioTable,
                createFuncionarioEspecialTable,
                createProdutoTable,
                createVendaTable,
                createUsersTable,
                insertProdutos,
                insertFuncionarios,
                insertClientes,
                createView1,
                createView2,
                createView3,
                createView4,
                createProcedure1,
                createProcedure2,
                createProcedure3,
                createProcedure4,
                createProcedure5,
                createTrigger1,
                createTrigger2
            };
            this.sqlQueries = queries;
        }
        
}

/*
 *              createTriggers,
                createUsers,
                createViews,
                createProcedures
 */
