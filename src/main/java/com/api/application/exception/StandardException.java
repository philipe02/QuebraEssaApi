package com.api.application.exception;

public class StandardException extends Exception {

	public StandardException(Exception e) {
		super("Ocorreu um erro ao realizar a operação", e.getCause());
	}
}
