package com.example.restapiczn.registry;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class JogadoresRegistry {
    public Map<String, List<String>> agruparPorTime(List<String> nomesDosJogadores) {

        Map<String, List<String>> times = new HashMap<>();
        for (String player : nomesDosJogadores) {
            String[] nomeDividido = player.split(" ");
            String sobrenome = nomeDividido[nomeDividido.length-1].toUpperCase();
            String key = sobrenome.substring(0,1);

            boolean adicionado = false;
            int count = 1;

            while (!adicionado) {
                String uniqueKey = key + (count > 1 ? count : "");
                if (!times.containsKey(uniqueKey)) {
                    List<String> novoTime = new ArrayList<>();
                    novoTime.add(player);
                    times.put(uniqueKey, novoTime);
                    adicionado = true;
                } else {
                    List<String> novoTime = times.get(uniqueKey);
                    boolean duplicado = false;
                    for (String p : novoTime) {
                        if (p.toUpperCase().endsWith(" " + sobrenome)) {
                            duplicado = true;
                            break;
                        }
                    }
                    if (!duplicado) {
                        novoTime.add(player);
                        adicionado = true;
                    } else {
                        count++;
                    }
                }
            }
        }
        return times;
    }
}
