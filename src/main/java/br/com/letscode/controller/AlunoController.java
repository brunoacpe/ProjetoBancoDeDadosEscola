package br.com.letscode.controller;


import br.com.letscode.DTO.AlunoDTO;
import br.com.letscode.Exceptions.IdAlunoNãoExistenteException;
import br.com.letscode.Request.AlunoRequest;
import br.com.letscode.entities.Aluno;
import br.com.letscode.repository.AlunoRepository;
import br.com.letscode.repository.CursoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Api(value="Todas as operações da Table Alunos")
@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private AlunoRepository repository;
    private CursoRepository cursoRepository;
    @Autowired
    public AlunoController(AlunoRepository alunoRepository, CursoRepository cursoRepository){
        repository = alunoRepository;
        cursoRepository = cursoRepository;
    }


    @GetMapping
    @ApiOperation(value="Listar todos os alunos do banco de dados.")
    public List<AlunoDTO> getAlunos(){
        List<Aluno> listAlunos = repository.findAll();
        AlunoDTO.retornarDTO(listAlunos);
        return AlunoDTO.retornarDTO(listAlunos);
    }

    @PostMapping
    @ApiOperation(value="Persistir um novo aluno.")
    public ResponseEntity<AlunoDTO> persistirAlunos(@RequestBody AlunoRequest alunoRequest, UriComponentsBuilder uriComponentsBuilder){
        Aluno aluno = alunoRequest.converter(cursoRepository);
        URI uri = uriComponentsBuilder.path("/alunos/{ra}").buildAndExpand(aluno.getId()).toUri();
        return ResponseEntity.created(uri).body(new AlunoDTO(aluno));
    }

    @DeleteMapping
    @ApiOperation(value="Deletar um aluno.")
    public void deletarAluno(@RequestBody Aluno aluno){
        repository.delete(aluno);
    }

    @PutMapping("/updateNome")
    @ApiOperation(value="Atualizar o nome de um aluno pelo ID.")
    public void updateNomeAluno(@RequestParam Long idAluno, @RequestParam String novoNome){
        Aluno aluno = repository.findById(idAluno).orElseThrow(IdAlunoNãoExistenteException::new);
        repository.delete(aluno);
        aluno.setNome(novoNome);
        repository.save(aluno);
    }

    @PutMapping("/updateSobrenome")
    @ApiOperation(value="Atualizar o sobrenome de um aluno pelo ID.")
    public void updateSobrenomeAluno(@RequestParam Long idAluno, @RequestParam String novoSobrenome){
        Aluno aluno = repository.findById(idAluno).orElseThrow(IdAlunoNãoExistenteException::new);
        repository.delete(aluno);
        aluno.setNome(novoSobrenome);
        repository.save(aluno);
    }

    @GetMapping("/{ra}")
    @ApiOperation(value="Encontrar um aluno pelo ID.")
    public AlunoDTO acharPeloID(@PathVariable Long ra){
        Aluno aluno = repository.getById(ra);
        return new AlunoDTO(aluno);
    }
}
