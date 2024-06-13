-- Criar o banco de dados
USE loja_fit;

-- Tabela de Clientes
CREATE TABLE cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    sexo ENUM('m', 'f', 'o') NOT NULL,
    idade INT NOT NULL,
    nascimento DATE NOT NULL
);

-- Tabela de Clientes Especiais
CREATE TABLE clienteespecial (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT,
    cashback DECIMAL(10, 2),
    FOREIGN KEY (id_cliente) REFERENCES cliente(id)
);

-- Tabela de Funcionários
CREATE TABLE funcionario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    idade INT NOT NULL,
    sexo ENUM('m', 'f', 'o') NOT NULL,
    cargo ENUM('vendedor', 'gerente', 'CEO') NOT NULL,
    salario DECIMAL(10, 2) NOT NULL,
    nascimento DATE NOT NULL
);

-- Tabela de Funcionários Especiais
CREATE TABLE funcionarioespecial (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_funcionario INT,
    bonus DECIMAL(10, 2),
    FOREIGN KEY (id_funcionario) REFERENCES funcionario(id)
);

-- Tabela de Produtos
CREATE TABLE produto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    quantidade INT NOT NULL,
    descricao TEXT,
    valor DECIMAL(10, 2) NOT NULL
);

-- Tabela de Vendas
CREATE TABLE venda (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_vendedor INT,
    id_cliente INT,
    id_produto INT,
    quantidade INT NOT NULL,
    data DATE NOT NULL,
    FOREIGN KEY (id_vendedor) REFERENCES funcionario(id),
    FOREIGN KEY (id_cliente) REFERENCES cliente(id),
    FOREIGN KEY (id_produto) REFERENCES produto(id)
);

-- Inserir produtos
INSERT INTO produto (nome, quantidade, descricao, valor) VALUES
('Proteína Whey', 50, 'Suplemento de proteína de soro de leite', 120.00),
('Creatina', 30, 'Suplemento de creatina monohidratada', 60.00),
('BCAA', 40, 'Aminoácidos de cadeia ramificada', 80.00),
('Pré-treino', 25, 'Suplemento pré-treino com cafeína', 90.00),
('Glutamina', 20, 'Suplemento de glutamina', 70.00),
('Omega 3', 60, 'Suplemento de óleo de peixe', 50.00),
('Multivitamínico', 100, 'Complexo multivitamínico', 40.00),
('ZMA', 15, 'Suplemento de zinco, magnésio e vitamina B6', 45.00),
('Termogênico', 35, 'Suplemento queimador de gordura', 100.00),
('Hipercalórico', 10, 'Suplemento para ganho de massa', 150.00),
('Colágeno', 25, 'Suplemento de colágeno hidrolisado', 55.00),
('Vitamina C', 80, 'Suplemento de vitamina C', 30.00),
('Cafeína', 50, 'Suplemento de cafeína em cápsulas', 75.00),
('Beta-Alanina', 20, 'Suplemento de beta-alanina', 65.00),
('Albumina', 40, 'Suplemento de proteína de clara de ovo', 45.00),
('Caseína', 30, 'Suplemento de proteína de caseína', 110.00),
('Maltodextrina', 60, 'Suplemento de carboidrato', 35.00),
('HMB', 15, 'Suplemento de ácido beta-hidroxi beta-metilbutírico', 85.00),
('L-Carnitina', 25, 'Suplemento de L-carnitina', 95.00),
('Arginina', 20, 'Suplemento de L-arginina', 50.00);

-- Inserir funcionários
INSERT INTO funcionario (nome, idade, sexo, cargo, salario, nascimento) VALUES
('Carlos Silva', 30, 'm', 'vendedor', 3000.00, '1993-01-01'),
('Ana Souza', 40, 'f', 'gerente', 5000.00, '1983-01-01'),
('Pedro Alves', 35, 'm', 'vendedor', 3200.00, '1988-01-01'),
('Maria Oliveira', 45, 'f', 'CEO', 10000.00, '1978-01-01'),
('João Santos', 28, 'm', 'vendedor', 2800.00, '1995-01-01');

