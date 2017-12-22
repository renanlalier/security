package br.com.gumga.security.usecase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Classe responsável por manter factory para criação dos beans use case da
 * aplicação
 * 
 * @author Renan Lalier <relalier@gmail.com>
 * @since 22/12/2017
 *
 */
@Configuration
public class FactoryUseCase {

	@Bean
	public SecurityUseCase calculateUseCase() {
		return new SecurityUseCase();
	}

}
