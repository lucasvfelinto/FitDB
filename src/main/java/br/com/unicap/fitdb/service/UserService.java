package main.java.br.com.unicap.fitdb.service;

import main.java.br.com.unicap.fitdb.dao.UserDAO;
import main.java.br.com.unicap.fitdb.model.User;

public class UserService {
    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public boolean registerUser(User usuario) {
        return userDAO.createUser(usuario.getUsername(), usuario.getPassword(), usuario.getRole());
    }

    public boolean loginUser(User usuario) {
        return userDAO.loginUser(usuario.getUsername(), usuario.getPassword());
    }
    public String getUserRole(String username) {
        return userDAO.getUserRole(username);
    }
}