-- Inserir clientes
INSERT INTO cliente (nome, sexo, idade, nascimento) VALUES
('Ana Silva', 'F', 28, '1996-03-14'),
('Bruno Oliveira', 'M', 34, '1990-07-22'),
('Carlos Souza', 'M', 45, '1979-01-10'),
('Daniela Costa', 'F', 22, '2002-05-25'),
('Eduardo Pereira', 'M', 31, '1993-12-03'),
('Fernanda Lima', 'F', 29, '1995-09-18'),
('Gabriel Martins', 'M', 27, '1997-11-05'),
('Helena Rodrigues', 'F', 36, '1988-04-09'),
('Igor Alves', 'M', 24, '2000-08-30'),
('Juliana Ferreira', 'F', 33, '1991-02-17'),
('Kleber Araújo', 'M', 39, '1985-06-12'),
('Larissa Mendes', 'F', 26, '1998-07-07'),
('Marcos Antunes', 'M', 42, '1982-03-19'),
('Natália Barros', 'F', 23, '2001-10-14'),
('Otávio Pinto', 'M', 37, '1987-11-21'),
('Patrícia Moraes', 'F', 31, '1993-01-02'),
('Quintino Santos', 'M', 40, '1984-12-15'),
('Raquel Teixeira', 'F', 27, '1997-04-11'),
('Sérgio Reis', 'M', 35, '1989-06-23'),
('Tatiane Ribeiro', 'F', 32, '1992-05-06'),
('Ubirajara Nunes', 'M', 50, '1974-08-19'),
('Vanessa Cardoso', 'F', 28, '1996-09-26'),
('Wagner Matos', 'M', 29, '1995-02-28'),
('Ximena Dias', 'F', 33, '1991-12-11'),
('Yuri Farias', 'M', 26, '1998-03-05'),
('Zélia Vasconcelos', 'F', 40, '1984-10-08'),
('Aline Borges', 'F', 30, '1994-07-15'),
('Bernardo Cunha', 'M', 38, '1986-02-22'),
('Cíntia Andrade', 'F', 24, '2000-01-20'),
('Diogo Campos', 'M', 35, '1989-09-30'),
('Eliane Lopes', 'F', 41, '1983-06-27'),
('Felipe Monteiro', 'M', 33, '1991-04-16'),
('Gustavo Assis', 'M', 27, '1997-05-04'),
('Heloísa Rocha', 'F', 36, '1988-02-14'),
('Ícaro Vasconcelos', 'M', 22, '2002-11-09'),
('Joana Dantas', 'F', 29, '1995-03-18'),
('Leandro Batista', 'M', 34, '1990-12-06'),
('Maria Eduarda Coelho', 'F', 25, '1999-08-21'),
('Nicolas Sousa', 'M', 32, '1992-09-14'),
('Olívia Fonseca', 'F', 30, '1994-10-19'),
('Paulo Viana', 'M', 37, '1987-05-11'),
('Quésia Freitas', 'F', 28, '1996-07-30'),
('Renato Guerra', 'M', 31, '1993-11-25'),
('Sandra Pires', 'F', 27, '1997-12-16'),
('Thiago Marques', 'M', 33, '1991-06-08'),
('Úrsula Guimarães', 'F', 38, '1986-01-13'),
('Vinícius Rocha', 'M', 24, '2000-05-27'),
('William Tavares', 'M', 40, '1984-04-22'),
('Yasmin Figueiredo', 'F', 23, '2001-07-09'),
('Zeca Andrade', 'M', 45, '1979-02-15'),
('Alice Oliveira', 'F', 26, '1998-11-02'),
('Bruno Machado', 'M', 30, '1994-01-28'),
('Catarina Neves', 'F', 29, '1995-06-03'),
('Diego Ferreira', 'M', 36, '1988-08-15'),
('Estela Barbosa', 'F', 31, '1993-10-04'),
('Fábio Menezes', 'M', 32, '1992-02-29'),
('Gabriela Silva', 'F', 27, '1997-01-09'),
('Heitor Lima', 'M', 39, '1985-12-17'),
('Isabela Pinto', 'F', 24, '2000-04-05'),
('Jorge Nascimento', 'M', 28, '1996-09-22'),
('Kelly Souza', 'F', 35, '1989-03-30'),
('Lucas Almeida', 'M', 30, '1994-12-25'),
('Mariana Dias', 'F', 25, '1999-06-12'),
('Natan Costa', 'M', 34, '1990-08-19'),
('Olga Ramos', 'F', 28, '1996-05-10'),
('Pedro Henrique Carvalho', 'M', 33, '1991-07-01'),
('Quirino Lemos', 'M', 40, '1984-11-24'),
('Rafaela Cruz', 'F', 27, '1997-02-11'),
('Samuel Santos', 'M', 31, '1993-10-29'),
('Tamara Azevedo', 'F', 22, '2002-12-08'),
('Ulisses Gomes', 'M', 29, '1995-01-05'),
('Verônica Martins', 'F', 30, '1994-11-16'),
('Wesley Moreira', 'M', 32, '1992-06-18'),
('Xavier Castro', 'M', 38, '1986-04-27'),
('Yara Mendes', 'F', 26, '1998-08-03'),
('Zélio Oliveira', 'M', 45, '1979-05-09'),
('Amélia Campos', 'F', 33, '1991-11-12'),
('Breno Gomes', 'M', 39, '1985-08-25'),
('Clarice Ferreira', 'F', 29, '1995-07-06'),
('Danilo Vieira', 'M', 31, '1993-09-03'),
('Elisa Araújo', 'F', 26, '1998-04-13'),
('Felipe Borges', 'M', 27, '1997-06-21'),
('Gabrielle Santos', 'F', 35, '1989-12-20'),
('Henrique Barros', 'M', 40, '1984-03-29'),
('Ivone Batista', 'F', 30, '1994-02-08'),
('José Matos', 'M', 32, '1992-01-26'),
('Karla Fernandes', 'F', 28, '1996-10-23'),
('Luan Souza', 'M', 34, '1990-05-17'),
('Márcia Cardoso', 'F', 36, '1988-11-08'),
('Nelson Rocha', 'M', 29, '1995-02-24'),
('Otávia Gomes', 'F', 25, '1999-03-31'),
('Paula Rodrigues', 'F', 28, '1996-07-20'),
('Ricardo Sampaio', 'M', 37, '1987-11-30'),
('Sabrina Lemos', 'F', 30, '1994-09-26'),
('Tiago Oliveira', 'M', 32, '1992-06-04'),
('Úrsula Cunha', 'F', 29, '1995-12-22'),
('Vitor Menezes', 'M', 26, '1998-01-18');

