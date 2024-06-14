package main.java.br.com.unicap.fitdb.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Venda {
    private int id;
    private int idVendedor;
    private int idCliente;
    private int idProduto;
    private int quantidade;
    private LocalDate data;

    // Formato de data esperado (ex: "dd/MM/yyyy")
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Venda(int id, int idVendedor, int idCliente, int idProduto, int quantidade, LocalDate data) {
        this.id = id;
        this.idVendedor = idVendedor;
        this.idCliente = idCliente;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.data = data;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setData(String data) {
        try {
            this.data = LocalDate.parse(data, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Data inválida. Use o formato dd/MM/yyyy.");
        }
    }

    public String getDataAsString() {
        return data.format(formatter);
    }
}
