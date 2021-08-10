package br.com.letscode.repository;

import br.com.letscode.entities.TelefoneProfessor;
import org.springframework.data.repository.CrudRepository;

public interface TelefoneRepository extends CrudRepository<TelefoneProfessor,Long> {
}
