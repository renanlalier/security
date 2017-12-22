package br.com.gumga.security.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.gumga.security.usecase.SecurityUseCase;

/**
 * Classe responsável por manter os recursos para validação de segurança de senha
 * 
 * @author Renan Lalier <relalier@gmail.com>
 * @since 22/12/2017
 *
 */
@RestController
public class SecurityResource {
	
	@Autowired
	private SecurityUseCase securityUseCase;

	@CrossOrigin("*")
	@RequestMapping(value = "/security", method = RequestMethod.POST)
	public @ResponseBody String sendPassword(@RequestBody String password){
		return securityUseCase.verifySecurityPassword(password);
	}
	
}
