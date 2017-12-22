package br.com.gumga.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * Classe responsável pela execução da aplicação
 * 
 * @author Renan Lalier <relalier@gmail.com>
 * @since 20/12/2017
 *
 */
@SpringBootApplication
@ComponentScan("br.com.gumga.security")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
