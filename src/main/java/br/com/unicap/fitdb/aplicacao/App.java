package main.java.br.com.unicap.fitdb.aplicacao;

import java.sql.SQLException;
import java.util.Scanner;

import main.java.br.com.unicap.fitdb.config.DatabaseConfig;
import main.java.br.com.unicap.fitdb.dao.UserDAO;
import main.java.br.com.unicap.fitdb.db.DatabaseConnection;
import main.java.br.com.unicap.fitdb.db.DatabaseHandler;
import main.java.br.com.unicap.fitdb.model.User;
import main.java.br.com.unicap.fitdb.service.UserService;
import main.java.br.com.unicap.fitdb.aplicacao.Menu;

public class App {
    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        Menu menu = new Menu();

        // Configurações iniciais
        boolean systemStatus = true;
        boolean dbExiste = false;
        String dbName = "";

        // DatabaseConfig é um objeto que encapsula as informações de configuração
        // necessárias para se conectar ao SGBD.
        DatabaseConfig infoConexao = new DatabaseConfig();

        // DatabaseConnection é um objeto que irá utilizar as informações do objeto
        // DatabaseConfig numa instância do DriverManager.
        // O DriverManager é responsável por tentar uma conexão com o SGBD MySQL.
        DatabaseConnection conexao = new DatabaseConnection(infoConexao);

        // DataBaseHandler usa a conexão estabelecida pelo DatabaseConnection para
        // operações no banco de dados.
        DatabaseHandler database = new DatabaseHandler(conexao);

        // UserDAO é uma classe que realiza operações específicas relacionadas aos
        // usuários utilizando a conexão estabelecida.
        UserDAO userOperations = new UserDAO(conexao);

        // Query é uma classe que provavelmente contém consultas SQL ou scripts para
        // interagir com o banco de dados.
        Query queries = new Query();

        // UserService é uma classe responsável por operações de alto nível relacionadas
        // aos usuários, como registro e autenticação.
        // Ela depende do UserDAO para realizar as operações no banco de dados.
        UserService userControl = new UserService(userOperations);

