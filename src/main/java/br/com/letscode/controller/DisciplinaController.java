package br.com.letscode.controller;
import br.com.letscode.Exceptions.idDisciplinaNãoExistenteException;
import br.com.letscode.entities.Disciplina;
import br.com.letscode.repository.DisciplinaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(value="Operações relacionadas com disciplina.")
@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    private DisciplinaRepository repository;
    @Autowired
    public DisciplinaController(DisciplinaRepository disciplinaRepository){
        repository = disciplinaRepository;
    }

    @ApiOperation(value="Listar todas as disciplinas.")
    @GetMapping
    public Iterable<Disciplina> getDisciplinas(){
        return repository.findAll();
    }

    @ApiOperation(value="Persistir uma nova disciplina no banco de dados.")
    @PostMapping
    public void persistirDisciplina(@RequestBody Disciplina disciplina){
        repository.save(disciplina);
    }

    @ApiOperation(value="Buscar uma disciplina pelo ID.")
    @GetMapping(name="/buscarPorID")
    public Disciplina buscarPorID(@RequestParam Integer idDisciplina){
        return repository.findById(idDisciplina).orElseThrow(idDisciplinaNãoExistenteException::new);
    }

    @ApiOperation(value="Atualizar o nome de um curso.")
    @PutMapping
    public void updateNomeDisciplina(@RequestParam Integer idDisciplina, @RequestParam String nomeNovo){
        Disciplina disciplina = repository.findById(idDisciplina).orElseThrow(idDisciplinaNãoExistenteException::new);
        repository.delete(disciplina);
        disciplina.setNomeCurso(nomeNovo);
        repository.save(disciplina);
    }
}
