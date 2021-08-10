package br.com.letscode.controller;

import br.com.letscode.Exceptions.IdProfessorNãoEncontrado;
import br.com.letscode.entities.Professor;
import br.com.letscode.repository.ProfessorRepository;
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

@Api(value="Operações relacionadas com professores.")
@RestController
@RequestMapping("/professor")
public class ProfessorController {
    private ProfessorRepository repository;

    @Autowired
    public ProfessorController(ProfessorRepository professorRepository){
        this.repository = professorRepository;
    }

    @ApiOperation(value="Listar todos os professores")
    @GetMapping
    public Iterable<Professor> buscarProfessores(){
        return repository.findAll();
    }

    @ApiOperation(value="Persistir um novo professor.")
    @PostMapping
    public void persistirProfessor(@RequestBody Professor professor){
        repository.save(professor);
    }

    @ApiOperation(value="Buscar professor pelo id.")
    @GetMapping("/buscarProfessorPeloId")
    public Professor buscarProfessorPeloId(@RequestParam Long idProfessor){
        return repository.findById(idProfessor).orElseThrow(IdProfessorNãoEncontrado::new);
    }

    @ApiOperation(value="Atualizar o nome do professor.")
    @PutMapping
    public void updateNomeProfessor(@RequestParam Long idProfessor, @RequestParam String novoNome){
        Professor professor = repository.findById(idProfessor).orElseThrow(IdProfessorNãoEncontrado::new);
        repository.delete(professor);
        professor.setNome(novoNome);
        repository.save(professor);
    }
}
