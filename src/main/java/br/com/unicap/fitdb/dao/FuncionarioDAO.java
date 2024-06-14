package main.java.br.com.unicap.fitdb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import main.java.br.com.unicap.fitdb.db.DatabaseConnection;
import main.java.br.com.unicap.fitdb.model.Funcionario;

public class FuncionarioDAO {
    private DatabaseConnection databaseConnection;

    public FuncionarioDAO(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public boolean createFuncionario(Funcionario funcionario) {
        String sql = "INSERT INTO funcionario (nome, idade, sexo, cargo, salario, nascimento) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, funcionario.getNome());
            statement.setInt(2, funcionario.getIdade());
            statement.setString(3, funcionario.getSexo());
            statement.setString(4, funcionario.getCargo());
            statement.setBigDecimal(5, funcionario.getSalario());
            statement.setDate(6, java.sql.Date.valueOf(funcionario.getNascimento()));
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao criar o funcionário!");
            e.printStackTrace();
            return false;
        }
    }

    public Funcionario getFuncionarioById(int id) {
        String sql = "SELECT * FROM funcionario WHERE id = ?";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Funcionario(
                        resultSet.getInt("id"),
                        resultSet.getString("nome"),
                        resultSet.getInt("idade"),
                        resultSet.getString("sexo"),
                        resultSet.getString("cargo"),
                        resultSet.getBigDecimal("salario"),
                        resultSet.getDate("nascimento").toLocalDate()
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao obter o funcionário!");
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateFuncionario(Funcionario funcionario) {
        String sql = "UPDATE funcionario SET nome = ?, idade = ?, sexo = ?, cargo = ?, salario = ?, nascimento = ? WHERE id = ?";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, funcionario.getNome());
            statement.setInt(2, funcionario.getIdade());
            statement.setString(3, funcionario.getSexo());
            statement.setString(4, funcionario.getCargo());
            statement.setBigDecimal(5, funcionario.getSalario());
            statement.setDate(6, java.sql.Date.valueOf(funcionario.getNascimento()));
            statement.setInt(7, funcionario.getId());
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar o funcionário!");
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteFuncionario(int id) {
        String sql = "DELETE FROM funcionario WHERE id = ?";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar o funcionário!");
            e.printStackTrace();
            return false;
        }
    }
}
