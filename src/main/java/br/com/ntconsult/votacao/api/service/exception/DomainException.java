package br.com.ntconsult.votacao.api.service.exception;

public class DomainException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DomainException() {

	}

	public DomainException(String message) {
		super(message);
	}

}
