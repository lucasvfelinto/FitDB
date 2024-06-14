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
    Scanner input = new Scanner(System.in);
        public int menuAcessoInicial (){
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║                                     ║");
        System.out.println("║     Gerenciamento de e-commerce     ║");
        System.out.println("║                                     ║");
        System.out.println("╠═════════════════════════════════════╣");
        System.out.println("║ Bem vindo!                          ║");
        System.out.println("║ Para iniciar o gerenciamento de seu ║");
        System.out.println("║ negócio, selecione uma opção a      ║");
        System.out.println("║ seguir:                             ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║  1. Entrar num DB existente         ║");
        System.out.println("║  2. Importar o DB existente         ║");
        System.out.println("║  3. Criar um DB                     ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("use loja_fit");
        System.out.println("\n");
        int op = input.nextInt();
        System.out.println("\n");
        return op;
    }
    public String menuDbExistente (){
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║     Gerenciamento de e-commerce     ║");
        System.out.println("╠═════════════════════════════════════╣");
        System.out.println("║                                     ║");
        System.out.println("║ Para iniciar o gerenciamento de seu ║");
        System.out.println("║ negócio, informe o nome de seu DB   ║");
        System.out.println("║ exatamente como foi resgitrada, como║");
        System.out.println("║ no exemplo a seguir:                ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║  nome_do_seu_db                     ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("\n");
        String dbName = input.nextLine();
        return dbName;
    }

    public void menuDbImportado () throws InterruptedException{
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║     Gerenciamento de e-commerce     ║");
        System.out.println("╠═════════════════════════════════════╣");
        System.out.println("║                                     ║");
        System.out.println("║ Importando DB FitDB, a partir do    ║");
        System.out.println("║ script criado pelo grupo, localizado║");
        System.out.println("║ exatamente no caminho:              ║");
        System.out.println("║\'src\\DB\\Script_FitDB.sql\'            ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("╔═════════════════════════════════════╗");
        System.out.print("║  FitDb");
        Thread.sleep(500); // Aguarda 500 milissegundos (0.5 segundo)        
        for (int i = 0; i < 20; i++) {
            System.out.print("."); // Imprime pontos para simular o carregamento
            Thread.sleep(100); // Aguarda 100 milissegundos (0.1 segundo) entre cada ponto
        }        
        System.out.println("          ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("\n");
    }

    public int menuAcessoDb(String dbName) {

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
        System.out.println("║  Escolha uma opção(numero):         ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("\n");
        int option = input.nextInt();
        System.out.println("\n");
        //IMPLEMENTAR VALIDAÇÃO DE ENTRADA
        return option;
    }
    //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX




    public int menuDbNaoExiste() {
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║                                     ║");
        System.out.println("║     Banco de Dados não existe!      ║");
        System.out.println("║                                     ║");
        System.out.println("╠═════════════════════════════════════╣");
        System.out.println("║  1. Tentar novamente                ║");
        System.out.println("║  2. Criar Banco de Dados            ║");
        System.out.println("║  X. Voltar                          ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("\n");
        return input.nextInt();
    }

    public String menuCriarBanco() {
        input.nextLine(); // Consumir nova linha
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║                                     ║");
        System.out.println("║          Criar Banco de Dados       ║");
        System.out.println("║                                     ║");
        System.out.println("╠═════════════════════════════════════╣");
        System.out.println("║ - Informe o usuário                 ║");
        String user = input.nextLine();
        System.out.println("║ - Informe a senha                   ║");
        String password = input.nextLine();
        System.out.println("║ - Informe o nome do banco de dados  ║");
        String dbName = input.nextLine();
        System.out.println("║  X. Voltar                          ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("\n");
        return dbName;
    }


    public int menuErroCriarBanco() {
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║                                     ║");
        System.out.println("║          Erro ao Criar Banco        ║");
        System.out.println("║                                     ║");
        System.out.println("╠═════════════════════════════════════╣");
        System.out.println("║  1. Tentar Novamente                ║");
        System.out.println("║  X. Voltar                          ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("\n");
        return input.nextInt();
    }

    public int menuInicial() {
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║                                     ║");
        System.out.println("║        Gerenciamento de Acesso      ║");
        System.out.println("║                                     ║");
        System.out.println("╠═════════════════════════════════════╣");
        System.out.println("║  1. Cadastrar                       ║");
        System.out.println("║  2. Login                           ║");
        System.out.println("║  X. Voltar                          ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("\n");
        return input.nextInt();
    }

    public String menuCadastro() {
        input.nextLine(); // Consumir nova linha
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║                                     ║");
        System.out.println("║          Cadastro de Usuário        ║");
        System.out.println("║                                     ║");
        System.out.println("╠═════════════════════════════════════╣");
        System.out.println("║ - Informe o nome                    ║");
        String nome = input.nextLine();
        System.out.println("║ - Informe a senha                   ║");
        String senha = input.nextLine();
        System.out.println("║ - Selecione o cargo:                ║");
        System.out.println("║   employee, manager, admin          ║");
        String cargo = input.nextLine();
        System.out.println("║  X. Voltar                          ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("\n");
        return nome + ";" + senha + ";" + cargo;
    }

    public String menuLogin() {
        input.nextLine(); // Consumir nova linha
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║                                     ║");
        System.out.println("║              Login                  ║");
        System.out.println("║                                     ║");
        System.out.println("╠═════════════════════════════════════╣");
        System.out.println("║ - Informe o usuario                 ║");
        String usuario = input.nextLine();
        System.out.println("║ - Informe a senha                   ║");
        String senha = input.nextLine();
        System.out.println("║  X. Voltar                          ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("\n");
        return usuario + ";" + senha;
    }

    public int menuGerente() {
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║                                     ║");
        System.out.println("║              Gerente                ║");
        System.out.println("║                                     ║");
        System.out.println("╠═════════════════════════════════════╣");
        System.out.println("║  1. Buscar                          ║");
        System.out.println("║  2. Editar                          ║");
        System.out.println("║  3. Apagar                          ║");
        System.out.println("║  X. Sair                            ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("\n");
        return input.nextInt();
    }

    public int menuFuncionario() {
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║                                     ║");
        System.out.println("║             Funcionario             ║");
        System.out.println("║                                     ║");
        System.out.println("╠═════════════════════════════════════╣");
        System.out.println("║  1. Registrar Venda                 ║");
        System.out.println("║  2. Consultar Vendas                ║");
        System.out.println("║  3. Cadastrar Cliente               ║");
        System.out.println("║  4. Consultar Cliente               ║");
        System.out.println("║  5. Cadastrar Produto               ║");
        System.out.println("║  6. Consultar Produto               ║");
        System.out.println("║  X. Sair                            ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("\n");
        return input.nextInt();
    }

    public int menuAdministrador() {
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║                                     ║");
        System.out.println("║           Administrador             ║");
        System.out.println("║                                     ║");
        System.out.println("╠═════════════════════════════════════╣");
        System.out.println("║  1. Gerenciar Banco de Dados        ║");
        System.out.println("║  2. Gerenciar Funcionarios          ║");
        System.out.println("║  3. Estatísticas de Vendas          ║");
        System.out.println("║  X. Sair                            ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("\n");
        return input.nextInt();
    }

    public int menuGerenciarFuncionarios() {
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║                                     ║");
        System.out.println("║       Gerenciar Funcionários        ║");
        System.out.println("║                                     ║");
        System.out.println("╠═════════════════════════════════════╣");
        System.out.println("║  1. Reajuste Salarial               ║");
        System.out.println("║  X. Voltar                          ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("\n");
        return input.nextInt();
    }

    public int menuEstatisticasVendas() {
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║                                     ║");
        System.out.println("║       Estatísticas de Vendas        ║");
        System.out.println("║                                     ║");
        System.out.println("╠═════════════════════════════════════╣");
        System.out.println("║  1. Produto mais vendido            ║");
        System.out.println("║  2. Vendedor Associado ao Produto   ║");
        System.out.println("║  3. Valor ganho com o Produto       ║");
        System.out.println("║  4. Meses de Mais e Menos Vendas    ║");
        System.out.println("║  5. Produto menos vendido           ║");
        System.out.println("║  6. Valor ganho com Produto Menos   ║");
        System.out.println("║  7. Todas as opções acima           ║");
        System.out.println("║  X. Voltar                          ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("\n");
        return input.nextInt();
    }

    public int menuGerenciarBancoDeDados() {
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║                                     ║");
        System.out.println("║     Gerenciar Banco de Dados        ║");
        System.out.println("║                                     ║");
        System.out.println("╠═════════════════════════════════════╣");
        System.out.println("║  1. Deletar Banco de Dados          ║");
        System.out.println("║  2. Cadastrar Produto               ║");
        System.out.println("║  3. Cadastrar Cliente               ║");
        System.out.println("║  4. Visualizar Dados                ║");
        System.out.println("║  X. Voltar                          ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("\n");
        return input.nextInt();
    }

    public String menuCadastrarCliente() {
        input.nextLine(); // Consumir nova linha
        String nome, idade, nascimento, sexo;
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║                                     ║");
        System.out.println("║          Cadastrar Cliente          ║");
        System.out.println("║                                     ║");
        System.out.println("╠═════════════════════════════════════╣");
        System.out.println("║ - Informe o nome do Cliente         ║");
        nome = input.nextLine();
        System.out.println("║ - Informe a Idade                   ║");
        idade = input.nextLine();
        System.out.println("║ - Informe a data de nascimento (aaaa-mm-dd)  ║");
        nascimento = input.nextLine();
        System.out.println("║ - Informe o sexo (M, F, O)          ║");
        sexo = input.nextLine();
        System.out.println("║  X. Voltar                          ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("\n");
        return nome + ";" + idade + ";" + nascimento + ";" + sexo;
    }

    public int menuErroCadastrarCliente() {
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║                                     ║");
        System.out.println("║          Erro ao Cadastrar          ║");
        System.out.println("║              Cliente                ║");
        System.out.println("║                                     ║");
        System.out.println("╠═════════════════════════════════════╣");
        System.out.println("║  1. Tentar novamente                ║");
        System.out.println("║  X. Voltar                          ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("\n");
        return input.nextInt();
    }

    public String menuCadastrarProduto(){
        String nome, valor, quantidade, descricao;
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║                                     ║");
        System.out.println("║          Cadastrar Produto          ║");
        System.out.println("║                                     ║");
        System.out.println("╠═════════════════════════════════════╣");
        System.out.println("║ - Informe o nome do Produto         ║");
        nome = input.nextLine();
        System.out.println("║ - Informe o Valor (ex. 200.96)      ║");
        valor = input.nextLine();
        System.out.println("║ - Informe a quantidade              ║");
        quantidade = input.nextLine();
        System.out.println("║ - Informe a descrição               ║");
        descricao = input.nextLine();
        System.out.println("║  X. Voltar                          ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("\n");
        return nome + ";" + valor + ";" + quantidade + ";" + descricao;
    }

    public String menuRegistrarVenda() {
        input.nextLine(); // Consumir nova linha
        String idProduto, quantidade, idCliente;
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║                                     ║");
        System.out.println("║          Registrar Venda            ║");
        System.out.println("║                                     ║");
        System.out.println("╠═════════════════════════════════════╣");
        System.out.println("║ - Informe o ID do produto           ║");
        idProduto = input.nextLine();
        System.out.println("║ - Informe a quantidade do produto   ║");
        quantidade = input.nextLine();
        System.out.println("║ - Informe o ID do Cliente           ║");
        idCliente = input.nextLine();
        System.out.println("║  X. Voltar                          ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("\n");
        return idProduto + ";" + quantidade + ";" + idCliente;
    }

    public int menuErroRegistrarVenda() {
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║                                     ║");
        System.out.println("║          Erro ao Registrar          ║");
        System.out.println("║              Venda                  ║");
        System.out.println("║                                     ║");
        System.out.println("╠═════════════════════════════════════╣");
        System.out.println("║  1. Tentar novamente                ║");
        System.out.println("║  X. Voltar                          ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("\n");
        return input.nextInt();
    }

    public int menuConsultarVenda() {
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║                                     ║");
        System.out.println("║          Consultar Venda            ║");
        System.out.println("║                                     ║");
        System.out.println("╠═════════════════════════════════════╣");
        System.out.println("║  1. Pesquise pelo Funcionario       ║");
        System.out.println("║  2. Pesquise pelo Cliente           ║");
        System.out.println("║  3. Pesquise pelo Produto           ║");
        System.out.println("║  4. Pesquise pela Quantidade        ║");
        System.out.println("║  X. Voltar                          ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("\n");
        return input.nextInt();
    }

    public int menuConsultarCliente() {
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║                                     ║");
        System.out.println("║          Consultar Cliente          ║");
        System.out.println("║                                     ║");
        System.out.println("╠═════════════════════════════════════╣");
        System.out.println("║  1. Pesquise pelo Nome              ║");
        System.out.println("║  2. Pesquise pelo Sexo              ║");
        System.out.println("║  3. Pesquise pela Idade             ║");
        System.out.println("║  4. Pesquise pela Data de Nascimento║");
        System.out.println("║  X. Voltar                          ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("\n");
        return input.nextInt();
    }

    public int menuConsultarProduto() {
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║                                     ║");
        System.out.println("║          Consultar Produto          ║");
        System.out.println("║                                     ║");
        System.out.println("╠═════════════════════════════════════╣");
        System.out.println("║  1. Pesquise pelo Nome              ║");
        System.out.println("║  2. Pesquise pelo Valor             ║");
        System.out.println("║  3. Pesquise pela Quantidade        ║");
        System.out.println("║  X. Voltar                          ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("\n");
        return input.nextInt();
    }

    public int menuConsultarFuncionario() {
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║                                     ║");
        System.out.println("║        Consultar Funcionário        ║");
        System.out.println("║                                     ║");
        System.out.println("╠═════════════════════════════════════╣");
        System.out.println("║  1. Pesquise pelo Nome              ║");
        System.out.println("║  2. Pesquise pelo Cargo             ║");
        System.out.println("║  3. Pesquise pelo Sexo              ║");
        System.out.println("║  4. Pesquise pela Idade             ║");
        System.out.println("║  5. Pesquise pela Data de Nascimento║");
        System.out.println("║  X. Voltar                          ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("\n");
        return input.nextInt();
    }

    public int menuBuscar() {
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║                                     ║");
        System.out.println("║              Buscar                 ║");
        System.out.println("║                                     ║");
        System.out.println("╠═════════════════════════════════════╣");
        System.out.println("║  1. Buscar Cliente                  ║");
        System.out.println("║  2. Buscar Venda                    ║");
        System.out.println("║  3. Buscar Produto                  ║");
        System.out.println("║  4. Buscar Funcionário              ║");
        System.out.println("║  X. Voltar                          ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("\n");
        return input.nextInt();
    }

    public int menuEditar() {
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║                                     ║");
        System.out.println("║              Editar                 ║");
        System.out.println("║                                     ║");
        System.out.println("╠═════════════════════════════════════╣");
        System.out.println("║  1. Editar Cliente                  ║");
        System.out.println("║  2. Editar Venda                    ║");
        System.out.println("║  3. Editar Produto                  ║");
        System.out.println("║  4. Editar Funcionário              ║");
        System.out.println("║  X. Voltar                          ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("\n");
        return input.nextInt();
    }

    public int menuApagar() {
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║                                     ║");
        System.out.println("║              Apagar                 ║");
        System.out.println("║                                     ║");
        System.out.println("╠═════════════════════════════════════╣");
        System.out.println("║  1. Apagar Cliente                  ║");
        System.out.println("║  2. Apagar Venda                    ║");
        System.out.println("║  3. Apagar Produto                  ║");
        System.out.println("║  4. Apagar Funcionário              ║");
        System.out.println("║  X. Voltar                          ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("\n");
        return input.nextInt();
    }

    public String menuEditarCliente() {
        input.nextLine(); // Consumir nova linha
        String id, nome, sexo, idade, nascimento;
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║                                     ║");
        System.out.println("║          Editar Cliente             ║");
        System.out.println("║                                     ║");
        System.out.println("╠═════════════════════════════════════╣");
        System.out.println("║ - Informe o ID do Cliente           ║");
        id = input.nextLine();
        System.out.println("║  1. Editar o Nome                   ║");
        nome = input.nextLine();
        System.out.println("║  2. Editar o Sexo                   ║");
        sexo = input.nextLine();
        System.out.println("║  3. Editar a Idade                  ║");
        idade = input.nextLine();
        System.out.println("║  4. Editar a Data de Nascimento     ║");
        nascimento = input.nextLine();
        System.out.println("║  X. Voltar                          ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("\n");
        return id + ";" + nome + ";" + sexo + ";" + idade + ";" + nascimento;
    }

    public String menuEditarVenda() {
        input.nextLine(); // Consumir nova linha
        String id, funcionario, cliente, produto, quantidade;
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║                                     ║");
        System.out.println("║          Editar Venda               ║");
        System.out.println("║                                     ║");
        System.out.println("╠═════════════════════════════════════╣");
        System.out.println("║ - Informe o ID da Venda             ║");
        id = input.nextLine();
        System.out.println("║  1. Editar o Funcionario            ║");
        funcionario = input.nextLine();
        System.out.println("║  2. Editar o Cliente                ║");
        cliente = input.nextLine();
        System.out.println("║  3. Editar o Produto                ║");
        produto = input.nextLine();
        System.out.println("║  4. Editar a Quantidade             ║");
        quantidade = input.nextLine();
        System.out.println("║  X. Voltar                          ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("\n");
        return id + ";" + funcionario + ";" + cliente + ";" + produto + ";" + quantidade;
    }

    public String menuEditarProduto() {
        input.nextLine(); // Consumir nova linha
        String id, nome, valor, quantidade;
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║                                     ║");
        System.out.println("║          Editar Produto             ║");
        System.out.println("║                                     ║");
        System.out.println("╠═════════════════════════════════════╣");
        System.out.println("║ - Informe o ID do Produto           ║");
        id = input.nextLine();
        System.out.println("║  1. Editar o Nome                   ║");
        nome = input.nextLine();
        System.out.println("║  2. Editar o Valor                  ║");
        valor = input.nextLine();
        System.out.println("║  3. Editar a Quantidade             ║");
        quantidade = input.nextLine();
        System.out.println("║  X. Voltar                          ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("\n");
        return id + ";" + nome + ";" + valor + ";" + quantidade;
    }

    public String menuEditarFuncionario() {
        input.nextLine(); // Consumir nova linha
        String id, nome, cargo, sexo, idade, nascimento;
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║                                     ║");
        System.out.println("║        Editar Funcionário           ║");
        System.out.println("║                                     ║");
        System.out.println("╠═════════════════════════════════════╣");
        System.out.println("║ - Informe o ID do Funcionário       ║");
        id = input.nextLine();
        System.out.println("║  1. Editar o Nome                   ║");
        nome = input.nextLine();
        System.out.println("║  2. Editar o Cargo                  ║");
        cargo = input.nextLine();
        System.out.println("║  3. Editar o Sexo                   ║");
        sexo = input.nextLine();
        System.out.println("║  4. Editar a Idade                  ║");
        idade = input.nextLine();
        System.out.println("║  5. Editar a Data de Nascimento     ║");
        nascimento = input.nextLine();
        System.out.println("║  X. Voltar                          ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("\n");
        return id + ";" + nome + ";" + cargo + ";" + sexo + ";" + idade + ";" + nascimento;
    }

    public String menuApagarCliente() {
        input.nextLine(); // Consumir nova linha
        String id;
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║                                     ║");
        System.out.println("║          Apagar Cliente             ║");
        System.out.println("║                                     ║");
        System.out.println("╠═════════════════════════════════════╣");
        System.out.println("║ - Informe o ID do Cliente           ║");
        id = input.nextLine();
        System.out.println("║ - Deseja apagar permanentemente     ║");
        System.out.println("║   este Cliente?                     ║");
        System.out.println("║  1. Sim                             ║");
        System.out.println("║  X. Voltar                          ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("\n");
        return id;
    }

    public String menuApagarVenda() {
        input.nextLine(); // Consumir nova linha
        String id;
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║                                     ║");
        System.out.println("║          Apagar Venda               ║");
        System.out.println("║                                     ║");
        System.out.println("╠═════════════════════════════════════╣");
        System.out.println("║ - Informe o ID da Venda             ║");
        id = input.nextLine();
        System.out.println("║ - Deseja apagar permanentemente     ║");
        System.out.println("║   esta Venda?                       ║");
        System.out.println("║  1. Sim                             ║");
        System.out.println("║  X. Voltar                          ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("\n");
        return id;
    }

    public String menuApagarProduto() {
        input.nextLine(); // Consumir nova linha
        String id;
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║                                     ║");
        System.out.println("║          Apagar Produto             ║");
        System.out.println("║                                     ║");
        System.out.println("╠═════════════════════════════════════╣");
        System.out.println("║ - Informe o ID do Produto           ║");
        id = input.nextLine();
        System.out.println("║ - Deseja apagar permanentemente     ║");
        System.out.println("║   este Produto?                     ║");
        System.out.println("║  1. Sim                             ║");
        System.out.println("║  X. Voltar                          ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("\n");
        return id;
    }

    public String menuApagarFuncionario() {
        input.nextLine(); // Consumir nova linha
        String id;
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║                                     ║");
        System.out.println("║        Apagar Funcionário           ║");
        System.out.println("║                                     ║");
        System.out.println("╠═════════════════════════════════════╣");
        System.out.println("║ - Informe o ID do Funcionário       ║");
        id = input.nextLine();
        System.out.println("║ - Deseja apagar permanentemente     ║");
        System.out.println("║   este Funcionário?                 ║");
        System.out.println("║  1. Sim                             ║");
        System.out.println("║  X. Voltar                          ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("\n");
        return id;
    }
}
