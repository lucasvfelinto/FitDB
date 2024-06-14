package main.java.br.com.unicap.fitdb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import main.java.br.com.unicap.fitdb.db.DatabaseConnection;

public class UserDAO {
    private DatabaseConnection databaseConnection;

    public UserDAO(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public boolean createUser(String username, String password, String role) {
        String sql = "INSERT INTO usuarios (username, password, role) VALUES (?, ?, ?)";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, role);
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao criar o usuário!");
            e.printStackTrace();
            return false;
        }
    }

    public boolean loginUser(String username, String password) {
        String sql = "SELECT * FROM usuarios WHERE username = ? AND password = ?";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            statement.setString(2, password);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao efetuar login!");
            e.printStackTrace();
            return false;
        }
    }

    public void setDatabaseConnection(DatabaseConnection conexao) {
        this.databaseConnection = conexao;
    }

    public String getUserRole(String username) {
        String sql = "SELECT role FROM usuarios WHERE username = ?";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString("role");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
