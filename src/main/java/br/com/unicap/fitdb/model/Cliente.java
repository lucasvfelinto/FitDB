package main.java.br.com.unicap.fitdb.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Cliente {
    private int id;
    private String nome;
    private String sexo;
    private int idade;
    private LocalDate nascimento;

    // Formato de data esperado (ex: "dd/MM/yyyy")
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Cliente(int id, String nome, String sexo, int idade, LocalDate nascimento) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.nascimento = nascimento;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public void setNascimento(String nascimento) {
        try {
            this.nascimento = LocalDate.parse(nascimento, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Data de nascimento inválida. Use o formato dd/MM/yyyy.");
        }
    }

    public String getNascimentoAsString() {
        return nascimento.format(formatter);
    }
}