-- Trigger para Funcionário Especial
DELIMITER //
CREATE TRIGGER atualiza_funcionario_especial
AFTER INSERT ON venda
FOR EACH ROW
BEGIN
    DECLARE total_vendas DECIMAL(10, 2);
    DECLARE bonus DECIMAL(10, 2);
    
    SELECT SUM(p.valor * v.quantidade) INTO total_vendas
    FROM venda v
    JOIN produto p ON v.id_produto = p.id
    WHERE v.id_vendedor = NEW.id_vendedor;
    
    IF total_vendas > 1000.00 THEN
        SET bonus = total_vendas * 0.05;
        INSERT INTO funcionarioespecial (id_funcionario, bonus) VALUES (NEW.id_vendedor, bonus);
        SELECT CONCAT('Bônus total necessário: ', SUM(bonus)) INTO @message
        FROM funcionarioespecial;
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = @message;
    END IF;
END;
//
DELIMITER ;

-- Cliente Especial
DELIMITER //
CREATE TRIGGER atualiza_cliente_especial
AFTER INSERT ON venda
FOR EACH ROW
BEGIN
    DECLARE total_compras DECIMAL(10, 2);
    DECLARE cashback DECIMAL(10, 2);
    
    SELECT SUM(p.valor * v.quantidade) INTO total_compras
    FROM venda v
    JOIN produto p ON v.id_produto = p.id
    WHERE v.id_cliente = NEW.id_cliente;
    
    IF total_compras > 500.00 THEN
        SET cashback = total_compras * 0.02;
        INSERT INTO clienteespecial (id_cliente, cashback) VALUES (NEW.id_cliente, cashback);
        SELECT CONCAT('Valor total de cashback necessário: ', SUM(cashback)) INTO @message
        FROM clienteespecial;
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = @message;
    END IF;
