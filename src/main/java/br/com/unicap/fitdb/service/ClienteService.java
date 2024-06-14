package main.java.br.com.unicap.fitdb.service;

import main.java.br.com.unicap.fitdb.dao.ClienteDAO;
import main.java.br.com.unicap.fitdb.model.Cliente;

public class ClienteService {
    private ClienteDAO clienteDAO;

    public ClienteService(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    public boolean registerCliente(Cliente cliente) {
        return clienteDAO.createCliente(cliente);
    }

    public Cliente getClienteById(int id) {
        return clienteDAO.getClienteById(id);
    }

    public boolean updateCliente(Cliente cliente) {
        return clienteDAO.updateCliente(cliente);
    }

    public boolean deleteCliente(int id) {
        return clienteDAO.deleteCliente(id);
    }
}
