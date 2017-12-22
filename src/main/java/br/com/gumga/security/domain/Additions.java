package br.com.gumga.security.domain;

import java.util.concurrent.atomic.AtomicInteger;

import br.com.gumga.security.interfaces.IAdditions;
import br.com.gumga.security.interfaces.ISecurity;

/**
 * Classe responsável por manter as regras para calculo de incremento de
 * segurança de senha
 * 
 * @author Renan Lalier <relalier@gmail.com>
 * @since 22/12/2017
 *
 */
public class Additions implements ISecurity, IAdditions {

	private String passwordValid;
	private String passwordInfo;

	public Additions(String password) {
		this.passwordValid = password.replace("\\s+", "");
		this.passwordInfo = password;
	}

	@Override
	public Integer execute() {
		return numberOfCharacters() + upperCaseLetters() + lowerCaseLetters() + numbers() + symbols()
				+ middleNumberSymbols() + requirements();
	}

	@Override
	public Integer numberOfCharacters() {
		return passwordInfo.length() * 4;
	}

	@Override
	public Integer upperCaseLetters() {
		Integer totalUpperCase = Math.toIntExact(passwordValid.chars().filter(Character::isUpperCase).count());
		return totalUpperCase > 0 ? (passwordValid.length() - totalUpperCase) * 2 : 0;
	}

	@Override
	public Integer lowerCaseLetters() {
		Integer totalLowerCase = Math.toIntExact(passwordValid.chars().filter(Character::isLowerCase).count());
		return totalLowerCase > 0 ? (passwordValid.length() - totalLowerCase) * 2 : 0;
	}

	@Override
	public Integer numbers() {
		return Math.toIntExact(passwordValid.chars().filter(Character::isDigit).count()) * 4;
	}

	@Override
	public Integer symbols() {
		return Math
				.toIntExact(passwordValid.chars()
						.filter(c -> !Character.isLetterOrDigit(c) && c != '_' && !Character.isSpaceChar(c)).count())
				* 6;
	}

	@Override
	public Integer middleNumberSymbols() {
		AtomicInteger position = new AtomicInteger();
		return Math
				.toIntExact(passwordValid.chars().peek(p -> position.incrementAndGet())
						.filter(c -> position.get() > 1 && position.get() < passwordValid.length()
								&& (Character.isDigit(c)
										|| (!Character.isLetter(c) && c != '_' && !Character.isSpaceChar(c))))
						.count())
				* 2;

	}

	@Override
	public Integer requirements() {

		Integer totalCharacters = passwordValid.length() >= 8 ? 1 : 0;
		Integer numbers = Math.toIntExact(passwordValid.chars().filter(Character::isDigit).limit(1).count());
		Integer upperCase = Math.toIntExact(passwordValid.chars().filter(Character::isUpperCase).limit(1).count());
		Integer lowerCase = Math.toIntExact(passwordValid.chars().filter(Character::isLowerCase).limit(1).count());
		Integer symbols = Math
				.toIntExact(passwordValid.chars().filter(c -> !Character.isLetterOrDigit(c)).limit(1).count());

		Integer requirementsItems = numbers + upperCase + lowerCase + symbols;

		return requirementsItems >= 3 && totalCharacters == 1 ? (requirementsItems + totalCharacters) * 2 : 0;

	}

}