END;
//
DELIMITER ;

-- Remover Cliente Especial
DELIMITER //
CREATE TRIGGER remove_cliente_especial
AFTER UPDATE ON clienteespecial
FOR EACH ROW
BEGIN
    IF NEW.cashback = 0 THEN
        DELETE FROM clienteespecial WHERE id = NEW.id;
    END IF;
END;
//
DELIMITER ;

-- Usuário Administrador
CREATE USER 'admin'@'localhost' IDENTIFIED BY 'adminpassword';
GRANT ALL PRIVILEGES ON FitDB.* TO 'admin'@'localhost';

-- Usuário Gerente
CREATE USER 'manager'@'localhost' IDENTIFIED BY 'managerpassword';
GRANT SELECT, DELETE, UPDATE ON FitDB.* TO 'manager'@'localhost';

-- Usuário Funcionário
CREATE USER 'employee'@'localhost' IDENTIFIED BY 'employeepassword';
GRANT INSERT, SELECT ON FitDB.* TO 'employee'@'localhost';

-- Produtos mais vendidos
CREATE VIEW produtos_mais_vendidos AS
SELECT p.nome, COUNT(v.id) AS total_vendas
FROM produto p
JOIN venda v ON p.id = v.id_produto
GROUP BY p.nome
ORDER BY total_vendas DESC;

-- Valor ganho com produtos
CREATE VIEW valor_ganho_produtos AS
SELECT p.nome, SUM(p.valor * v.quantidade) AS total_valor
FROM produto p
JOIN venda v ON p.id = v.id_produto
GROUP BY p.nome;

-- View de Clientes Ativos
CREATE VIEW clientes_mais_compraram AS
SELECT c.nome AS cliente, SUM(p.valor * v.quantidade) AS total_compras
FROM cliente c
JOIN venda v ON c.id = v.id_cliente
JOIN produto p ON v.id_produto = p.id
GROUP BY c.nome
ORDER BY total_compras DESC;

-- View de Vendas Mensais
CREATE VIEW vendas_mensais AS
SELECT YEAR(data) AS ano, MONTH(data_venda) AS mes, SUM(total) AS total_vendas
FROM venda
GROUP BY YEAR(data_venda), MONTH(data_venda);

-- Produtos mais vendidos
CREATE VIEW produtos_mais_vendidos AS
SELECT p.nome, COUNT(v.id) AS total_vendas
FROM produto p
JOIN venda v ON p.id = v.id_produto
GROUP BY p.nome
ORDER BY total_vendas DESC;

-- Valor ganho com produtos
CREATE VIEW valor_ganho_produtos AS
SELECT p.nome, SUM(p.valor * v.quantidade) AS total_valor
FROM produto p
JOIN venda v ON p.id = v.id_produto
GROUP BY p.nome;

-- View de Clientes Ativos
CREATE VIEW clientes_ativos AS
SELECT c.id, c.nome, c.email, COUNT(v.id) AS total_compras
FROM cliente c
JOIN venda v ON c.id = v.cliente_id
WHERE v.data_venda >= DATE_SUB(CURRENT_DATE(), INTERVAL 6 MONTH) -- considerando os últimos 6 meses
GROUP BY c.id
ORDER BY total_compras DESC;

