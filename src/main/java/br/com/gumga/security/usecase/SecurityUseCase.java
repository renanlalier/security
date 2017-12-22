package br.com.gumga.security.usecase;

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
	
	public String verifySecurityPassword(String password){
		Score score = new Score(new Additions(password), new Deductions(password));
		return score.getScore();
	}

}
