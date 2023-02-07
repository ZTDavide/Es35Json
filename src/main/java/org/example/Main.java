package org.example;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;

public class Main {
    private static String readFromFile(String path) throws IOException {
        byte[] content = Files.readAllBytes(Paths.get(path));
        return new String(content);
    }

    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();
        String json = readFromFile("src/main/resources/gare.json");
        Gara[] gara = gson.fromJson(json, Gara[].class);

        ArrayList <Squadra> squadre = new ArrayList<>();
        boolean presente = false;

        for (Gara g : gara) {

            System.out.println(g);

            presente = false;

            for(Squadra sq : squadre){

                if(sq.nome.equals(g.getSquadra())) {

                    sq.punteggio = sq.punteggio + g.getPunteggio_difficolta() + g.getPunteggio_percorso();
                    sq.tempo = sq.tempo + g.getTempo();
                    presente = true;

                }
            }

            if(!presente)
                squadre.add(new Squadra(g.getSquadra(), g.getPunteggio_difficolta()+g.getPunteggio_percorso(), g.getTempo()));

        }

        for(Squadra sq : squadre){

            System.out.println("Nome: " + sq.nome);
            System.out.println("Punteggio: " + sq.punteggio);
            System.out.println("Tempo: " + sq.tempo);

        }

    }
}