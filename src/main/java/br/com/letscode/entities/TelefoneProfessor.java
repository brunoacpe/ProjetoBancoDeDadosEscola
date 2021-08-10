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
@Getter
@Setter
@Entity(name="telefoneProfessor")
@Table(name="telefone_professor")
@NoArgsConstructor
public class TelefoneProfessor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    private int numero;

    @ManyToOne
    @JoinColumn(name="registro_professor", referencedColumnName = "registro_professor")
    private Professor registroProfessor;
}
