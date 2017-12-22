package br.com.gumga.domain;

import org.junit.Assert;
import org.junit.Test;

import br.com.gumga.security.domain.Additions;

/**
 * Classe responsável por manter os testes unitários das operações de additions
 * 
 * @author Renan Lalier <relalier@gmail.com>
 * @since 22/12/2017
 *
 */
public class AdditionsUnitTest {

	private Additions additions;

	public AdditionsUnitTest() {
		additions = new Additions("dB1@2017");
	}

	@Test
	public void numberOfCharactersTest() {
		Assert.assertEquals(32, (int) additions.numberOfCharacters());
	}

	@Test
	public void upperCaseLettersTest() {
		Assert.assertEquals(14, (int) additions.upperCaseLetters());
	}

	@Test
	public void lowerCaseLettersTest() {
		Assert.assertEquals(14, (int) additions.lowerCaseLetters());
	}

	@Test
	public void numbersTest() {
		Assert.assertEquals(20, (int) additions.numbers());
	}

	@Test
	public void symbolsTest() {
		Assert.assertEquals(6, (int) additions.symbols());
	}

	@Test
	public void middleNumberSymbolsTest() {
		Assert.assertEquals(10, (int) additions.middleNumberSymbols());
	}

	@Test
	public void requirementsTest() {
		Assert.assertEquals(10, (int) additions.requirements());
	}

}
