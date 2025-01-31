package CadastroEscola.CadastroEscola;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        /*Colocar dependência do postgres no pom.xml para conexão com banco de dados*/
       System.out.println("Conexão cadastro escola.");
    }
}
