package at.technikum;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Tic Tac Toe gestartet!");
        printBoard(game.getBoard().getGrid());

        while (true) {
            Player currentPlayer = game.getCurrentPlayer();
            System.out.println("Aktueller Spieler: " + currentPlayer.getMarker());

            System.out.print("Gib eine Zeile ein (0–2): ");
            int row = scanner.nextInt();

            System.out.print("Gib eine Spalte ein (0–2): ");
            int col = scanner.nextInt();

            boolean success = game.playTurn(row, col);

            if (!success) {
                System.out.println("Ungültiger Zug! Bitte erneut versuchen.");
                continue;
            }

            printBoard(game.getBoard().getGrid());

            if (game.getBoard().isFull()) {
                System.out.println("Das Spiel ist vorbei. Unentschieden!");
                break;
            }

            // Optional: Hier könntest du noch einen Gewinn-Check einbauen
        }

        scanner.close();
    }

    public static void printBoard(char[][] grid) {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(grid[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
}