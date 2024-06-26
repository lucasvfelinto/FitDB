package main.java.br.com.unicap.fitdb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import main.java.br.com.unicap.fitdb.db.DatabaseConnection;
import main.java.br.com.unicap.fitdb.model.Cliente;

public class ClienteDAO {
    private DatabaseConnection databaseConnection;

    public ClienteDAO(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public boolean createCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (nome, sexo, idade, nascimento) VALUES (?, ?, ?, ?)";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getSexo());
            statement.setInt(3, cliente.getIdade());
            statement.setDate(4, java.sql.Date.valueOf(cliente.getNascimento()));
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao criar o cliente!");
            e.printStackTrace();
            return false;
        }
    }

    public Cliente getClienteById(int id) {
        String sql = "SELECT * FROM cliente WHERE id = ?";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Cliente(
                        resultSet.getInt("id"),
                        resultSet.getString("nome"),
                        resultSet.getString("sexo"),
                        resultSet.getInt("idade"),
                        resultSet.getDate("nascimento").toLocalDate()
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao obter o cliente!");
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateCliente(Cliente cliente) {
        String sql = "UPDATE cliente SET nome = ?, sexo = ?, idade = ?, nascimento = ? WHERE id = ?";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getSexo());
            statement.setInt(3, cliente.getIdade());
            statement.setDate(4, java.sql.Date.valueOf(cliente.getNascimento()));
            statement.setInt(5, cliente.getId());
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar o cliente!");
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteCliente(int id) {
        String sql = "DELETE FROM cliente WHERE id = ?";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar o cliente!");
            e.printStackTrace();
            return false;
        }
    }
}
