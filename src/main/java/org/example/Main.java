package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

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

    private static List<String> createListWords() {
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

    private static String chooseRandomWord(List<String> arS){
        Random random = new Random();
        int intRandom = random.nextInt(arS.size());
        return arS.get(intRandom-1).trim();
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
        List<String> listWords = createListWords();

        Scanner scanner = new Scanner(System.in);

        String word = chooseRandomWord(listWords);
        int len = word.length();

        char[] maskWord = createMaskWord(word);

        int countReplace = 0;

        char[] arrayErrors = new char[6];
        int idxArrayErrors = 0;

        Map<Character, Boolean> alphabetErrors = new HashMap<>();
        for(int i = 1072; i < 1104; i++) {
            alphabetErrors.put((char)i, false); //false - значит, буква не использовалась, как ошибка
        }
        alphabetErrors.put((char)1105, false);

        op: while (true) {
            if (countReplace == len) {
                System.out.println("Вы победили! Ура!");
                System.out.println("Было загадано слово: " + word);
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
            int rus = letter;
            
            boolean isInWord = false;
            for(int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == letter) {
                    maskWord[i] = letter;
                    countReplace++;
                    isInWord = true;
                }
            }

            if (!((rus >= 1072 && rus <= 1103) || rus == 1105)) {
                isInWord = true;
            }

            if (!isInWord) {
                if (!alphabetErrors.get(letter)) {
                    arrayErrors[idxArrayErrors] = letter;
                    idxArrayErrors++;
                }
                alphabetErrors.put(letter, true);
            }
        }
    }
}