package at.technikum;

public class TicTacToe {

    private final Player player1 = new Player('X');
    private final Player player2 = new Player('O');
    private Player currentPlayer = player1;
    private final Board board = new Board();

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Board getBoard() {
        return board;
    }

    public boolean playTurn(int row, int col) {
        boolean success = board.place(row, col, currentPlayer.getMarker());
        if (success) {
            if(Main.getGameState(this)){
                switchPlayer();
            }
        }

        return success;
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public boolean hasWinner() {
        char[][] grid = board.getGrid();
        char lastMarker = currentPlayer.getMarker();

        // Zeilen & Spalten prüfen
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] == lastMarker && grid[i][1] == lastMarker && grid[i][2] == lastMarker) return true;
            if (grid[0][i] == lastMarker && grid[1][i] == lastMarker && grid[2][i] == lastMarker) return true;
        }

        // Diagonalen prüfen
        if (grid[0][0] == lastMarker && grid[1][1] == lastMarker && grid[2][2] == lastMarker) return true;
        if (grid[0][2] == lastMarker && grid[1][1] == lastMarker && grid[2][0] == lastMarker) return true;

        return false;
    }

    public boolean isDraw() {
        return board.isFull() && !hasWinner();
    }

    public void showBoard() {
        board.print();
    }
}