package main.java.br.com.unicap.fitdb.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Funcionario {
    private int id;
    private String nome;
    private int idade;
    private String sexo;
    private String cargo;
    private BigDecimal salario;
    private LocalDate nascimento;

    // Formato de data esperado (ex: "dd/MM/yyyy")
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Funcionario(int id, String nome, int idade, String sexo, String cargo, BigDecimal salario, LocalDate nascimento) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.cargo = cargo;
        this.salario = salario;
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public void setSalario(String salario) {
        this.salario = new BigDecimal(salario);
    }

    public String getSalarioAsString() {
        return salario.toString();
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
