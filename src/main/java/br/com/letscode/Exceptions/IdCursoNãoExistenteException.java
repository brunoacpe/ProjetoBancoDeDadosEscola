package br.com.letscode.Exceptions;

public class IdCursoNãoExistenteException extends RuntimeException{

    private final String DEFAULT_MESSAGE = "Não existe nenhum curso cadastrado com este ID.";
}
