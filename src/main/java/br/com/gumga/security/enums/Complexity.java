package br.com.gumga.security.enums;

/**
 * Enum responsável por manter as constantes que representam as complexidades da
 * senha
 * 
 * @author Renan Lalier <relalier@gmail.com>
 * @since 22/12/2017
 *
 */
public enum Complexity {

	GOOD("Boa"), 
	STRONG("Forte"), 
	TOO_SHORT("Muito curta"),
	VERY_WEAK("Muito fácil"),
	VERY_STRONG("Muito forte"), 
	WEAK("Fácil");
	
	private String description;
	
	private Complexity(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}

}
