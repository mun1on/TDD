package romeToLatin;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RzymskieNaArabskie {

    private Map<Character, Integer> romeNumbers;

    public RzymskieNaArabskie() {
        setMap();
    }

    private void setMap() {
        romeNumbers = new HashMap<>();
        romeNumbers.put('I', 1);
        romeNumbers.put('V', 5);
        romeNumbers.put('X', 10);
        romeNumbers.put('L', 50);
        romeNumbers.put('C', 100);
        romeNumbers.put('D', 500);
        romeNumbers.put('M', 1000);
    }

    private String numberFromUser() {
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    public int roman2arabic(String inputNumber) {
        if (inputNumber == null || inputNumber.trim().isEmpty())
            return 0;

//        long numberOfInvalidChars = inputNumber.chars()
//                .mapToObj(c->(char)c)
//                .filter(c->romeNumbers.containsKey(c))
//                .count();
//        System.out.println(numberOfInvalidChars);
//        if(numberOfInvalidChars > 0)
//            return 0;
        char[] romanInputChar = inputNumber.toUpperCase().toCharArray();
        int i = 0;
        int sum = 0;
        while (i < romanInputChar.length) {
            if (i == romanInputChar.length - 1) {
                sum += romeNumbers.get(romanInputChar[i]);
            } else {
                int firstNumber = romeNumbers.get(romanInputChar[i]);
                int secondNumber = romeNumbers.get(romanInputChar[i + 1]);

                if (firstNumber < secondNumber)
                    sum += secondNumber - firstNumber;
                else
                    sum += firstNumber + secondNumber;
            }

            i = i + 2;
        }
        return sum;
    }

    public static void main(String[] args) {
        RzymskieNaArabskie r2a = new RzymskieNaArabskie();
        System.out.println("Wynik: " + r2a.roman2arabic(r2a.numberFromUser()));
    }
}


