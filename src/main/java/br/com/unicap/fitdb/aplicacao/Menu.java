package main.java.br.com.unicap.fitdb.aplicacao;

import java.util.Scanner;

import main.java.br.com.unicap.fitdb.config.DatabaseConfig;
import main.java.br.com.unicap.fitdb.db.DatabaseConnection;
import main.java.br.com.unicap.fitdb.db.DatabaseHandler;
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
        System.out.println("║  nome_do_banco_db                 ║");
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
        return option;

    }

        public String menuCriarBanco(Scanner input){
        String dbName = new String();
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║ Informe o nome do Banco de dados,   ║");
        System.out.println("║ no formato 'nome_do_banco_db':      ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("\n");
        dbName = input.nextLine();
        return dbName;
    }

    public int menuInicial(String dbName, Scanner input) {

        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║                                     ║");
        System.out.println("║             "+dbName+"              ║");
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
        System.out.println("\n");
        //IMPLEMENTAR VALIDAÇÃO DE ENTRADA
        return option;
    }
    
}
