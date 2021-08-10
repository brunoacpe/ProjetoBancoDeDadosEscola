package br.com.letscode.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="curso_disciplina")
public class CursoDisciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="codigo_curso", referencedColumnName = "codigo_curso")
    private Curso codigoCurso;

    @ManyToOne
    @JoinColumn(name="codigo_disciplina", referencedColumnName = "codigo_disciplina")
    private Disciplina codigoDisciplina;

    @ManyToOne
    @JoinColumn(name="registro_professor", referencedColumnName = "registro_professor")
    private Professor codigoProfessor;
}
