package br.com.letscode.controller;


import br.com.letscode.entities.TelefoneProfessor;
import br.com.letscode.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Telefones")
public class TelefoneProfessorController {

    private TelefoneRepository repository;
    @Autowired
    public TelefoneProfessorController(TelefoneRepository telefoneRepository){
        repository = telefoneRepository;
    }


    @GetMapping
    public Iterable<TelefoneProfessor> getTelefonesProfessor(){
        return repository.findAll();
    }
}
