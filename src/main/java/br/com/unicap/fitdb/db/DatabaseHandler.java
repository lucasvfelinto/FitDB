package main.java.br.com.unicap.fitdb.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import main.java.br.com.unicap.fitdb.config.DatabaseConfig;

import java.sql.SQLException;

// A classe possui um atributo dbConnection que recebe uma instância da classe databaseConnection
public class DatabaseHandler {
    private DatabaseConnection dbConnection;

    public DatabaseHandler(DatabaseConnection databaseConnection) {
        this.dbConnection = databaseConnection;
    }
/*
 O método createDatabase chama o método getConnection do objeto DatabaseConnection,
 o qual retornará um objeto connection, caso a conexão seja estabelecida com sucesso.
 Se ocorrer um erro uma SQLException é lançada.



 A interface Connection na API JDBC possui vários métodos para manipular uma conexão com um banco de dados. 
 Dentre eles, 'createStatement()' cria um objeto 'Statement', o qual é uma interface na API JDBC que representa 
 uma instrução SQL, a qual pode ser enviada para um banco de dados e executada. 



 A interface Statement possui vários métodos referentes a comandos SQL e manipulação dos resultados retornados pelo 
 banco de dados.
 Dentre eles, 'executeUpdate' é utilizado para executar comandos SQL que modificam o banco de dados, tais quais 'INSERT',
 'UPDATE','DELETE', além de 'CREATE DATABASE' e 'DROP DATABASE'
*/
// ERRO 
        public boolean databaseExists(DatabaseConfig config, String dbName) {
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

    public void createDatabase(String dbName) throws SQLException { // recebe uma string referente ao nome do banco de dados
        try (Connection connection = dbConnection.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE DATABASE " + dbName);
        }
    }

    public void dropDatabase(String dbName) throws SQLException {   // recebe uma string referente ao nome do banco de dados
        try (Connection connection = dbConnection.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("DROP DATABASE " + dbName);
        }
    }
}