package main.java.br.com.unicap.fitdb.aplicacao;
import java.util.Scanner;

import main.java.br.com.unicap.fitdb.config.DatabaseConfig;
import main.java.br.com.unicap.fitdb.db.DatabaseConnection;
import main.java.br.com.unicap.fitdb.db.DatabaseHandler;

public class App {
    public static void main(String[] args) {
        String url; // iniciar com o url
        String user = "root";
        String password; // iniciar com a password
        String dbName = new String();
        int option = -1;
        int access = 0;
        boolean systemStatus = true;
        boolean dbExistance = false;
        Scanner input = new Scanner(System.in);
        Menu interfaci = new Menu(); //interfaci pq com e é palavra reservada
        // DatabseConfig é um objeto que encapsula as informações de configuração necessárias para se conectar ao SGBD. 
        DatabaseConfig infoConexao = new DatabaseConfig(url,user,password);
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
                //
            }else{                                          // se o banco informado não existir, 
                option = interfaci.menuDbNaoExiste(input);  // fornece a opção de tentar novamente inserir o nome ou criar o banco
                if(option == 2){                            // opção 2 criar banco
                    dbName = interfaci.menuCriarBanco(input); // chama o menu para criar banco
                }else{
                    // nada e volta para o começo
                }
            }
            access++;
        }while(systemStatus != false);

    }





    public void checkDatabaseExistance (DatabaseHandler database, String dbName){
        boolean dbExistance = false;
        dbExistance = database.databaseExists(dbName);
    }
    
}
