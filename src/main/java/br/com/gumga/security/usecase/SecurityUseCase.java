package br.com.gumga.security.usecase;

import org.apache.log4j.Logger;

import br.com.gumga.security.domain.Additions;
import br.com.gumga.security.domain.Deductions;
import br.com.gumga.security.domain.Score;

/**
 * Classe responsável por manter os métodos de validação de senhas
 * 
 * @author Renan Lalier <relalier@gmail.com>
 * @since 22/12/2017
 *
 */
public class SecurityUseCase {

	private static final Logger LOGGER = Logger.getLogger(SecurityUseCase.class);

	public String verifySecurityPassword(String password) {
		String scoreData = "";
		try {
			Score score = new Score(new Additions(password), new Deductions(password));
			scoreData = score.getScore();
		} catch (NullPointerException | StringIndexOutOfBoundsException e) {
			LOGGER.error("Error verify security password", e);
		}

		return scoreData;
	}

}
