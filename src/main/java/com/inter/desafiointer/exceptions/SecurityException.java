package com.inter.desafiointer.exceptions;

public class SecurityException extends RuntimeException {

	private static final long serialVersionUID = -254512835045390551L;
	
	@Override
	public String getMessage() {
		return "Ocorreu um erro ao relizar operações de segurança";
	}

}
