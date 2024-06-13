package main.java.br.com.unicap.fitdb.aplicacao;

import java.util.Scanner;

import main.java.br.com.unicap.fitdb.config.DatabaseConfig;
import main.java.br.com.unicap.fitdb.model.User;
//IMPLEMENTAR VALIDAÇÃO DE INPUT!!!!!!!
// Primeiro menu
// Usuário diz o nome da db, o sistema tenta fazer uma conexão 
// se conseguir vai para o menu inicial
// se não conseguir vai para o menu de criar db
public class Menu {
        public String menuAcesso (Scanner input){
        String dbName = new String();
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║                                     ║");
        System.out.println("║     Gerenciamento de e-commerce     ║");
        System.out.println("║                                     ║");
        System.out.println("╠═════════════════════════════════════╣");
        System.out.println("║ Bem vindo!                          ║");
        System.out.println("║ Para iniciar o gerenciamento de seu ║");
        System.out.println("║ negócio, informe o nome de sua loja ║");
        System.out.println("║ seguindo o exemplo a seguir:        ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║  nome_do_banco_db                   ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("\n");
        dbName = input.nextLine();
        System.out.println("\n");
        return dbName;
    }

    public int menuDbNaoExiste (Scanner input){
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║ Banco de Dados informado não existe!║");
        System.out.println("╠═════════════════════════════════════╣");
        System.out.println("║                                     ║");
        System.out.println("║  1. Tentar Novamente                ║");
        System.out.println("║  2. Criar Banco de Dados            ║");
        System.out.println("║                                     ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║  Escolha uma opção:                 ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("\n");
        int option = input.nextInt();
        input.nextLine();
        return option;

    }

        public String menuAcesso2(Scanner input){
        String dbName = new String();
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║ Informe o nome do Banco de dados,   ║");
        System.out.println("║ no formato 'nome_do_banco_db':      ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("\n");
        dbName = input.nextLine();
        return dbName;
    }

    public DatabaseConfig menuCriarBanco(Scanner input, DatabaseConfig config){
        String user = new String();
        String password = new String();
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║ Informe o usuário do SGBD           ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("\n");
        user= input.nextLine();
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║ Informe a senha SGBD                ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("\n");
        password= input.nextLine();
        config.setUser(user);
        config.setPassword(password);
        return config;
    }

    public int menuInicial(String dbName, Scanner input) {
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║                                     ║");
        System.out.println("║             "+dbName+"             ");
        System.out.println("║                                     ║");
        System.out.println("╠═════════════════════════════════════╣");
        System.out.println("║                                     ║");
        System.out.println("║  1. Cadastrar                       ║");
        System.out.println("║  2. Fazer Login                     ║");
        System.out.println("║                                     ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║  Escolha uma opção:                 ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("\n");
        int option = input.nextInt();
        input.nextLine();
        System.out.println("\n");
        return option;
    }

    public User menuCadastro(Scanner input, User usuario) {
        String userName = new String();
        String userEmail = new String();
<<<<<<< Updated upstream
        String userRole = new String();
=======
        int userAge = 0;
        char userSex;
>>>>>>> Stashed changes

        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║ Informe o nome do usuário:          ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("\n");
        userName = input.nextLine();
        System.out.println("\n");
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║ Informe um e-mail para cadastrar:   ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("\n");
        userEmail = input.nextLine();
        System.out.println("\n");
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║ Informe o papel (admin, manager, employee):  ║");
        System.out.println("╚══════════════════════════════════════════════╝");
        System.out.println("\n");
        userRole = input.nextLine();
  
        usuario.setName(userName);
        usuario.setRole(userEmail);
        usuario.
        System.out.println("\n");
        return usuario;
        //IMPLEMENTAR VALIDAÇÃO DE ENTRADA 
    }
    
    
}
