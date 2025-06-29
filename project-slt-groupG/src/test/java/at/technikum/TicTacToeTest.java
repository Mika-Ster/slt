package at.technikum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {

    // === US-001 ===

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

    // === US-003 ===

    @Test
    void testWinByRow() {
        TicTacToe game = new TicTacToe();
        game.playTurn(0, 0); // X
        game.playTurn(1, 0); // O
        game.playTurn(0, 1); // X
        game.playTurn(1, 1); // O
        game.playTurn(0, 2); // X gewinnt
        assertTrue(game.hasWinner());
    }

    @Test
    void testWinByColumn() {
        TicTacToe game = new TicTacToe();
        game.playTurn(0, 0); // X
        game.playTurn(0, 1); // O
        game.playTurn(1, 0); // X
        game.playTurn(1, 1); // O
        game.playTurn(2, 0); // X gewinnt
        assertTrue(game.hasWinner());
    }

    @Test
    void testWinByDiagonal() {
        TicTacToe game = new TicTacToe();
        game.playTurn(0, 0); // X
        game.playTurn(0, 1); // O
        game.playTurn(1, 1); // X
        game.playTurn(0, 2); // O
        game.playTurn(2, 2); // X gewinnt
        assertTrue(game.hasWinner());
    }

    @Test
    void testDrawCondition() {
        TicTacToe game = new TicTacToe();
        game.playTurn(0, 0); // X
        game.playTurn(0, 1); // O
        game.playTurn(0, 2); // X
        game.playTurn(1, 1); // O
        game.playTurn(1, 0); // X
        game.playTurn(1, 2); // O
        game.playTurn(2, 1); // X
        game.playTurn(2, 0); // O
        game.playTurn(2, 2); // X
        assertFalse(game.hasWinner());
        assertTrue(game.isDraw());
    }

    @Test
    void testNoWinOrDrawWhenGameNotFinished() {
        TicTacToe game = new TicTacToe();
        game.playTurn(0, 0);
        game.playTurn(1, 1);
        assertFalse(game.hasWinner());
        assertFalse(game.isDraw());
    }
}
