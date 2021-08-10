package br.com.letscode.DTO;


import br.com.letscode.entities.Aluno;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class AlunoDTO {

    private Long ra;
    private String nome;
    private String sobrenome;
    private Date datanascimento;


    public AlunoDTO(Aluno aluno){
        ra = aluno.getId();
        nome = aluno.getNome();
        sobrenome = aluno.getSobrenome();
        datanascimento = aluno.getData();
    }

    public static List<AlunoDTO> retornarDTO(List<Aluno> alunos){
        return alunos.stream()
                .map(AlunoDTO::new)
                .collect(Collectors.toList());
    }
}
