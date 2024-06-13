package main.java.br.com.unicap.fitdb.config;

/*
Encapsula as informações de configuração necessárias para se conectar a um banco de dados. 
Seguindo o princípio de separation of concerns, desse modo, mantendo as configurações de conexão do banco de dados 
separadas da lógica de negócios e da lógica de acesso a dados. 
*/
public class DatabaseConfig {
    private String url; // Uma string que especifica a localização do banco de dados e o protocolo de conexão.
    
    // Strings que representam o nome de usuário e a senha necessários para autenticação no banco de dados.
    private String user;
    private String password;

    public DatabaseConfig() {
        this.url = "jdbc:mysql://localhost:3306"; //definir
        this.user = "root";
        this.password = "Mvgs426955#"; //definir
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}

