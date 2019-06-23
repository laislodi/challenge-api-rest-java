package com.challenge.exception;

public class ContaNaoEncontrada extends RuntimeException {
    public ContaNaoEncontrada(String msgContaNaoEncontrada, String codeContaNaoEncontrada) {
        super(codeContaNaoEncontrada);
    }
}
