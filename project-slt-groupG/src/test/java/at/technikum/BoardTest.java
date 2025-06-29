package at.technikum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    @Test
    void testBoardIsInitiallyEmpty() {
        Board board = new Board();
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                assertTrue(board.isCellEmpty(i, j));
    }

    @Test
    void testPlaceValidMove() {
        Board board = new Board();
        assertTrue(board.place(1, 1, 'X'));
        assertFalse(board.isCellEmpty(1, 1));
    }

    @Test
    void testCannotPlaceOnOccupiedCell() {
        Board board = new Board();
        board.place(1, 1, 'X');
        assertFalse(board.place(1, 1, 'O'));
    }

    @Test
    void testOutOfBoundsPlacementFails() {
        Board board = new Board();
        assertFalse(board.place(-1, 0, 'X'));
        assertFalse(board.place(0, -1, 'X'));
        assertFalse(board.place(3, 0, 'X'));
        assertFalse(board.place(0, 3, 'X'));
    }

    @Test
    void testBoardIsFull() {
        Board board = new Board();
        char mark = 'X';
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board.place(i, j, mark);
        assertTrue(board.isFull());
    }
}