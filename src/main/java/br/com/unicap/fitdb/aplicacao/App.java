package main.java.br.com.unicap.fitdb.aplicacao;
import java.sql.SQLException;
import java.util.Scanner;

import main.java.br.com.unicap.fitdb.config.DatabaseConfig;
import main.java.br.com.unicap.fitdb.db.DatabaseConnection;
import main.java.br.com.unicap.fitdb.db.DatabaseHandler;

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
        //pergunta o nome da db para o usuário
        dbName = interfaci.menuAcesso(input);

        do{
            if(access > 0){
                dbName = interfaci.menuAcesso2(input);
            }
            dbExistance = database.databaseExists (dbName); // checa existencia do banco de dados com base no nome informado
            if(dbExistance == true){                        // se existir
                option = interfaci.menuInicial(dbName, input); // exibe o menu inicial
                if(option == 1){                            // cadastrar
                    
                }else if( option == 2){                     // login

                }else{  // qualquer outro input, indica exit

                }
            }else{                                          // se o banco informado não existir, 
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
    
}
