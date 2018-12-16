package szyfrcezara;

public class SzyfrCezara {

    private static void hasUppercaseAlphabet(StringBuilder code) {
        String test = code.toString();
        test = test.replaceAll("\\s", "");
        for (int i = 0; i < test.length(); i++) {
            if (Character.isLowerCase(test.charAt(i))) {
                System.out.print("\n" + "Wiadomosc zawiera male litery" + "\n" + "Zmien je na duze!" + "\n");
                System.exit(0);
            } else if (test.charAt(i) < 65 || test.charAt(i) > 90) {
                System.out.println("\n" + "Wiadomość zawiera znaki numeryczne typograficzne lub interpunkcyjne lub inne nieprawidłowe!" + "\n" + "W wiadomosci moga wystepowac tylko duze litery i spacja" + "\n");
                System.exit(0);
            }
        }
        System.out.println("\n" + "Wiadomosc spelnia wymagania");
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
    }

    private static void shiftIsCorrect(int shift) {
        if (shift >= 26) {
            System.out.print("\n" + "Za duże przesunięcie" + "\n");
            System.exit(0);
        } else if (shift <= 0) {
            System.out.println("Przesuniecie musi być wieksze od zera!");
            System.exit(0);
        }

    }

    private static void encrypt(StringBuilder code, int shift) {
        for (int i = 0; i < code.length(); i++) {
            int index = (int) code.charAt(i);
            if (index == 32) {
            } else if (index > 90 - shift) {
                index = 65 + (shift - (91 - index));
            } else {
                index += shift;
            }
            code.setCharAt(i, (char) index);
        }
        System.out.println("\n" + "Wiadomosc po zakodowaniu");
        String result = code.toString();
        System.out.println(result);
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
    }

    public static void main(String[] args) {
        System.out.println("Alfabet, litery dozwolne do użycia: " + "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
        System.out.print("\n" + "Podaj wiadomosc do zakodowania: ");
        StringBuilder code = new StringBuilder("TEXT TO ENCRYPT AZ");
        System.out.println(code.toString());
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
        hasUppercaseAlphabet(code);
        int shift = 4;
        System.out.println("\n" + "Przesuniecie: " + shift);
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
        shiftIsCorrect(shift);
        encrypt(code, shift);

    }
}
