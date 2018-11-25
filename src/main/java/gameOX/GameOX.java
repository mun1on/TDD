package gameOX;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameOX {
    private static List<String> nickNames = new ArrayList<>();
    private static List<Character> board = new ArrayList<>();
    private boolean winner = false;
    private String actualPlayer = "";

    public GameOX(String player1, String player2) {
        nickNames.add(player1);
        nickNames.add(player2);
        play();
    }


    public void play() {
        setStartedBoard();
        if (board.isEmpty())
            System.out.println("Grę zaczyna gracz " + nickNames.get(new Random().nextInt(2)));

        getInfoPosition();
        int i = 0;
        do {
            if (i == 9) {
                System.out.println("\n\t--------------\n\t---- DRAW ----\n\t--------------");
            } else {
                if (i % 2 == 0) {
                    setOXonBoard(nickNames.get(0));
                    actualPlayer = nickNames.get(0);
                } else {
                    setOXonBoard(nickNames.get(1));
                    actualPlayer = nickNames.get(1);
                }
                getActuallBoard();
                checkIfIsWinner();
                i++;
            }
        } while (!winner);

    }

    public void getWinnerMessage(int index_1, int index_2, int index_3) {
        if (actualPlayer.equals(nickNames.get(0))) System.out.println("Good job " + nickNames.get(0) + "! You won!");
        else System.out.println("Good job " + nickNames.get(1) + "! You won!");
        List<Character> result = new ArrayList<>();
        for (int j = 0; j < 9; j++) {
            if (j == index_1 || j == index_2 || j == index_3) {
                if (actualPlayer.equals(nickNames.get(0))) {
                    result.add(j, 'X');
                } else {
                    result.add(j, 'O');
                }
            } else {
                result.add(j, ' ');
            }
        }
        for (int j = 0; j < result.size(); j++) {
            if (j == 0)
                System.out.print(" ===\n|" + result.get(j));
            else if (j == 3 || j == 6)
                System.out.print("|" + result.get(j));
            else if (j == 2 || j == 5)
                System.out.println(result.get(j) + "|");
            else if (j != 8)
                System.out.print(result.get(j));
            else
                System.out.println(result.get(j) + "|\n ===");
        }
    }

    private void checkIf3InARow(int index1, int index2, int index3){
        if(board.get(index1).equals(board.get(index2)) && board.get(index2).equals(board.get(index3))){
            winner = true;
            getWinnerMessage(index1, index2, index3);
        }
    }

    public void checkIfIsWinner() {
        int count = 0;
        for (int i = 0; i < 9; i++) {
            if (board.get(i) != '_') count++;
        }
        if (count >= 5) {
            for (int i = 79; i < 89; i += 9) {
                if (board.get(0) == 'O' || board.get(0) == 'X') {
                    checkIf3InARow(0,1,2);
                    checkIf3InARow(0,3,6);
                    checkIf3InARow(0,4,8);
                }
                if (board.get(4) == 'O' || board.get(4) == 'X') {
                    checkIf3InARow(1,4,7);
                    checkIf3InARow(2,4,6);
                    checkIf3InARow(3,4,5);
                }
                if (board.get(8) == 'O' || board.get(8) == 'X') {
                    checkIf3InARow(2,5,8);
                    checkIf3InARow(6,7,8);
                }
            }
        }
    }

    public void setOXonBoard(String player) {
        System.out.print("Now player: " + player + "\nNumber: ");
        boolean result = false;
        do {
            int putIn = new Scanner(System.in).nextInt();
            int index = putIn - 1;
            if (putIn > 0 && putIn <= 9) {
                if (board.get(index).equals('_')) {
                    if (player.equals(nickNames.get(0))) {
                        board.set(index, 'X');
                        result = true;
                    } else {
                        board.set(index, 'O');
                        result = true;
                    }
                } else {
                    System.out.println("You can't place sign when there's a value!\nChoose again from 1-9.");
                }
            } else {
                System.out.println("Please choose number from 1 to 9. you pressed " + putIn + ", which is out of bound.");
            }
        } while (!result);
    }

    public void getActuallBoard() {
        int j = 1;
        for (int i = 0; i < 9; i++) {
            if (i == 0) {
                System.out.print("\t\t----------\n\t\t" + board.get(i) + " ");
            } else {
                if (j % 3 == 0 && i < 8) {
                    System.out.print(board.get(i) + "\n\t\t");
                } else if (j % 3 == 0) {
                    System.out.println(board.get(i) + "\n");
                } else {
                    System.out.print(board.get(i) + " ");
                }
            }
            j++;
        }
    }

    public void getInfoPosition() {
        System.out.println("Choose where you want to put the sign:\n[1] [2] [3]\n[4] [5] [6]\n[7] [8] [9]");
    }

    public void setStartedBoard() {
        for (int i = 0; i < 9; i++) {
            board.add(i, '_');
        }
    }
}
