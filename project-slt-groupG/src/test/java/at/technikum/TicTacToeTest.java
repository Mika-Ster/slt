package at.technikum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {
    @Test
    void testInitialPlayerIsX() {
        TicTacToe game = new TicTacToe();
        assertEquals('X', game.getCurrentPlayer().getMarker());
    }

    @Test
    void testPlayerSwitchesAfterValidMove() {
        TicTacToe game = new TicTacToe();
        game.playTurn(0, 0);
        assertEquals('O', game.getCurrentPlayer().getMarker());
    }

    @Test
    void testPlayOnOccupiedCellReturnsFalse() {
        TicTacToe game = new TicTacToe();
        game.playTurn(1, 1);
        assertFalse(game.playTurn(1, 1)); // zweite Belegung scheitert
    }

    @Test
    void testPlayOnInvalidCellReturnsFalse() {
        TicTacToe game = new TicTacToe();
        assertFalse(game.playTurn(-1, 0));
        assertFalse(game.playTurn(3, 3));
    }
}