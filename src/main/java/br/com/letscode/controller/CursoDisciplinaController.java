package br.com.letscode.controller;


import br.com.letscode.entities.CursoDisciplina;
import br.com.letscode.repository.CursoDisciplinaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Api(value = "Operações relacionadas com a Table CursosDisciplina.")
@RestController
@RequestMapping("/cursosdisciplina")
public class CursoDisciplinaController {

    private CursoDisciplinaRepository repository;
    @Autowired
    public CursoDisciplinaController(CursoDisciplinaRepository cursoDisciplinaRepository){
        repository = cursoDisciplinaRepository;
    }


    @GetMapping
    @ApiOperation("Listar todos os CursosDisciplina")
    public Iterable<CursoDisciplina> getCursosDisciplina(){
        return repository.findAll();
    }
}
