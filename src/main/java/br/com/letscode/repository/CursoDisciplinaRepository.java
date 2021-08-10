package br.com.letscode.repository;

import br.com.letscode.entities.Curso;
import br.com.letscode.entities.CursoDisciplina;
import org.springframework.data.repository.CrudRepository;

public interface CursoDisciplinaRepository extends CrudRepository<CursoDisciplina,Long> {
}
