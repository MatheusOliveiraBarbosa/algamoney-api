package br.com.matheusoliveira.algamoney.api.security.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeradorSenha {
	
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode("admin"));
		System.out.println(encoder.encode("visitante"));
		System.out.println(encoder.encode("@ngul@r0"));
		System.out.println(encoder.encode("m0b1l35"));
	}

}
