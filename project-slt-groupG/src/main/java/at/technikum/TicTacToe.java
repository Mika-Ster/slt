package at.technikum;

public class TicTacToe {
    private final Board board = new Board();
    private Player currentPlayer = new Player('X');

    public boolean playTurn(int row, int col) {
        if (board.place(row, col, currentPlayer.getMarker())) {
            switchPlayer();
            return true;
        }
        return false;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    private void switchPlayer() {
        char nextMarker = currentPlayer.getMarker() == 'X' ? 'O' : 'X';
        currentPlayer = new Player(nextMarker);
    }

    public Board getBoard() {
        return board;
    }
}
