package com.example.restapiczn.services;

import com.example.restapiczn.entities.JogadoresEntity;
import com.example.restapiczn.registry.JogadoresRegistry;
import com.example.restapiczn.repositories.JogadoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JogadoresServices {

    @Autowired
    JogadoresRepository jogadoresRepository;
    @Autowired
    JogadoresRegistry jogadoresRegistry;

    public Map<String, List<String>> buscarJogadores(){
        List<JogadoresEntity> resposta = jogadoresRepository.findAll();
        List<String> nomesDosJogadores = new ArrayList<>();
        for(JogadoresEntity nome : resposta){
            String nomeCompleto = nome.getNome();
            nomesDosJogadores.add(nomeCompleto);
        }
        return jogadoresRegistry.agruparPorTime(nomesDosJogadores);
    }

    public void inserirJogador(JogadoresEntity jogador){
        jogadoresRepository.save(jogador);
    }

    public void apagarTudo(){
        jogadoresRepository.deleteAll();
    }
}
