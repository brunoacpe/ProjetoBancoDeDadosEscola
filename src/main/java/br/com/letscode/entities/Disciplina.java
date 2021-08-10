package br.com.letscode.entities;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="disciplina")
public class Disciplina {

    @Id
    @Column(name="codigo_disciplina")
    private int codigoDisciplina;

    @Column(name="nome_disciplina")
    @NotNull
    private String nomeCurso;

    @Column(name="carga_horaria_pratica")
    @NotNull
    private int cargaHorariaPratica;

    @Column(name="carga_horaria_teorica")
    @NotNull
    private int cargaHorariaTeorica;

}
