package br.com.letscode.Exceptions;

public class IdAlunoNÃ£oExistenteException extends RuntimeException{

    private final String DEFAULT_MESSAGE = "NÃ£o existe nenhum aluno com este ID.";

    public IdAlunoNÃ£oExistenteException(){

    }
}
