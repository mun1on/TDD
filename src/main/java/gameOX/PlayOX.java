package gameOX;

import java.util.Scanner;

public class PlayOX {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj nazwę pierwszego gracza: ");
        String player1 = scanner.next();
        System.out.print("Podaj nazwę drugiego gracza: ");
        String player2 = scanner.next();
        new GameOX(player1, player2);
    }
}
