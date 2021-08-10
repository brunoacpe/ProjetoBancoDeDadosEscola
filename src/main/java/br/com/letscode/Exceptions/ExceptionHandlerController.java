package br.com.letscode.Exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(IdAlunoNãoExistenteException.class)
    public final ResponseEntity<ExceptionResponse> handleIdAlunoNãoEncontradoException(IdAlunoNãoExistenteException ex){
        return new ResponseEntity<>(
            new ExceptionResponse(ex.getMessage(),"Não existe nenhum aluno cadastrado com este id."),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(IdCursoNãoExistenteException.class)
    public final ResponseEntity<ExceptionResponse> handleIdCursoNãoExistenteException(IdCursoNãoExistenteException ex){
        return new ResponseEntity<>(
                new ExceptionResponse(ex.getMessage(),"Não existe nenhum curso cadastrado com este ID."),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(idDisciplinaNãoExistenteException.class)
    public final ResponseEntity<ExceptionResponse> handleIdDisciplinaNãoExistenteException(idDisciplinaNãoExistenteException ex){
        return new ResponseEntity<>(
                new ExceptionResponse(ex.getMessage(),"Não existe nenhuma disciplina cadastrada com este ID"),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(IdProfessorNãoEncontrado.class)
    public final ResponseEntity<ExceptionResponse> handleIdProfessorNãoExistenteException(IdProfessorNãoEncontrado ex){
        return new ResponseEntity<>(
                new ExceptionResponse(ex.getMessage(),"Não existe nenhum professor cadastrado com este ID."),
                HttpStatus.BAD_REQUEST
        );
    }
}
