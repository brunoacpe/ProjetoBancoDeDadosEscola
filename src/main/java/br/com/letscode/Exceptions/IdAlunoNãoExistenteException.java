package br.com.letscode.Exceptions;

public class IdAlunoNãoExistenteException extends RuntimeException{

    private final String DEFAULT_MESSAGE = "Não existe nenhum aluno com este ID.";

    public IdAlunoNãoExistenteException(){

    }
}
