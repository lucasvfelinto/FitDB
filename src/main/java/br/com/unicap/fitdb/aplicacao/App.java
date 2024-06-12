package main.java.br.com.unicap.fitdb.aplicacao;

import java.sql.SQLException;
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
        
    do{
        //pergunta o nome da db para o usuário
        dbName = interfaci.menuAcesso(input);
        dbExistance = database.databaseExists (dbName);
        if(dbExistance == true){
            //
        }else{
            option = interfaci.menuDbNaoExiste(input);
            if(option == 1){
                // nada
            }else{
                dbName = interfaci.menuCriarBanco(input);
            }
        }

    }while(systemStatus != false);

    }





    public void checkDatabaseExistance (DatabaseHandler database, String dbName){
        boolean dbExistance = false;
        dbExistance = database.databaseExists(dbName);
    }
    
}
