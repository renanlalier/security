package br.com.gumga.security.domain;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import com.google.common.util.concurrent.AtomicDouble;

import br.com.gumga.security.interfaces.IDeductions;
import br.com.gumga.security.interfaces.ISecurity;

/**
 * Classe responsável por manter as regras para calculo de decremento de
 * segurança de senha
 * 
 * @author Renan Lalier <relalier@gmail.com>
 * @since 22/12/2017
 *
 */
public class Deductions implements ISecurity, IDeductions {

	private String password;

	public Deductions(String password) {
		this.password = password.replace("\\s+", "");
	}

	@Override
	public Integer execute() {
		return lettesOnly() + numbersOnly() + repeatCharacters() + consecutiveUpperCaseLetters()
				+ consecutiveLowerCaseLetters() + consecutiveNumbers() + sequencialNumbers() + sequencialLetters()
				+ sequencialSymbols();
	}

	@Override
	public Integer lettesOnly() {
		int totalLetters = Math.toIntExact(password.chars().filter(Character::isLetter).count());
		return password.length() == totalLetters ? totalLetters : 0;
	}

	@Override
	public Integer numbersOnly() {
		int totalNumbers = Math.toIntExact(password.chars().filter(Character::isDigit).count());
		return password.length() == totalNumbers ? totalNumbers : 0;
	}

	@Override
	public Integer repeatCharacters() {

		AtomicDouble nRepInc = new AtomicDouble();
		AtomicInteger nRepChar = new AtomicInteger();

		IntStream.range(0, password.length()).forEach(a -> {

			AtomicBoolean bCharExists = new AtomicBoolean(false);
			IntStream.range(0, password.length()).forEach(b -> {
				if (password.charAt(a) == password.charAt(b) && a != b && !Character.isSpaceChar(password.charAt(a))) {
					bCharExists.set(true);
					nRepInc.getAndSet(nRepInc.get() + Math.abs(password.length() / (b - a)));
				}
			});
			if (bCharExists.get()) {
				nRepChar.getAndIncrement();
				int nUnqChar = password.length() - nRepChar.get();
				nRepInc.getAndSet((nUnqChar > 0) ? Math.ceil(nRepInc.get() / nUnqChar) : Math.ceil(nRepInc.get()));
			}
		});

		return (int) Math.round(nRepInc.get());
	}

	@Override
	public Integer consecutiveUpperCaseLetters() {

		AtomicInteger total = new AtomicInteger();
		AtomicInteger index = new AtomicInteger();

		password.chars().forEach(a -> {
			index.getAndIncrement();
			if (index.get() < password.length() && Character.isUpperCase(a)
					&& Character.isUpperCase(password.charAt(index.get()))) {
				total.incrementAndGet();
			}
		});

		return total.get() * 2;
	}

	@Override
	public Integer consecutiveLowerCaseLetters() {

		AtomicInteger total = new AtomicInteger();
		AtomicInteger index = new AtomicInteger();

		password.chars().forEach(a -> {
			index.getAndIncrement();
			if (index.get() < password.length() && Character.isLowerCase(a)
					&& Character.isLowerCase(password.charAt(index.get()))) {
				total.incrementAndGet();
			}
		});

		return total.get() * 2;
	}

	@Override
	public Integer consecutiveNumbers() {

		AtomicInteger total = new AtomicInteger();
		AtomicInteger index = new AtomicInteger();

		password.chars().forEach(a -> {
			index.getAndIncrement();
			if (index.get() < password.length() && Character.isDigit(a)
					&& Character.isDigit(password.charAt(index.get()))) {
				total.incrementAndGet();
			}
		});

		return total.get() * 2;
	}

	@Override
	public Integer sequencialNumbers() {

		AtomicInteger total = new AtomicInteger();
		final String numbers = "01234567890";

		IntStream.range(1, 9).forEach(n -> {
			String sFwd = numbers.substring(n, (n + 3));
			String sRev = new StringBuilder(sFwd).reverse().toString();
			if (password.indexOf(sFwd) != -1 || password.indexOf(sRev) != -1) {
				total.getAndIncrement();
			}
		});

		return total.get() * 3;
	}

	@Override
	public Integer sequencialLetters() {

		AtomicInteger total = new AtomicInteger();
		final String letters = "abcdefghijklmnopqrstuvwxyz";

		IntStream.range(0, 24).forEach(n -> {
			String sFwd = letters.substring(n, (n + 3));
			String sRev = new StringBuilder(sFwd).reverse().toString();
			if (password.toLowerCase().indexOf(sFwd) != -1 || password.toLowerCase().indexOf(sRev) != -1) {
				total.getAndIncrement();
			}
		});

		return total.get() * 3;
	}

	@Override
	public Integer sequencialSymbols() {

		AtomicInteger total = new AtomicInteger();
		final String symbols = ")!@#$%^&*()";

		IntStream.range(1, 9).forEach(n -> {
			String sFwd = symbols.substring(n, (n + 3));
			String sRev = new StringBuilder(sFwd).reverse().toString();
			if (password.toLowerCase().indexOf(sFwd) != -1 || password.toLowerCase().indexOf(sRev) != -1) {
				total.getAndIncrement();
			}
		});

		return total.get() * 3;
	}

}
