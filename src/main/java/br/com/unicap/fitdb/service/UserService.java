package main.java.br.com.unicap.fitdb.service;

import java.sql.SQLException;

import main.java.br.com.unicap.fitdb.dao.UserDAO;
import main.java.br.com.unicap.fitdb.model.User;

public class UserService {
    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void addUser(User user) throws SQLException {
        // Validação e lógica de negócios
        if (user.getUsername() == null || user.getEmail() == null) {
            throw new IllegalArgumentException("Nome e email são obrigatórios");
        }
        userDAO.createUser(user);
    }

    public User getUser(int id) throws SQLException {
        User user = userDAO.getUser(id);
        // Lógica de negócios adicional
        if (user == null) {
            throw new SQLException("Usuário não encontrado");
        }
        return user;
    }

    // Outros métodos de lógica de negócios
}
