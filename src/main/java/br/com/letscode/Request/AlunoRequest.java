package br.com.letscode.Request;

import br.com.letscode.entities.Aluno;
import br.com.letscode.entities.Curso;
import br.com.letscode.repository.CursoRepository;
import lombok.Getter;

import java.sql.Date;
import java.util.Optional;

@Getter
public class AlunoRequest {

    private Long ra;
    private String nome;
    private String sobrenome;
    private Date datanascimento;
    private Long codigocurso;


    public  Aluno converter(CursoRepository cursoRepository){
        Optional<Curso> curso   = cursoRepository.findById(codigocurso);
        return new Aluno(ra,nome,sobrenome,datanascimento,curso.get().getCodigoCurso());
    }
}
