package main.java.br.com.unicap.fitdb.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import main.java.br.com.unicap.fitdb.config.DatabaseConfig;
/*
 A classe possui um atributo config, que recebe uma instância de DatabaseConfig, de modo que
 o método getConnection usa os valores de configuração (url, user, password) fornecidos pela DatabaseConfig 
 para criar e retornar uma nova conexão com o banco de dados usando DriverManager.getConnection

 */
public class DatabaseConnection {
    private DatabaseConfig config;

    public DatabaseConnection(DatabaseConfig config) {
        this.config = config;
    }
    
/*
 DriverManager é uma classe fornecida pela API JDBC que gerencia um conjunto de drivers de banco de dados. 
 O driver JDBC traduz as chamadas da API JDBC para comandos específicos do banco de dados utilizado.
 Cada tipo de banco de dados tem seu próprio driver JDBC. 
 No nosso caso, especificamos o driver 'mysql-connector-java'nas dependências.
 Sem o driver, a aplicação Java não seria capaz de se conectar ao banco de dados ou executar consultas SQL.
 */


 /*
  O DriverManager irá verificar se há um driver registrado que pode lidar com a URL fornecida.
  O driver mysql tem um método 'acceptURL' que irá verificar se é possível se conectar ao banco de dados especificado na URL.
  O método getConnection se comunica com o driver que irá implementar a lógica de conexão e retornar um objeto Connection se ela 
  for estabelecida com sucesso.
  Se ocorrer um erro uma SQLException é lançada.
  */

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword());
    }

    public void setConfig(DatabaseConfig config) {
        this.config = config;
    }
    

/*
 A interface Connection na API JDBC possui vários métodos para manipular uma conexão com um banco de dados. 
 Durante o seu uso, há certas propriedades da conexão que podem ser configuradas ou consultadas através de métodos específicos.
 Além disso, possui métodos para consulta do banco de dados.
 */
}
