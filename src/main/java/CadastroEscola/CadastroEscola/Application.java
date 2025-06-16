package CadastroEscola.CadastroEscola;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
    	
	   Logger log = Logger
			   .getLogger(Application.class.getName());

	   SpringApplication.run(Application.class, args);
	   log.info("Conectado Cadastro escola.");
	   System.out.println("Conexão cadastro escola.");
       
    }
}
