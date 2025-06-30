package at.technikum;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean run = true;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Tic Tac Toe gestartet!");

        while (run) {
            TicTacToe game = new TicTacToe();
            game.getBoard().print();
            while (getGameState(game)) {

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

                game.getBoard().print();
            }

            System.out.println("Möchtest du noch eine Runde spielen? (Ja/Nein)");
            String answer = scanner.next();

            if(!answer.toLowerCase().contains("j")){
                run = false;
                System.out.println(":(");
            }
        }

        System.out.println("Vielen Dank, bis zum nächsten mal!");

        scanner.close();
    }

    public static boolean getGameState(TicTacToe game){
        if (game.hasWinner()) {
            System.out.println("Spiel beendet! Spieler " + game.getCurrentPlayer().getMarker() + " hat gewonnen!");
            System.out.println("--------------------------->");
            return false;
        } else if (game.isDraw()) {
            System.out.println("Unentschieden! Das Spielfeld ist voll.");
            System.out.println("--------------------------->");
            return false;
        }else{
            return true;
        }
    }
}