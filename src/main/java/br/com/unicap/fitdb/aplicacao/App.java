package main.java.br.com.unicap.fitdb.aplicacao;
import java.sql.SQLException;
import java.util.Scanner;

import main.java.br.com.unicap.fitdb.config.DatabaseConfig;
import main.java.br.com.unicap.fitdb.dao.UserDAO;
import main.java.br.com.unicap.fitdb.db.DatabaseConnection;
import main.java.br.com.unicap.fitdb.db.DatabaseHandler;
import main.java.br.com.unicap.fitdb.model.User;
import main.java.br.com.unicap.fitdb.service.UserService;

public class App {
    public static void main(String[] args) {
        String dbName = new String();
        int option = -1;
        int access = 0;
        boolean systemStatus = true;
        boolean dbExistance = false;
        Scanner input = new Scanner(System.in);
        Menu interfaci = new Menu(); //interfaci pq com e é palavra reservada
        // DatabaseConfig é um objeto que encapsula as informações de configuração necessárias para se conectar ao SGBD. 
        DatabaseConfig infoConexao = new DatabaseConfig();      
        // DatabaseConnection é um objeto que irá utilizar as informações do objeto DatabaseConfig numa instância do DriverManger
        // O DriverManager é responsável por tentar uma conexão com o SGBD mysql
        DatabaseConnection conexao = new DatabaseConnection(infoConexao);
        // DataBaseHandler usa a conexão estabelecida pelo DatabaseConnection,
        DatabaseHandler database = new DatabaseHandler(conexao);
        UserDAO userOperations = new UserDAO(conexao);
        //pergunta o nome da db para o usuário
        dbName = interfaci.menuAcesso(input);
        Query queries = new Query();
        UserService userControl = new UserService(userOperations);

        System.out.println(infoConexao.getUrl());
        System.out.println(infoConexao.getUser());
        System.out.println(infoConexao.getPassword());

        //IMPLEMENTAR SAIDA DO PROGRAMA BASEADA EM INPUT!!!!!!


        dbExistance = database.databaseExists (dbName); // checa existencia do banco de dados com base no nome informado
        if(dbExistance == true){
            infoConexao.setUrl(infoConexao.getUrl()+"/"+dbName);
        }
        do{
            userOperations.setDatabaseConnection(conexao);// atualiza para garantir que está na conexão certa
            if(access > 0){
                dbName = interfaci.menuAcesso2(input);
            }
            while(dbExistance == true){                        // se existir
                System.out.println(infoConexao.getUrl());
                conexao.setConfig(infoConexao);                                // atualiza as informações de conexão
                database.setDbConnection(conexao);                             // atualiza as informações de conexão

                option = interfaci.menuInicial(dbName, input); // exibe o menu inicial
                if(option == 1){                            // cadastrar
                    User usuarioCadastro = new User();
                    usuarioCadastro = interfaci.menuCadastro(input, usuarioCadastro);
                    boolean isRegistered = userControl.registerUser(usuarioCadastro);
                    if(isRegistered == true){   // sucesso no cadastro
                        System.out.println("\nCadastro realizado com sucesso!\n");
                        // exibe o menu inicial
                    }else{                      // falha no cadastro
                        System.out.println("\nHouve alguma falha na efetuação do cadastro, tente novamente!\n");
                    }
                }else if( option == 2){                     // login
                    User usuarioLogin = new User();
                    usuarioLogin = interfaci.menuLogin(input, usuarioLogin);
                    boolean isLoggedIn = userControl.loginUser(usuarioLogin);
                    if(isLoggedIn == true){
                        System.out.println("\nLogin efetuado com sucesso!");
                        String userRole = new String();
                        String choice = new String();
                        userRole = userControl.getUserRole(usuarioLogin.getUsername());
                        while(isLoggedIn == true){
                            if(userRole == "admin"){
                                choice = interfaci.menuAdministrador(input);
                                switch (choice) {
                                    case "1":
                                        gerenciarDb(input);
                                        break;
                                    case "2":
                                        gerenciarFuncionarios(input);
                                        break;
                                    case "3":
                                        verEstatisticas(input);
                                        break;
                                    default: //x ou X
                                        isLoggedIn = false;
                                        break;
                                }
                            }else if (userRole == "manager"){
                                choice = interfaci.menuGerente(input);
                                switch (choice) {
                                    case "1":
                                        menuBusca(input);
                                        break;
                                    case "2":
                                        menuEdicao(input);
                                        break;
                                    case "3":
                                        menuApagar(input);
                                        break;
                                    default: //x ou X
                                        isLoggedIn = false;
                                        break;
                                }
                            }else{ // userRole == employee
                                choice = interfaci.menuFuncionario(input);
                                switch (choice) {
                                    case "1":
                                        menuBusca(input);
                                        break;
                                    case "2":
                                        menuEdicao(input);
                                        break;
                                    case "3":
                                        menuApagar(input);
                                        break;
                                    default: //x ou X
                                        isLoggedIn = false;
                                        break;
                                }
                            }
                        }
                    }else{
                        System.out.println("\nHouve um erro na efetuação do login!\n");
                        //volta para o menu inicial
                    }
                }else{  // qualquer outro input, indica exit

                }
            }if(dbExistance != true){                                          // se o banco informado não existir, 
                option = interfaci.menuDbNaoExiste(input);  // fornece a opção de tentar novamente inserir o nome ou criar o banco
                if(option == 2){                            // opção 2 criar banco
                    //so pessoas com a informação sensivel podem criar
                    infoConexao.setUser("");
                    infoConexao.setPassword("");

                    dbName = interfaci.menuAcesso2(input); // chama o primeiro menu para criar banco, pede para definir o nome
                    infoConexao = interfaci.menuCriarBanco(input, infoConexao);    // chama o segundo menu para criar banco, solicita o user e password do SGBD
                    conexao.setConfig(infoConexao);                                // atualiza as informações de conexão
                    database.setDbConnection(conexao);                             // atualiza as informações de conexão
                    try {
                        database.createDatabase(dbName);                           // tenta criar o banco de dados
                        database.executeQueries(queries.sqlQueries); // queries automatizadas de inicialização do e-commerce
                    }catch (SQLException e) {
                        System.out.println("Houve um erro ao criar o banco de dados");
                        System.out.println(e);
                        e.printStackTrace();
                    }
                }else{
                    // nada e volta para o começo
                }
            }
            access++;
        }while(systemStatus != false);

    }

    public static void gerenciarDb(Scanner input){

    }
    public static void gerenciarFuncionarios(Scanner input){

    }
    public static void verEstatisticas(Scanner input){

    }
    public static void menuBusca(Scanner input){

    }
    public static void menuEdicao(Scanner input){

    }
    public static void menuApagar(Scanner input){

    }
    public static void registarVenda(Scanner input){

    }
    public static void consultarVendas(Scanner input){

    }
    public static void cadastrarCliente(Scanner input){

    }
    public static void cadastrarProduto(Scanner input){

    }
    
}
