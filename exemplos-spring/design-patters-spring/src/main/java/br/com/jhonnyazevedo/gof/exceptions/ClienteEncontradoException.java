package br.com.jhonnyazevedo.gof.exceptions;

public class ClienteEncontradoException extends RuntimeException {

    public ClienteEncontradoException() {
        super("Já há um cliente cadastrado com esse nome.");
    }
}
