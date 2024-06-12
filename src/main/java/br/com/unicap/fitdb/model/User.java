package main.java.br.com.unicap.fitdb.model;

public class User {
    private int id;
    private String name;
    private String email;
    private int idade;
    private char sexo;

    public User(int id,String name, String email, int idade, char sexo) {
        this.id = id; // db gera?
        this.name = name;
        this.email = email;
        this.idade = idade;
        this.sexo = sexo;
    }

    // public generateID? Ou o banco de dados faz isso automaticamente?

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public char getSexo() {
        return this.sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    
}

