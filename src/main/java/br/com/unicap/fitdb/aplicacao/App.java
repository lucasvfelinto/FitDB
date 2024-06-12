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
        boolean systemStatus = true;
        boolean dbExistance = false;
        Scanner input = new Scanner(System.in);
        Menu interfaci = new Menu(); //interfaci pq com e é palavra reservada
        
    do{
    // DatabseConfig é um objeto que encapsula as informações de configuração necessárias para se conectar ao SGBD. 
        DatabaseConfig infoConexao = new DatabaseConfig(url,user,password);
    
    //pergunta o nome da db para o usuário
        dbName = interfaci.menuAcesso(input);
        try {
            // DatabaseConnection é um objeto que irá utilizar as informações do objeto DatabaseConfig numa instância do DriverManger
            // O DriverManager é responsável por tentar uma conexão com o SGBD mysql
            DatabaseConnection conexao = new DatabaseConnection(infoConexao);

            // DataBaseHandler usa a conexão estabelecida pelo DatabaseConnection,
            DatabaseHandler database = new DatabaseHandler(conexao);
            dbExistance = database.databaseExists(infoConexao, dbName);
            if(dbExistance == true){
                //
            }else{

            }

        } catch (SQLException erro) {
            System.out.println("Houve um erro ao acessar o banco de dados");
            System.out.println(erro);
            erro.printStackTrace();
        }


        

        
       

        
    }while(systemStatus != false);

    }
    
}
