package br.com.matheusoliveira.algamoney.api.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.matheusoliveira.algamoney.api.config.property.AlgamoneyApiProperty;

@RestController
@RequestMapping("/tokens")
public class TokenController {

	@Autowired
	private AlgamoneyApiProperty algamoneyApiProperty;
	/**
	 * Logout removing booth tokens (Refresh and current)
	 */
	@DeleteMapping("/revoke")
	public void revoke(HttpServletRequest req, HttpServletResponse res) {
		Cookie cookie = new Cookie("refreshToken", null);
		cookie.setHttpOnly(true);
		cookie.setSecure(algamoneyApiProperty.getSeguranca().isEnableHttps()); //TODO : Em producao sera true
		cookie.setPath(req.getContextPath() + "/oauth/token");
		cookie.setMaxAge(0); //Remove realtime
		
		res.addCookie(cookie);
		res.setStatus(HttpStatus.NO_CONTENT.value());
	}
	
}
