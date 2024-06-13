package main.java.br.com.unicap.fitdb.model;

public class User {
    private String username;
    private String password;
    private String email;

    // Construtor sem parâmetros
    public User() {}

    // Construtor com parâmetros
    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.email = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String role) {
        this.email = role;
    }
}


