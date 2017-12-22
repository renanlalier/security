package br.com.gumga.domain;

import org.junit.Assert;
import org.junit.Test;

import br.com.gumga.security.domain.Additions;
import br.com.gumga.security.domain.Deductions;
import br.com.gumga.security.domain.Score;

/**
 * Classe responsável por manter os testes unitários das operações de calculo de score
 * 
 * @author Renan Lalier <relalier@gmail.com>
 * @since 22/12/2017
 *
 */
public class ScoreUnitTest {

	private Score score;

	public ScoreUnitTest() {
		final String password = "Db12017";
		score = new Score(new Additions(password), new Deductions(password));
	}

	@Test
	public void calculateScoreTest() {
		Assert.assertEquals("{\"score\":71,\"complexity\":\"Forte\"}", score.getScore());
	}

}
