package org.example;

public class Render {
    public static void drawHangman(char[] maskWord, char[] arrayErrors, int idxArrayErrors) {
        //виселица без человека:
        System.out.print("   " + (char)95 + (char)95 + (char)95 + (char)95 + (char)95 + (char)95 + "\n");
        System.out.println("  "+(char)124 + "      " + (char)124);
        System.out.println("         " + (char)124);
        System.out.println("         " + (char)124);
        System.out.println("         " + (char)124);
        System.out.print("         " + (char)124 + "              Слово: ");
        Main.printArray(maskWord);
        System.out.print("         " + (char)124 + "              Ошибки (" + idxArrayErrors + "): ");
        Main.printArray(arrayErrors, idxArrayErrors);
        System.out.print("  " + (char)45 + (char)45 + (char)45 + (char)45 + (char)45 + (char)45 + (char)45 + "               Введите одну мальнекую русскую букву: ");
    }

    public static void drawHangmanWithHead(char[] maskWord, char[] arrayErrors, int idxArrayErrors) {
        //виселица с головой:
        System.out.print("   " + (char)95 + (char)95 + (char)95 + (char)95 + (char)95 + (char)95 + "\n");
        System.out.println("  " + (char)124 + "      " + (char)124);
        System.out.println("  " + (char)42 + "      " + (char)124);
        System.out.println("         " + (char)124);
        System.out.println("         " + (char)124);
        System.out.print("         " + (char)124 + "              Слово: ");
        Main.printArray(maskWord);
        System.out.print("         " + (char)124 + "              Ошибки (" + idxArrayErrors + "): ");
        Main.printArray(arrayErrors, idxArrayErrors);
        System.out.print("  " + (char)45 + (char)45 + (char)45 + (char)45 + (char)45 + (char)45 + (char)45  + "               Введите одну мальнекую русскую букву: ");
    }

    public static void drawHangmanWithHeadAndBody(char[] maskWord, char[] arrayErrors, int idxArrayErrors) {
        //виселица с туловищем и головой:
        System.out.print("   " + (char)95 + (char)95 + (char)95 + (char)95 + (char)95 + (char)95 + "\n");
        System.out.println("  " + (char)124 + "      " + (char)124);
        System.out.println("  " + (char)42 + "      " + (char)124);
        System.out.println("  " + (char)124 + "      " + (char)124);
        System.out.println("  " + (char)124 + "      " + (char)124);
        System.out.print("  " + (char)124 + "      " + (char)124 + "              Слово: ");
        Main.printArray(maskWord);
        System.out.print("         " + (char)124 + "              Ошибки (" + idxArrayErrors + "): ");
        Main.printArray(arrayErrors, idxArrayErrors);
        System.out.print("  " + (char)45 + (char)45 + (char)45 + (char)45 + (char)45 + (char)45 + (char)45  + "               Введите одну мальнекую русскую букву: ");
    }

    public static void drawHangmanWithHeadAndBodyAndLeftHand(char[] maskWord, char[] arrayErrors, int idxArrayErrors) {
        //виселица с туловищем и головой и левой рукой:
        System.out.print("   " + (char)95 + (char)95 + (char)95 + (char)95 + (char)95 + (char)95 + "\n");
        System.out.println("  " + (char)124 + "      " + (char)124);
        System.out.println("  " + (char)42 + "      " + (char)124);
        System.out.println(" "+ (char)92 + "" + (char)124 + "      " + (char)124);
        System.out.println("  " + (char)124 + "      " + (char)124);
        System.out.print("  " + (char)124 + "      " + (char)124 + "              Слово: ");
        Main.printArray(maskWord);
        System.out.print("         " + (char)124 + "              Ошибки (" + idxArrayErrors + "): ");
        Main.printArray(arrayErrors, idxArrayErrors);
        System.out.print("  " + (char)45 + (char)45 + (char)45 + (char)45 + (char)45 + (char)45 + (char)45 + "               Введите одну мальнекую русскую букву: ");
    }

    public static void drawHangmanWithHeadAndBodyAndHands(char[] maskWord, char[] arrayErrors, int idxArrayErrors) {
        //виселица с туловищем и головой и двумя руками:
        System.out.print("   " + (char)95 + (char)95 + (char)95 + (char)95 + (char)95 + (char)95 + "\n");
        System.out.println("  " + (char)124 + "      " + (char)124);
        System.out.println("  " + (char)42 + "      " + (char)124);
        System.out.println(" " + (char)92 + (char)124 + (char)47 + "     " + (char)124);
        System.out.println("  " + (char)124 + "      " + (char)124);
        System.out.print("  " + (char)124 + "      " + (char)124 + "              Слово: ");
        Main.printArray(maskWord);
        System.out.print("         " + (char)124 + "              Ошибки (" + idxArrayErrors + "): ");
        Main.printArray(arrayErrors, idxArrayErrors);
        System.out.print("  " + (char)45 + (char)45 + (char)45 + (char)45 + (char)45 + (char)45 + (char)45  + "               Введите одну мальнекую русскую букву: ");
    }

    public static void drawHangmanWithHeadAndBodyAndHandsAndLeftLeg(char[] maskWord, char[] arrayErrors, int idxArrayErrors) {
        //виселица с туловищем, головой, двумя руками и левой ногой:
        System.out.print("   " + (char)95 + (char)95 + (char)95 + (char)95 + (char)95 + (char)95 + "\n");
        System.out.println("  " + (char)124 + "      " + (char)124);
        System.out.println("  " + (char)42 + "      " + (char)124);
        System.out.println(" " + (char)92 + (char)124 + (char)47 + "     " + (char)124);
        System.out.println("  " + (char)124 + "      " + (char)124);
        System.out.print(" " + (char)47 + (char)124 + "      " + (char)124 + "              Слово: ");
        Main.printArray(maskWord);
        System.out.print("         " + (char)124 + "              Ошибки (" + idxArrayErrors + "): ");
        Main.printArray(arrayErrors, idxArrayErrors);
        System.out.print("  " + (char)45 + (char)45 + (char)45 + (char)45 + (char)45 + (char)45 + (char)45  + "               Введите одну мальнекую русскую букву: ");
    }

    public static void drawHangmanWithHuman(String word) {
        //виселица с челиком:
        System.out.println("   " + (char)95 + (char)95 + (char)95 + (char)95 + (char)95 + (char)95);
        System.out.println("  " + (char)124 + "      " + (char)124);
        System.out.println("  " + (char)42 + "      " + (char)124);
        System.out.println(" " + (char)92 + (char)124 + (char)47 + "     " + (char)124);
        System.out.println("  " + (char)124 + "      " + (char)124);
        System.out.println(" " + (char)47 + (char)124 + (char)92 + "     " + (char)124);
        System.out.println("         " + (char)124 + "              Вы проиграли(((");
        System.out.println("  " + (char)45 + (char)45 + (char)45 + (char)45 + (char)45 + (char)45 + (char)45 + "               Было загадано слово: " + word);

    }
}
