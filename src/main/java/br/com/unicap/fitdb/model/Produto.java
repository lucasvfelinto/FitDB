package main.java.br.com.unicap.fitdb.model;

import java.math.BigDecimal;

public class Produto {
    private int id;
    private String nome;
    private int quantidade;
    private String descricao;
    private BigDecimal valor;

    public Produto(int id, String nome, int quantidade, String descricao, BigDecimal valor) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.valor = valor;
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setValor(String valor) {
        this.valor = new BigDecimal(valor);
    }

    public String getValorAsString() {
        return valor.toString();
    }
}
