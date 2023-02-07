package org.example;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.*;

public class Main {
    private static String readFromFile(String path) throws IOException {
        byte[] content = Files.readAllBytes(Paths.get(path));
        return new String(content);
    }

    public static void main(String[] args) throws IOException {
        System.out.println(readFromFile("src/main/resources/gare.json"));
        Gson gson = new Gson();
    }
}