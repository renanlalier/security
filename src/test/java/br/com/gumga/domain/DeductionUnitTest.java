package br.com.gumga.domain;

import org.junit.Assert;
import org.junit.Test;

import br.com.gumga.security.domain.Deductions;

/**
 * Classe responsável por manter os testes unitários das operações de deductions
 * 
 * @author Renan Lalier <relalier@gmail.com>
 * @since 22/12/2017
 *
 */
public class DeductionUnitTest {

	private Deductions deductions;

	public DeductionUnitTest() {
		deductions = new Deductions("dBbbcd1@201789");
	}

	@Test
	public void lettesOnlyTest() {
		Assert.assertEquals(0, (int) deductions.lettesOnly());
	}

	@Test
	public void numbersOnlyTest() {
		Assert.assertEquals(0, (int) deductions.numbersOnly());
	}

	@Test
	public void repeatCharactersTest() {
		Assert.assertEquals(1, (int) deductions.repeatCharacters());
	}

	@Test
	public void consecutiveUpperCaseLettersTest() {
		Assert.assertEquals(0, (int) deductions.consecutiveUpperCaseLetters());
	}

	@Test
	public void consecutiveLowerCaseLettersTest() {
		Assert.assertEquals(6, (int) deductions.consecutiveLowerCaseLetters());
	}

	@Test
	public void consecutiveNumbersTest() {
		Assert.assertEquals(10, (int) deductions.consecutiveNumbers());
	}

	@Test
	public void sequencialNumbersTest() {
		Assert.assertEquals(3, (int) deductions.sequencialNumbers());
	}

	@Test
	public void sequencialLettersTest() {
		Assert.assertEquals(3, (int) deductions.sequencialLetters());
	}

	@Test
	public void sequencialSymbolsTest() {
		Assert.assertEquals(0, (int) deductions.sequencialSymbols());
	}

}
