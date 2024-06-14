package main.java.br.com.unicap.fitdb.service;

import main.java.br.com.unicap.fitdb.dao.VendaDAO;
import main.java.br.com.unicap.fitdb.model.Venda;

public class VendaService {
    private VendaDAO vendaDAO;

    public VendaService(VendaDAO vendaDAO) {
        this.vendaDAO = vendaDAO;
    }

    public boolean registerVenda(Venda venda) {
        return vendaDAO.createVenda(venda);
    }

    public Venda getVendaById(int id) {
        return vendaDAO.getVendaById(id);
    }

    public boolean updateVenda(Venda venda) {
        return vendaDAO.updateVenda(venda);
    }

    public boolean deleteVenda(int id) {
        return vendaDAO.deleteVenda(id);
    }
}
