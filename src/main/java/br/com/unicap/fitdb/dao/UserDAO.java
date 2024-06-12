package main.java.br.com.unicap.fitdb.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.br.com.unicap.fitdb.db.DatabaseConnection;
import main.java.br.com.unicap.fitdb.model.User;

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
    private DatabaseConnection databaseConnection;

    public UserDAO(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public void createUser(User user) throws SQLException {
        String sql = "INSERT INTO users (name, email) VALUES (?, ?)";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.executeUpdate();
        }
    }

    public User getUser(int id) throws SQLException { // nao entendi
        String sql = "SELECT * FROM users WHERE id = ?";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new User(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("email"));
            }
        }
        return null;
    }

    // Outros métodos CRUD (update, delete)
}

