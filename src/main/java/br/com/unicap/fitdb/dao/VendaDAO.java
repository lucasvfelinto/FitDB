package main.java.br.com.unicap.fitdb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import main.java.br.com.unicap.fitdb.db.DatabaseConnection;
import main.java.br.com.unicap.fitdb.model.Venda;

public class VendaDAO {
    private DatabaseConnection databaseConnection;

    public VendaDAO(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public boolean createVenda(Venda venda) {
        String sql = "INSERT INTO venda (id_vendedor, id_cliente, id_produto, quantidade, data) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, venda.getIdVendedor());
            statement.setInt(2, venda.getIdCliente());
            statement.setInt(3, venda.getIdProduto());
            statement.setInt(4, venda.getQuantidade());
            statement.setDate(5, java.sql.Date.valueOf(venda.getData()));
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao criar a venda!");
            e.printStackTrace();
            return false;
        }
    }

    public Venda getVendaById(int id) {
        String sql = "SELECT * FROM venda WHERE id = ?";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Venda(
                        resultSet.getInt("id"),
                        resultSet.getInt("id_vendedor"),
                        resultSet.getInt("id_cliente"),
                        resultSet.getInt("id_produto"),
                        resultSet.getInt("quantidade"),
                        resultSet.getDate("data").toLocalDate()
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao obter a venda!");
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateVenda(Venda venda) {
        String sql = "UPDATE venda SET id_vendedor = ?, id_cliente = ?, id_produto = ?, quantidade = ?, data = ? WHERE id = ?";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, venda.getIdVendedor());
            statement.setInt(2, venda.getIdCliente());
            statement.setInt(3, venda.getIdProduto());
            statement.setInt(4, venda.getQuantidade());
            statement.setDate(5, java.sql.Date.valueOf(venda.getData()));
            statement.setInt(6, venda.getId());
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar a venda!");
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteVenda(int id) {
        String sql = "DELETE FROM venda WHERE id = ?";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar a venda!");
            e.printStackTrace();
            return false;
        }
    }
}
