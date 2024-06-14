package main.java.br.com.unicap.fitdb.db;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.SQLException;

// A classe possui um atributo dbConnection que recebe uma instância da classe databaseConnection
public class DatabaseHandler {
    private DatabaseConnection dbConnection;

    public DatabaseHandler(DatabaseConnection databaseConnection) {
        this.dbConnection = databaseConnection;
    }

    /*
     * O método createDatabase chama o método getConnection do objeto
     * DatabaseConnection,
     * o qual retornará um objeto connection, caso a conexão seja estabelecida com
     * sucesso.
     * Se ocorrer um erro uma SQLException é lançada.
     * 
     * 
     * 
     * A interface Connection na API JDBC possui vários métodos para manipular uma
     * conexão com um banco de dados.
     * Dentre eles, 'createStatement()' cria um objeto 'Statement', o qual é uma
     * interface na API JDBC que representa
     * uma instrução SQL, a qual pode ser enviada para um banco de dados e
     * executada.
     * 
     * 
     * 
     * A interface Statement possui vários métodos referentes a comandos SQL e
     * manipulação dos resultados retornados pelo
     * banco de dados.
     * Dentre eles, 'executeUpdate' é utilizado para executar comandos SQL que
     * modificam o banco de dados, tais quais 'INSERT',
     * 'UPDATE','DELETE', além de 'CREATE DATABASE' e 'DROP DATABASE'
     */
    // ERRO

    public boolean executeSqlScript(String filePath, String dbName)throws IOException, SQLException {
        try (Connection connection = dbConnection.getConnection();
                Statement useStatement = connection.createStatement();
                BufferedReader reader = new BufferedReader(new FileReader(filePath));
                Statement statement = connection.createStatement()) {
            useStatement.execute("USE " + dbName);
            String line;
            StringBuilder sql = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                sql.append(line);
                // Verifica se a linha termina com ';' para executar o comando completo
                if (line.trim().endsWith(";")) {
                    statement.execute(sql.toString());
                    sql.setLength(0); // Limpa o StringBuilder para a próxima instrução
                }
            }

            return true;
        } catch (IOException | SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean createDatabaseIfNotExists(String dbName) {
        if (!databaseExists(dbName)) {
            try {
                executeSqlScript("src/DB/Script_FitDB.sql", dbName);
                return true;
            } catch (IOException e) {
                System.out.println("Erro de IO ao executar o script SQL: " + e.getMessage());
                e.printStackTrace();
            } catch (SQLException e) {
                System.out.println("Erro de SQL ao executar o script SQL: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean databaseExists(String dbName) {
        String query = "SELECT SCHEMA_NAME FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME = '" + dbName + "'";
        try (Connection connection = dbConnection.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)) {

            if (resultSet.next()) {
                return true; // Database exists
            }
        } catch (SQLException e) {
            System.out.println("Houve um erro ao acessar o banco de dados");
            System.out.println(e);
            e.printStackTrace();
        }
        return false; // Database does not exist
    }

    public void executeSingleQuery(String query) {
        try (Connection connection = dbConnection.getConnection();
                Statement statement = connection.createStatement()) {
            statement.execute(query);
        } catch (SQLException e) {
            System.out.println("Houve um erro ao executar a query: " + query);
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public boolean createDatabase(String dbName) throws SQLException { // recebe uma string referente ao nome do banco
                                                                       // de dados
        try (Connection connection = dbConnection.getConnection();
                Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE DATABASE " + dbName);
            return true; // Retorna true se a criação do banco de dados for bem-sucedida
        } catch (SQLException e) {
            System.out.println("Houve um erro ao criar o banco de dados");
            e.printStackTrace();
            return false; // Retorna false se houver uma exceção
        }
    }

    public void dropDatabase(String dbName) throws SQLException { // recebe uma string referente ao nome do banco de
                                                                  // dados
        try (Connection connection = dbConnection.getConnection();
                Statement statement = connection.createStatement()) {
            statement.executeUpdate("DROP DATABASE " + dbName);
        } catch (SQLException e) {
            System.out.println("Houve um erro ao conectar o banco de dados");
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public void executeQueries(String[] queries) {
        try (Connection conn = dbConnection.getConnection();
                Statement stmt = conn.createStatement()) {
            for (String query : queries) {
                stmt.execute(query);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void setDbConnection(DatabaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }
}
