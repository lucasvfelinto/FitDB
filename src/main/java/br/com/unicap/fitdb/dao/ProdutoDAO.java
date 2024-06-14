package main.java.br.com.unicap.fitdb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import main.java.br.com.unicap.fitdb.db.DatabaseConnection;
import main.java.br.com.unicap.fitdb.model.Produto;

public class ProdutoDAO {
    private DatabaseConnection databaseConnection;

    public ProdutoDAO(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public boolean createProduto(Produto produto) {
        String sql = "INSERT INTO produto (nome, quantidade, descricao, valor) VALUES (?, ?, ?, ?)";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, produto.getNome());
            statement.setInt(2, produto.getQuantidade());
            statement.setString(3, produto.getDescricao());
            statement.setBigDecimal(4, produto.getValor());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao criar o produto!");
            e.printStackTrace();
            return false;
        }
    }

    public Produto getProdutoById(int id) {
        String sql = "SELECT * FROM produto WHERE id = ?";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Produto(
                        resultSet.getInt("id"),
                        resultSet.getString("nome"),
                        resultSet.getInt("quantidade"),
                        resultSet.getString("descricao"),
                        resultSet.getBigDecimal("valor")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao obter o produto!");
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateProduto(Produto produto) {
        String sql = "UPDATE produto SET nome = ?, quantidade = ?, descricao = ?, valor = ? WHERE id = ?";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, produto.getNome());
            statement.setInt(2, produto.getQuantidade());
            statement.setString(3, produto.getDescricao());
            statement.setBigDecimal(4, produto.getValor());
            statement.setInt(5, produto.getId());
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar o produto!");
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteProduto(int id) {
        String sql = "DELETE FROM produto WHERE id = ?";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar o produto!");
            e.printStackTrace();
            return false;
        }
    }
}
