package main.java.br.com.unicap.fitdb.aplicacao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import main.java.br.com.unicap.fitdb.config.DatabaseConfig;
import main.java.br.com.unicap.fitdb.dao.UserDAO;
import main.java.br.com.unicap.fitdb.db.DatabaseConnection;
import main.java.br.com.unicap.fitdb.db.DatabaseHandler;
import main.java.br.com.unicap.fitdb.model.User;
import main.java.br.com.unicap.fitdb.service.Session;
import main.java.br.com.unicap.fitdb.service.UserService;
import main.java.br.com.unicap.fitdb.aplicacao.Menu;

public class App {
    public static void main(String[] args) throws InterruptedException, SQLException, IOException {
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
                    // Configurar credenciais e URL apenas para a importação
                    infoConexao.setUser("root"); // Nome do usuário
                    infoConexao.setPassword(""); // Senha do usuário
                    infoConexao.setUrl("jdbc:mysql://localhost:3306/fitdb_importado");
                    
                    dbName = "FitDB_Importado"; // Nome do banco de dados que será criado
                    importarDBExistente(menu);
                    boolean dbCriado = database.createDatabaseIfNotExists(dbName);
                    if (dbCriado) {
                        String scriptPath = "src/DB/Script_FitDB.sql";
                        boolean dbImportado = database.executeSqlScript(scriptPath, dbName);
                        if (dbImportado) {
                            dbExiste = true;
                            System.out.println("Banco de dados importado com sucesso!");
                        } else {
                            System.out.println("Falha ao importar o banco de dados.");
                        }
                    } else {
                        System.out.println("Banco de dados já existe.");
                        dbExiste = true;
                    }
                    break;
                case 3:
                    if (criarNovoDB(menu, database)) {
                        // dbName = database.et(); // Obter o nome do banco criado do menu, se
                        // necessário
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
                            boolean successCadastro = cadastrarUsuario(menu, userControl);
                            while (!successCadastro) {
                                int op = menu.menuErroCadastrarUsuario();
                                if (op == 1) {
                                    successCadastro = cadastrarUsuario(menu, userControl);
                                } else if (op == 0) {
                                    break;
                                } else {
                                    System.out.println("Informe uma opção válida.");
                                }
                            }
                            break;
                        case 2:
                            if (fazerLogin(menu, userControl, input)) {
                                operacoesUsuarioLogado(menu, userControl, input);
                            }
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
                        boolean isCreated = criarNovoDB(menu, database);
                        dbExiste = true;
                        break;
                    default:
                        systemStatus = false;
                        break;
                }
            }
        }

    }

    private static boolean fazerLogin(Menu menu, UserService userControl, Scanner input) {
        boolean isLoggedIn = false;
        // Obter os dados do usuário através do menu
        String[] dados = menu.menuLogin();

        // Criar objeto de usuário com os dados obtidos
        User usuarioLogin = new User(dados[0], dados[1]);

        // Registrar o usuário utilizando o serviço apropriado
        isLoggedIn = userControl.loginUser(usuarioLogin);
        if (isLoggedIn) {
            System.out.println("\nLogin efetuado com sucesso!");
        } else {
            System.out.println("\nHouve um erro na efetuação do login!\n");
        }
        return isLoggedIn;
    }

    private static void operacoesUsuarioLogado(Menu menu, UserService userControl, Scanner input) {
        boolean isLoggedIn = true;
        User currentUser = Session.getCurrentUser();
        String userRole = userControl.getUserRole(currentUser.getUsername());

        while (isLoggedIn) {
            int op;
            if (userRole.equals("admin")) {
                op = menu.menuAdministrador();
                switch (op) {
                    case 1:
                        menu.menuGerenciarBancoDeDados();
                        break;
                    case 2:
                        menu.menuGerenciarFuncionarios();
                        break;
                    case 3:
                        menu.menuEstatisticasVendas();
                        break;
                    default:
                        isLoggedIn = false;
                        break;
                }
            } else if (userRole.equals("manager")) {
                op = menu.menuGerente();
                switch (op) {
                    case 1:
                        menu.menuBuscar();
                        break;
                    case 2:
                        menu.menuEditar();
                        break;
                    case 3:
                        menu.menuApagar();
                        break;
                    default:
                        isLoggedIn = false;
                        break;
                }
            } else { // userRole == employee
                op = menu.menuFuncionario();
                switch (op) {
                    case 1:
                        menu.menuRegistrarVenda();
                        break;
                    case 2:
                        menu.menuConsultarVenda();
                        break;
                    case 3:
                        menu.menuCadastrarCliente();
                        break;
                    case 4:
                        menu.menuCadastrarProduto();
                        break;
                    default:
                        isLoggedIn = false;
                        break;
                }
            }
        }
    }

    private static boolean cadastrarUsuario(Menu menu, UserService userControl) {
        // Obter os dados do usuário através do menu
        String[] dados = menu.menuCadastroUser();

        // Criar objeto de usuário com os dados obtidos
        User usuarioCadastro = new User(dados[0], dados[1], dados[2]);

        // Registrar o usuário utilizando o serviço apropriado
        boolean isRegistered = userControl.registerUser(usuarioCadastro);

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
}