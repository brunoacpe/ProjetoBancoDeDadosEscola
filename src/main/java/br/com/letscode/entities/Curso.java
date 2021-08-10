package br.com.letscode.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Getter
@Setter
@Entity
@Table(name="curso")
public class Curso {
    @Id
    @GeneratedValue
    @Column(name="codigo_curso")
    private Long codigoCurso;

    @Column(name="nome_curso")
    private String nomeCurso;

    @Column(name="duracao")
    private int duracao;

    @Column(name="numero_alunos")
    private int numeroAlunos;

    @Enumerated(EnumType.STRING)
    @Column(name="modalidade")
    private Modalidades modalidades;
}
