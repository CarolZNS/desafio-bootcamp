package com.example.restapiczn.controller;

import com.example.restapiczn.entities.JogadoresEntity;
import com.example.restapiczn.repositories.JogadoresRepository;
import com.example.restapiczn.services.JogadoresServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.util.*;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class JogadoresController {

    @Autowired
    JogadoresServices jogadoresServices;

    @GetMapping("/times")
    public Map<String, List<String>> buscarJogadores() {
        return jogadoresServices.buscarJogadores();
    }

    @PostMapping("/jogador")
    public void inserirJogador(@RequestBody JogadoresEntity jogador){
        if(jogador.getId() == null){
            jogadoresServices.inserirJogador(jogador);
        }
    }

    @DeleteMapping("/jogador/all")
    public void apagarTudo(){
        jogadoresServices.apagarTudo();
    }
}
