package main.java.br.com.unicap.fitdb.service;

import main.java.br.com.unicap.fitdb.dao.ProdutoDAO;
import main.java.br.com.unicap.fitdb.model.Produto;

public class ProdutoService {
    private ProdutoDAO produtoDAO;

    public ProdutoService(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }

    public boolean registerProduto(Produto produto) {
        return produtoDAO.createProduto(produto);
    }

    public Produto getProdutoById(int id) {
        return produtoDAO.getProdutoById(id);
    }

    public boolean updateProduto(Produto produto) {
        return produtoDAO.updateProduto(produto);
    }

    public boolean deleteProduto(int id) {
        return produtoDAO.deleteProduto(id);
    }
}
