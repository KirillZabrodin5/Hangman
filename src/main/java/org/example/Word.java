package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class Word {
    public List<String> createListWords() {
        List<String> listWords = null;

        try(FileInputStream file = new FileInputStream("words.txt")) {
            byte[] bytes = file.readAllBytes();
            listWords = List.of(new String(bytes).split("\n"));
        }
        catch (IOException ex) {
            System.out.println("Error when opening file");
        }

        return listWords;
    }

    public String chooseRandomWord(List<String> arS){
        Random random = new Random();
        int intRandom = random.nextInt(0, arS.size());
        return arS.get(intRandom).trim();
    }

    public char[] createMaskWord(String word) {
        int len = word.length();
        char[] maskWord = new char[len];
        for (int i = 0; i < len; i++) {
            maskWord[i] = (char)95;
        }
        return maskWord;
    }
}