-- View de Vendas Mensais
CREATE VIEW vendas_mensais AS
SELECT YEAR(v.data) AS ano, MONTH(v.data) AS mes, SUM(p.valor * v.quantidade) AS total_vendas
FROM venda v
JOIN produto p ON v.id_produto = p.id
GROUP BY YEAR(v.data), MONTH(v.data)
ORDER BY ano, mes;

-- Procedimento de Venda
DELIMITER //
CREATE PROCEDURE realizar_venda(IN id_vendedor INT, IN id_cliente INT, IN id_produto INT, IN quantidade INT)
BEGIN
    DECLARE produto_quantidade INT;
    
    SELECT quantidade INTO produto_quantidade FROM produto WHERE id = id_produto;
    
    IF produto_quantidade >= quantidade THEN
        INSERT INTO venda (id_vendedor, id_cliente, id_produto, quantidade, data) VALUES (id_vendedor, id_cliente, id_produto, quantidade, CURDATE());
        UPDATE produto SET quantidade = quantidade - quantidade WHERE id = id_produto;
    ELSE
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Quantidade insuficiente no estoque';
    END IF;
END //
DELIMITER ;

-- Procedimento de Reajuste Salarial Positivo
DELIMITER //
CREATE PROCEDURE reajuste_salarial_positivo(IN percentual DECIMAL(5,2), IN categoria ENUM('vendedor', 'gerente', 'CEO'))
BEGIN
    UPDATE funcionario
    SET salario = salario + (salario * (percentual / 100))
    WHERE cargo = categoria;
END //
DELIMITER ;

-- Procedimento de Reajuste Salarial Negativo
DELIMITER //
CREATE PROCEDURE reajuste_salarial_negativo(IN percentual DECIMAL(5,2), IN categoria ENUM('vendedor', 'gerente', 'CEO'))
BEGIN
    UPDATE funcionario
    SET salario = salario - (salario * (percentual / 100))
    WHERE cargo = categoria;
END //
DELIMITER ;

-- Procedimento de Sorteio
DELIMITER //
CREATE PROCEDURE sorteio_premiacao()
BEGIN
    DECLARE cliente_id INT;
    DECLARE is_special BOOLEAN;
    DECLARE premio DECIMAL(10, 2);
    
    SET cliente_id = (SELECT id FROM cliente ORDER BY RAND() LIMIT 1);
    SET is_special = (SELECT COUNT(*) FROM clienteespecial WHERE id_cliente = cliente_id) > 0;
    
    IF is_special THEN
        SET premio = 200.00;
    ELSE
        SET premio = 100.00;
    END IF;
    
    INSERT INTO premios (id_cliente, valor) VALUES (cliente_id, premio);
END //
DELIMITER ;

