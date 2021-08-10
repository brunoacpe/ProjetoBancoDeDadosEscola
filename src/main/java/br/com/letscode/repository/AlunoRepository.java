package br.com.letscode.repository;

import br.com.letscode.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AlunoRepository extends JpaRepository<Aluno,Long> {
}
