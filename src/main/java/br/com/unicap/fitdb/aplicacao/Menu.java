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
        System.out.println("║  nome_do_banco                      ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("use loja_fit");
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
        System.out.println("║  Escolha uma opção(numero):         ║");
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
        System.out.println("║ no formato 'nome_do_banco':         ║");
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
        System.out.println("║  Escolha uma opção(numero):         ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("\n");
        int option = input.nextInt();
        input.nextLine();
        System.out.println("\n");
        return option;
    }

    public User menuCadastro(Scanner input, User usuario) {
        String userName = new String();
        String userPassword = new String();
        String userRole = new String();

        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║ Informe o nome do usuário:          ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("\n");
        userName = input.nextLine();
        System.out.println("\n");
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║ Informe o papel (admin, manager, employee):  ║");
        System.out.println("╚══════════════════════════════════════════════╝");
        System.out.println("\n");
        userRole = input.nextLine();
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║ Informe a senha do usuário:         ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("\n");
        userPassword = input.nextLine();
  
        usuario.setUsername(userName);
        usuario.setRole(userRole);
        usuario.setPassword(userPassword);
        return usuario;
        //IMPLEMENTAR VALIDAÇÃO DE ENTRADA 
    }
    
    public User menuLogin(Scanner input, User usuario){
        String userName = new String();
        String userPassword = new String();

        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║ Informe o nome do usuário:          ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("\n");
        userName = input.nextLine();
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║ Informe a senha do usuário:         ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("\n");
        userPassword = input.nextLine();
        usuario.setUsername(userName);
        usuario.setPassword(userPassword);
        return usuario;
        //IMPLEMENTAR VALIDAÇÃO DE ENTRADA 
    }
    public String menuAdministrador(Scanner input){
        String choice = new String();
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║         Menu Administrador          ║");
        System.out.println("╠═════════════════════════════════════╣");
        System.out.println("║                                     ║");
        System.out.println("║  1. Gerenciar banco de dados        ║");
        System.out.println("║  2. Gerenciar funcionários          ║");
        System.out.println("║  3. Estatísticas de vendas          ║");
        System.out.println("║  X. Sair                            ║");
        System.out.println("║                                     ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║  Escolha uma opção(numero):         ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("\n");
        choice = input.nextLine();
        return choice;
    }

    public String menuGerente(Scanner input){
        String choice = new String();
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║             Menu Gerente            ║");
        System.out.println("╠═════════════════════════════════════╣");
        System.out.println("║                                     ║");
        System.out.println("║  1. Buscar                          ║");
        System.out.println("║  2. Editar                          ║");
        System.out.println("║  3. Apagar                          ║");
        System.out.println("║  X. Sair                            ║");
        System.out.println("║                                     ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║  Escolha uma opção(numero):         ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("\n");
        choice = input.nextLine();
        return choice;

    }
    public String menuFuncionario(Scanner input){
        String choice = new String();
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║           Menu Funcionário          ║");
        System.out.println("╠═════════════════════════════════════╣");
        System.out.println("║                                     ║");
        System.out.println("║  1. Registrar Venda                 ║");
        System.out.println("║  2. Consultar Vendas                ║");
        System.out.println("║  3. Cadastrar Cliente               ║");
        System.out.println("║  4. Cadastrar Produto               ║");
        System.out.println("║  X. Sair                            ║");
        System.out.println("║                                     ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║  Escolha uma opção:                 ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("\n");
        choice = input.nextLine();
        return choice;

    }
    public void estatisticas (){
        System.out.println("╔═══════════════════════════════════════════════════╗");
        System.out.println("║                                                   ║");
        System.out.println("║                Estatísticas de Vendas             ║");
        System.out.println("║                                                   ║");
        System.out.println("╠═══════════════════════════════════════════════════╣");
        System.out.println("║ 1. Produto mais vendido                           ║");
        System.out.println("║ 2. Vendedor Associado ao produto mais vendido     ║");
        System.out.println("║ 3. Valor ganho com o produto mais vendido         ║");
        System.out.println("║ 4. Meses de mais e de menos vendas                ║");
        System.out.println("║    do produto mais vendido                        ║");
        System.out.println("║ 5. Valor ganho com o produto mais vendido         ║");
        System.out.println("║ 6. Produto menos vendido                          ║");
        System.out.println("║ 7. Valor ganho com o produto menos vendido        ║");
        System.out.println("║ 8. Meses de mais e de menos vendas                ║");
        System.out.println("║    do produto menos vendido                       ║");
        System.out.println("║ 9. Voltar                                         ║");
        System.out.println("╚═══════════════════════════════════════════════════╝");

    }

    public void buscas(){
        System.out.println("╔═══════════════════════════════════════════════════╗");
        System.out.println("║                                                   ║");
        System.out.println("║                      Buscas                       ║");
        System.out.println("║                                                   ║");
        System.out.println("╠═══════════════════════════════════════════════════╣");
        System.out.println("║ 1. Buscar cliente                                 ║");
        System.out.println("║ 2. Buscar venda                                   ║");
        System.out.println("║ 3. Buscar produto                                 ║");
        System.out.println("║ 4. Buscar Funcionário                             ║");
        System.out.println("║ X. Voltar                                         ║");
        System.out.println("╚═══════════════════════════════════════════════════╝");

    }

    public void apagarOpcoes(){
        System.out.println("╔═══════════════════════════════════════════════════╗");
        System.out.println("║                                                   ║");
        System.out.println("║                      Apagar                       ║");
        System.out.println("║                                                   ║");
        System.out.println("╠═══════════════════════════════════════════════════╣");
        System.out.println("║ 1. Apagar cliente                                 ║");
        System.out.println("║ 2. Apagar venda                                   ║");
        System.out.println("║ 3. Apagar produto                                 ║");
        System.out.println("║ 4. Apagar Funcionário                             ║");
        System.out.println("║ X. Voltar                                         ║");
        System.out.println("╚═══════════════════════════════════════════════════╝");

    }
    public void edicao(){
        System.out.println("╔═══════════════════════════════════════════════════╗");
        System.out.println("║                                                   ║");
        System.out.println("║                      Editar                       ║");
        System.out.println("║                                                   ║");
        System.out.println("╠═══════════════════════════════════════════════════╣");
        System.out.println("║ 1. Editar cliente                                 ║");
        System.out.println("║ 2. Editar venda                                   ║");
        System.out.println("║ 3. Editar produto                                 ║");
        System.out.println("║ 4. Editar Funcionário                             ║");
        System.out.println("║ X. Voltar                                         ║");
        System.out.println("╚═══════════════════════════════════════════════════╝");

    }



}
