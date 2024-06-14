package main.java.br.com.unicap.fitdb.service;

import main.java.br.com.unicap.fitdb.dao.FuncionarioDAO;
import main.java.br.com.unicap.fitdb.model.Funcionario;

public class FuncionarioService {
    private FuncionarioDAO funcionarioDAO;

    public FuncionarioService(FuncionarioDAO funcionarioDAO) {
        this.funcionarioDAO = funcionarioDAO;
    }

    public boolean registerFuncionario(Funcionario funcionario) {
        return funcionarioDAO.createFuncionario(funcionario);
    }

    public Funcionario getFuncionarioById(int id) {
        return funcionarioDAO.getFuncionarioById(id);
    }

    public boolean updateFuncionario(Funcionario funcionario) {
        return funcionarioDAO.updateFuncionario(funcionario);
    }

    public boolean deleteFuncionario(int id) {
        return funcionarioDAO.deleteFuncionario(id);
    }
}
