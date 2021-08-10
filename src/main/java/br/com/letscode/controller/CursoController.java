package br.com.letscode.controller;


import br.com.letscode.Exceptions.IdCursoNãoExistenteException;
import br.com.letscode.entities.Curso;
import br.com.letscode.repository.CursoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(value="Todas as operações relacionadas a Table Cursos.")
@RestController
@RequestMapping("/cursos")
public class CursoController {

    private CursoRepository repository;
    @Autowired
    public CursoController(CursoRepository cursoRepository){
        repository = cursoRepository;
    }


    @GetMapping
    @ApiOperation(value="Listar todos os cursos.")
    public Iterable<Curso> getCursos(){
        return repository.findAll();
    }

    @PostMapping
    @ApiOperation("Persistir um curso novo.")
    public void persistirCurso(@RequestBody Curso curso){
        repository.save(curso);
    }

    @DeleteMapping
    @ApiOperation("Deletar um curso pelo ID.")
    public void deleteCurso(@RequestParam Long idCurso){
        repository.deleteById(idCurso);
    }

    @GetMapping("/buscarCursoPeloId")
    @ApiOperation("Buscar um curso pelo ID.")
    public Curso buscarCursoPeloId(@RequestParam Long idCurso){
        return repository.findById(idCurso).orElseThrow(IdCursoNãoExistenteException::new);
    }

    @PutMapping("/atualizarNomeCurso")
    @ApiOperation("Atualizar o nome do curso pelo ID.")
    public void atualizarNomeCursoID(@RequestParam Long idCurso, @RequestParam String novoNomeCurso){
        Curso curso = repository.findById(idCurso).orElseThrow(IdCursoNãoExistenteException::new);
        repository.deleteById(idCurso);
        curso.setNomeCurso(novoNomeCurso);
        repository.save(curso);
    }
}
