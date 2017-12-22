package br.com.gumga.security.domain;

import com.google.gson.JsonObject;

import br.com.gumga.security.enums.Complexity;
import br.com.gumga.security.interfaces.ISecurity;

/**
 * Classe responsável por manter as regras para calculo do score de senha
 * 
 * @author Renan Lalier <relalier@gmail.com>
 * @since 22/12/2017
 *
 */
public class Score {

	private ISecurity scoreAdditions;
	private ISecurity scoreDeductions;

	public Score(ISecurity scoreAdditions, ISecurity scoreDeductions) {
		this.scoreAdditions = scoreAdditions;
		this.scoreDeductions = scoreDeductions;
	}

	public Integer calculateScore() {
		int score = scoreAdditions.execute() - scoreDeductions.execute();
		if(score < 0){
		  return 0;	
		}else if(score > 100){
			return 100;
		}
		return score;
	}

	public Complexity getComplexity(Integer score) {

		if (score >= 0 && score < 20) {
			return Complexity.VERY_WEAK;
		} else if (score >= 20 && score < 40) {
			return Complexity.WEAK;
		} else if (score >= 40 && score < 60) {
			return Complexity.GOOD;
		} else if (score >= 60 && score < 80) {
			return Complexity.STRONG;
		}

		return Complexity.VERY_STRONG;
	}

	public String getScore() {
		Integer score = calculateScore();
		JsonObject json = new JsonObject();
		json.addProperty("score", score);
		json.addProperty("complexity", getComplexity(score).getDescription());
		return json.toString();
	}

}
