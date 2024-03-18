package org.example;

import java.util.*;

public class Game {
    private static Scanner scanner = new Scanner(System.in);
    public static void startGameLoop() {
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

    private static void runGame() {
        Word words = new Word();
        List<String> listWords = words.createListWords();

        String word = words.chooseRandomWord(listWords);
        int len = word.length();

        char[] maskWord = words.createMaskWord(word);

        int countReplace = 0;

        char[] arrayErrors = new char[6];
        int idxArrayErrors = 0;

        Map<Character, Boolean> alphabet = new HashMap<>();
        for(int i = 1072; i < 1104; i++) {
            alphabet.put((char)i, false); //false - значит, буква не использовалась, как ошибка
        }
        alphabet.put((char)1105, false);

        Set<Character> setLetterInWord = new HashSet<>();

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
                if (!setLetterInWord.contains(letter) & word.charAt(i) == letter) {
                    maskWord[i] = letter;
                    countReplace++;
                    isInWord = true;
                }
            }
            if (isInWord) {
                setLetterInWord.add(letter);
            }

            if (!((rus >= 1072 && rus <= 1103) || rus == 1105)) {
                isInWord = true;
            }

            if (!isInWord & !setLetterInWord.contains(letter)) {
                if (!alphabet.get(letter)) {
                    arrayErrors[idxArrayErrors] = letter;
                    idxArrayErrors++;
                }
                alphabet.put(letter, true);
            }
        }
    }
}
