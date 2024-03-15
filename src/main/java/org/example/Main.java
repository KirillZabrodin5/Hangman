package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Если вы хотите начать новую игру, нажмите '1' " + "\n" +
                                "Если вы хотите выйти из игры, нажмите '0'");

            int answerUser = 0;
            try{
                 answerUser = scanner.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Вы ввели не число. Запустите игру заново");
            }
            if (answerUser == 0) {
                break;
            } else if (answerUser == 1) {
                runGame();
            } else {
                System.out.println("Я не понял вашего ответа");
            }

        }

    }

    private static String[] createArrayWords() {
        String[] arrayWords = null;

        try(FileInputStream file = new FileInputStream("words.txt")) {
            byte[] bytes = file.readAllBytes();
            arrayWords = new String(bytes).split("\n");
        }
        catch (IOException ex) {
            System.out.println("Error when opening file");
        }

        return arrayWords;
    }

    private static String chooseRandomWord(String[] arS){
        Random random = new Random();
        int intRandom = random.nextInt(arS.length);
        return arS[intRandom-1].trim();
    }

    private static char[] createMaskWord(String word) {
        int len = word.length();
        char[] maskWord = new char[len];
        for (int i = 0; i < len; i++) {
            maskWord[i] = (char)95;
        }
        return maskWord;
    }

    public static void printArray(char[] maskWord) {
        for (char c : maskWord) {
            System.out.print(c);
        }
        System.out.println();
    }

    public static void printArray(char[] array, int end) {
        for (int i = 0; i < end; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    private static void runGame() {
        String[] arrayWords = createArrayWords();
        Scanner scanner = new Scanner(System.in);
        String word = chooseRandomWord(arrayWords);
        char[] maskWord = createMaskWord(word);
        int countReplace = 0;
        int len = word.length();
        char[] arrayErrors = new char[6];
        int idxArrayErrors = 0;
        System.out.println("Если вы решите закончить игру, просто введите 0 или 1");
        op: while (true) {
            if (countReplace == len) {
                System.out.println("Вы победили! Ура!");
                System.out.print("Было загадано слово: " + word + "\n");
                break;
            }

            switch (idxArrayErrors) {
                case 0:
                    Render.drawHangman(maskWord, arrayErrors, idxArrayErrors);
                    break;
                case 1:
                    Render.drawHangmanWithHead(maskWord, arrayErrors, idxArrayErrors);
                    break;
                case 2:
                    Render.drawHangmanWithHeadAndBody(maskWord, arrayErrors, idxArrayErrors);
                    break;
                case 3:
                    Render.drawHangmanWithHeadAndBodyAndLeftHand(maskWord, arrayErrors, idxArrayErrors);
                    break;
                case 4:
                    Render.drawHangmanWithHeadAndBodyAndHands(maskWord, arrayErrors, idxArrayErrors);
                    break;
                case 5:
                    Render.drawHangmanWithHeadAndBodyAndHandsAndLeftLeg(maskWord, arrayErrors, idxArrayErrors);
                    break;
                case 6:
                    Render.drawHangmanWithHuman(word);
                    break op;
            }
            char letter = scanner.next().charAt(0);

            if (letter == '0' | letter == '1') {
                System.out.println("Подтвердите свой выбор!");
                break;
            }
            System.out.println();
            boolean flag = false;
            for(int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == letter) {
                    maskWord[i] = letter;
                    countReplace++;
                    flag = true;
                }
            }

            if (flag == false) {
                arrayErrors[idxArrayErrors] = letter;
                idxArrayErrors++;
            }
        }
    }
}