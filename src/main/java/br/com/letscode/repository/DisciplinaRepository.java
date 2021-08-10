package br.com.letscode.repository;

import br.com.letscode.entities.Disciplina;
import org.springframework.data.repository.CrudRepository;

public interface DisciplinaRepository extends CrudRepository<Disciplina,Integer> {
}
