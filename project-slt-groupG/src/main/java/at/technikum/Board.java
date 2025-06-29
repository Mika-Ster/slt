package at.technikum;

public class Board {
    private final char[][] grid = new char[3][3];

    public Board() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                grid[i][j] = ' ';
    }

    public boolean place(int row, int col, char marker) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3) return false;
        if (grid[row][col] != ' ') return false;
        grid[row][col] = marker;
        return true;
    }

    public boolean isCellEmpty(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && grid[row][col] == ' ';
    }

    public boolean isFull() {
        for (char[] row : grid)
            for (char cell : row)
                if (cell == ' ') return false;
        return true;
    }

    public char[][] getGrid() {
        return grid;
    }
}