-- Procedimento Estatisticas
DELIMITER //
CREATE PROCEDURE Estatisticas()
BEGIN
    -- Produto mais vendido
    SELECT p.nome AS 'Produto mais vendido'
    FROM produto p
    JOIN (
        SELECT id_produto, SUM(quantidade) AS total_vendido
        FROM venda
        GROUP BY id_produto
        ORDER BY total_vendido DESC
        LIMIT 1
    ) AS mais_vendido ON p.id = mais_vendido.id_produto;
    
    -- Vendedor associado ao produto mais vendido
    SELECT f.nome AS 'Vendedor associado ao produto mais vendido'
    FROM funcionario f
    JOIN (
        SELECT v.id_vendedor
        FROM venda v
        JOIN (
            SELECT id_produto, SUM(quantidade) AS total_vendido
            FROM venda
            GROUP BY id_produto
            ORDER BY total_vendido DESC
            LIMIT 1
        ) AS mais_vendido ON v.id_produto = mais_vendido.id_produto
        GROUP BY v.id_vendedor
        ORDER BY SUM(v.quantidade) DESC
        LIMIT 1
    ) AS vendedor_mais_vendido ON f.id = vendedor_mais_vendido.id_vendedor;

    -- Produto menos vendido
    SELECT p.nome AS 'Produto menos vendido'
    FROM produto p
    JOIN (
        SELECT id_produto, SUM(quantidade) AS total_vendido
        FROM venda
        GROUP BY id_produto
        ORDER BY total_vendido ASC
        LIMIT 1
    ) AS menos_vendido ON p.id = menos_vendido.id_produto;
    
    -- Valor ganho com o produto mais vendido
    SELECT (mais_vendido.total_vendido * p.valor) AS 'Valor ganho com o produto mais vendido'
    FROM (
        SELECT id_produto, SUM(quantidade) AS total_vendido
        FROM venda
        GROUP BY id_produto
        ORDER BY total_vendido DESC
        LIMIT 1
    ) AS mais_vendido
    JOIN produto p ON mais_vendido.id_produto = p.id;
    
    -- Mês de maior vendas e mês de menor vendas do produto mais vendido
    SELECT YEAR(v.data) AS ano, MONTH(v.data) AS mes, SUM(v.quantidade) AS total_vendido
    FROM venda v
    WHERE v.id_produto = (
        SELECT id_produto
        FROM (
            SELECT id_produto, SUM(quantidade) AS total_vendido
            FROM venda
            GROUP BY id_produto
            ORDER BY total_vendido DESC
            LIMIT 1
        ) AS mais_vendido
    )
    GROUP BY YEAR(v.data), MONTH(v.data)
    ORDER BY total_vendido DESC
    LIMIT 1;

    SELECT YEAR(v.data) AS ano, MONTH(v.data) AS mes, SUM(v.quantidade) AS total_vendido
    FROM venda v
    WHERE v.id_produto = (
        SELECT id_produto
        FROM (
            SELECT id_produto, SUM(quantidade) AS total_vendido
            FROM venda
            GROUP BY id_produto
            ORDER BY total_vendido DESC
            LIMIT 1
        ) AS mais_vendido
    )
    GROUP BY YEAR(v.data), MONTH(v.data)
    ORDER BY total_vendido ASC
    LIMIT 1;

    -- Valor ganho com o produto menos vendido
    SELECT (menos_vendido.total_vendido * p.valor) AS 'Valor ganho com o produto menos vendido'
    FROM (
        SELECT id_produto, SUM(quantidade) AS total_vendido
        FROM venda
        GROUP BY id_produto
        ORDER BY total_vendido ASC
        LIMIT 1
    ) AS menos_vendido
    JOIN produto p ON menos_vendido.id_produto = p.id;
    
    -- Mês de maior vendas e mês de menor vendas do produto menos vendido
    SELECT YEAR(v.data) AS ano, MONTH(v.data) AS mes, SUM(v.quantidade) AS total_vendido
    FROM venda v
    WHERE v.id_produto = (
        SELECT id_produto
        FROM (
            SELECT id_produto, SUM(quantidade) AS total_vendido
            FROM venda
            GROUP BY id_produto
            ORDER BY total_vendido ASC
            LIMIT 1
        ) AS menos_vendido
    )
    GROUP BY YEAR(v.data), MONTH(v.data)
    ORDER BY total_vendido DESC
    LIMIT 1;

    SELECT YEAR(v.data) AS ano, MONTH(v.data) AS mes, SUM(v.quantidade) AS total_vendido
    FROM venda v
    WHERE v.id_produto = (
        SELECT id_produto
        FROM (
            SELECT id_produto, SUM(quantidade) AS total_vendido
            FROM venda
            GROUP BY id_produto
            ORDER BY total_vendido ASC
            LIMIT 1
        ) AS menos_vendido
    )
    GROUP BY YEAR(v.data), MONTH(v.data)
    ORDER BY total_vendido ASC
    LIMIT 1;

END //

-- -- Alterar a tabela funcionario para adicionar restrição ENUM para cargo
-- ALTER TABLE funcionario
-- MODIFY COLUMN cargo ENUM('vendedor', 'gerente', 'CEO') NOT NULL;

-- -- Alterar a tabela cliente para adicionar restrição ENUM para sexo
-- ALTER TABLE cliente
-- MODIFY COLUMN sexo ENUM('M', 'F', 'O') NOT NULL;