        while (systemStatus) {
            int option = menu.menuAcessoInicial();

            switch (option) {
                case 1:
                    dbName = acessarDBExistente(menu);
                    dbExiste = true;
                    break;
                case 2:
                    importarDBExistente(menu);
                    dbName = "FitDB";
                    boolean dbImportado = true;
                    break;
                case 3:
                    if (criarNovoDB(menu, database)) {
                        dbName = database.get(); // Obter o nome do banco criado do menu, se necessário
                        dbExiste = true;

                    } else {
                        System.out.println("Falha ao criar o banco de dados. Interrompendo a criação.");
                    }
                    break;
                default:
                    systemStatus = false;
                    break;
            }
            if (dbExiste) {
                // Configurar a URL do banco de dados para a conexão
                infoConexao.setUrl("jdbc:mysql://localhost/" + dbName);
                conexao.setConfig(infoConexao);
                database.setDbConnection(conexao);
                while (dbExiste) {
                    option = menu.menuAcessoDb(dbName);
                    switch (option) {
                        case 1:
                            boolean failCadastro = cadastrarUsuario(menu, userControl);
                            while (!failCadastro) {
                                string menuErroCadastrarUsuario();
                                cadastrarUsuario(menu, userControl);
                            }
                            break;
                        case 2:
                            fazerLogin(menu);
                            break;
                        default:
                            // Ação padrão, se necessário
                            break;
                    }
                    if (option == 0) {
                        dbExiste = false;
                    }
                }  
            }
            
            if (!dbExiste) {
                option = menu.menuDbNaoExiste();

                switch (option) {
                    case 1:
                        // Tentar novamente
                        break;
                    case 2:
                        dbName = criarNovoDB(menu);
                        dbExiste = true;
                        break;
                    default:
                        systemStatus = false;
                        break;
                }
            }
        }
        /*
         * // IMPLEMENTAR SAIDA DO PROGRAMA BASEADA EM INPUT!!!!!!
         * 
         * dbExiste = database.databaseExists(dbName); // checa existencia do banco de
         * dados com base no nome informado
         * if (dbExiste == true) {
         * infoConexao.setUrl(infoConexao.getUrl() + "/" + dbName);
         * }
         * do {
         * userOperations.setDatabaseConnection(conexao);// atualiza para garantir que
         * está na conexão certa
         * if (access > 0) {
         * dbName = menu.menuAcesso2(input);
         * dbExiste = database.databaseExists(dbName);
         * }
         * while (dbExiste == true) { // se existir
         * System.out.println(infoConexao.getUrl());
         * conexao.setConfig(infoConexao); // atualiza as informações de conexão
         * database.setDbConnection(conexao); // atualiza as informações de conexão
         * 
         * option = menu.menuInicial(dbName, input); // exibe o menu inicial
         * if (option == 1) { // cadastrar
         * User usuarioCadastro = new User();
         * usuarioCadastro = menu.menuCadastro(input, usuarioCadastro);
         * boolean isRegistered = userControl.registerUser(usuarioCadastro);
         * if (isRegistered == true) { // sucesso no cadastro
         * System.out.println("\nCadastro realizado com sucesso!\n");
         * // exibe o menu inicial
         * } else { // falha no cadastro
         * System.out.
         * println("\nHouve alguma falha na efetuação do cadastro, tente novamente!\n");
         * }
         * } else if (option == 2) { // login
         * User usuarioLogin = new User();
         * usuarioLogin = menu.menuLogin(input, usuarioLogin);
         * boolean isLoggedIn = userControl.loginUser(usuarioLogin);
         * if (isLoggedIn == true) {
         * System.out.println("\nLogin efetuado com sucesso!");
         * String userRole = new String();
         * String choice = new String();
         * userRole = userControl.getUserRole(usuarioLogin.getUsername());
         * while (isLoggedIn == true) {
         * if (userRole.equals("admin")) {
         * choice = menu.menuAdministrador(input);
         * switch (choice) {
         * case "1":
         * gerenciarDb(input);
         * break;
         * case "2":
         * gerenciarFuncionarios(input);
         * break;
         * case "3":
         * verEstatisticas(input);
         * break;
         * default: // x ou X
         * isLoggedIn = false;
         * break;
         * }
         * } else if (userRole.equals("manager")) {
         * choice = menu.menuGerente(input);
         * switch (choice) {
         * case "1":
         * menuBusca(input);
         * break;
         * case "2":
         * menuEdicao(input);
         * break;
         * case "3":
         * menuApagar(input);
         * break;
         * default: // x ou X
         * isLoggedIn = false;
         * break;
         * }
         * } else { // userRole == employee
         * choice = menu.menuFuncionario(input);
         * switch (choice) {
         * case "1":
         * registarVenda(input);
         * break;
         * case "2":
         * consultarVendas(input);
         * break;
         * case "3":
         * cadastrarCliente(input);
         * break;
         * case "4":
         * cadastrarProduto(input);
         * break;
         * default: // x ou X
         * isLoggedIn = false;
         * break;
         * }
         * }
         * }
         * } else {
         * System.out.println("\nHouve um erro na efetuação do login!\n");
         * // volta para o menu inicial
         * }
         * } else { // qualquer outro input, indica exit
         * 
         * }
         * }
         * if (dbExiste != true) { // se o banco informado não existir,
         * option = menu.menuDbNaoExiste(input); // fornece a opção de tentar novamente
         * inserir o nome ou criar o
         * // banco
         * if (option == 2) { // opção 2 criar banco
         * // so pessoas com a informação sensivel podem criar
         * infoConexao.setUser("");
         * infoConexao.setPassword("");
         * 
         * dbName = menu.menuAcesso2(input); // chama o primeiro menu para criar banco,
         * pede para definir o
         * // nome
         * infoConexao = menu.menuCriarBanco(input, infoConexao); // chama o segundo
         * menu para criar banco,
         * // solicita o user e password do SGBD
         * conexao.setConfig(infoConexao); // atualiza as informações de conexão
         * database.setDbConnection(conexao); // atualiza as informações de conexão
         * try {
         * database.createDatabase(dbName); // tenta criar o banco de dados
         * database.executeQueries(queries.sqlQueries); // queries automatizadas de
         * inicialização do
         * // e-commerce
         * infoConexao.setUrl(infoConexao.getUrl() + "/" + dbName);
         * } catch (SQLException e) {
         * System.out.println("Houve um erro ao criar o banco de dados");
         * System.out.println(e);
         * e.printStackTrace();
         * }
         * } else {
         * // nada e volta para o começo
         * }
         * }
         * access++;
         * } while (systemStatus != false);
         */
    }

    private static void fazerLogin(Menu menu) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'fazerLogin'");
    }

    private static boolean cadastrarUsuario(Menu menu, UserService userControl) {
        // Obter os dados do usuário através do menu
        String[] dados = menu.menuCadastroUser();

        // Criar objeto de usuário com os dados obtidos
        User novoUsuario = new User();
        novoUsuario.setUsername(dados[0]);
        novoUsuario.setPassword(dados[1]);
        novoUsuario.setRole(dados[2]);

        // Registrar o usuário utilizando o serviço apropriado
        boolean isRegistered = userControl.registerUser(novoUsuario);

        // Exibir mensagem de acordo com o resultado do cadastro
        if (isRegistered) {
            System.out.println("\nCadastro realizado com sucesso!\n");
        } else {
            System.out.println("\nHouve uma falha na efetuação do cadastro. Tente novamente.\n");
        }

        return isRegistered;
    }

    private static boolean criarNovoDB(Menu menu, DatabaseHandler database) throws SQLException {
        boolean isCreated = false;
        String[] dados;

        do {
            // Obter os dados do banco através do menu
            dados = menu.menuCriarBanco();

            // Criar objeto de Banco com os dados obtidos
            DatabaseConfig novoBanco = new DatabaseConfig();
            novoBanco.setUser(dados[0]);
            novoBanco.setPassword(dados[1]);
            novoBanco.setDbName(dados[2]);

            // Definir a URL de conexão do banco de dados
            novoBanco.setUrl("jdbc:mysql://localhost/" + novoBanco.getDbName());

            // Tentar criar o banco de dados
            isCreated = database.createDatabase(novoBanco.getDbName());
            if (!isCreated) {
                System.out.println("Falha ao criar o banco de dados. Tente novamente.");
                int retryOption = menu.menuErroCriarBanco(); // Método para perguntar se o usuário quer tentar novamente
                if (retryOption != 1) { // Supondo que 1 significa tentar novamente
                    break;
                }
            }
        } while (!isCreated);
        System.out.println("Banco de dados criado com sucesso!");
        return isCreated;
    }

    private static void importarDBExistente(Menu menu) throws InterruptedException {
        menu.menuDbImportado();

    }

    private static String acessarDBExistente(Menu menu) {
        return menu.menuDbExistente();
    }
    // XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

    public static void gerenciarDb(Scanner input) {

    }

    public static void gerenciarFuncionarios(Scanner input) {

    }

    public static void verEstatisticas(Scanner input) {

    }

    public static void menuBusca(Scanner input) {

    }

    public static void menuEdicao(Scanner input) {

    }

    public static void menuApagar(Scanner input) {

    }

    public static void registarVenda(Scanner input) {

    }

    public static void consultarVendas(Scanner input) {

    }

    public static void cadastrarCliente(Scanner input) {

    }

    public static void cadastrarProduto(Scanner input) {

    }

}