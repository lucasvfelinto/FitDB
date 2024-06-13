package main.java.br.com.unicap.fitdb.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.br.com.unicap.fitdb.db.DatabaseConnection;

/*
 O DAO (Database Access Object) é um padrão de design utilizado para abstrair e encapsular 
 todas as interações com a fonte de dados. Ele oculta os detalhes específicos da tecnologia 
 de persistência do restante da aplicação. Isso permite que outras partes do código interajam 
 com os dados sem precisar conhecer os detalhes de como esses dados são armazenados ou recuperados.
 
 Os DAOs operam sobre objetos de modelo que representam os dados da aplicação. Neste caso, 
 'UserDAO' operar sobre objetos User.

 Os serviços utilizam os DAOs para executar operações de negócio. De modo que, 'UserService' usa
 um UserDAO para acessar dados de usuário, aplicar regras de negócio e coordenar operações mais complexas.

 Os controladores interagem com a camada de serviço para responder às solicitações do usuário. 
 Eles não interagem diretamente com os DAOs. Por exemplo, um UserController pode chamar métodos de UserService, 
 que por sua vez utiliza UserDAO.
 */


 public class UserDAO {
     private DatabaseConnection dbConnection;
 
     public UserDAO(DatabaseConnection dbConnection) {
         this.dbConnection = dbConnection;
     }
 
     // Método para criar um novo usuário
     public boolean createUser(String username, String password, String role) {
         String query = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";
         try (Connection connection = dbConnection.getConnection();
              PreparedStatement preparedStatement = connection.prepareStatement(query)) {
             preparedStatement.setString(1, username);
             preparedStatement.setString(2, password);
             preparedStatement.setString(3, role);
             int result = preparedStatement.executeUpdate();
             return result > 0;
         } catch (SQLException e) {
             System.out.println("Erro ao criar o usuário");
             e.printStackTrace();
             return false;
         }
     }
     
 
     // Método para autenticar um usuário
     public boolean authenticateUser(String username, String password) {
         String query = "SELECT password FROM users WHERE username = ?";
         try (Connection connection = dbConnection.getConnection();
              PreparedStatement preparedStatement = connection.prepareStatement(query)) {
             preparedStatement.setString(1, username);
             try (ResultSet resultSet = preparedStatement.executeQuery()) {
                 if (resultSet.next()) {
                     String storedPassword = resultSet.getString("password");
                     return storedPassword.equals(password);
                 }
             }
         } catch (SQLException e) {
             System.out.println("Erro ao autenticar o usuário");
             e.printStackTrace();
         }
         return false;
     }
 

    public void setDatabaseConnection(DatabaseConnection databaseConnection) {
        this.dbConnection = databaseConnection;
    }

    // Outros métodos CRUD (update, delete)
}

