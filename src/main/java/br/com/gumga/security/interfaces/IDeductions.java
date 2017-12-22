package br.com.gumga.security.interfaces;

public interface IDeductions {
	
	public Integer lettesOnly();
	
	public Integer numbersOnly();
	
	public Integer repeatCharacters();
	
	public Integer consecutiveUpperCaseLetters();
	
	public Integer consecutiveLowerCaseLetters();
	
	public Integer consecutiveNumbers();
	
	public Integer sequencialNumbers();
	
	public Integer sequencialLetters();
	
	public Integer sequencialSymbols();
	

}
