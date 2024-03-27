package game;

import board.Board;
import player.Player;

public class Game {
    Board board;
    Player player;

    public Game(Board board, Player player) {
        this.board = board;
        this.player = player;
    }

    public void play() {
        solvesudoku(0, 0);
    }

    private void solvesudoku(int row, int col) {
        if (row == this.board.size) {
            board.printboard();
            return;
        }

        int nrow, ncol;

        if (col == board.size - 1) {
            nrow = row + 1;
            ncol = 0; 
        } else {
            nrow = row;
            ncol = col + 1;
        }

        if (this.board.matrix[row][col] != 0) {
            solvesudoku(nrow, ncol);
        } else {
            for (int i = 1; i <= 9; i++) {
                if (validNumber(this.board.matrix, row, col, i)) {
                    this.board.matrix[row][col] = i;
                    solvesudoku(nrow, ncol);
                    this.board.matrix[row][col] = 0;
                }
            }
        }
    }

    private boolean validNumber(int[][] matrix, int row, int col, int val) {
        // Row-wise:
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[row][i] == val) {
                return false;
            }
        }

        // Column-wise:
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][col] == val) {
                return false;
            }
        }

        int temprow = row / 3 * 3;
        int tempcol = col / 3 * 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[temprow + i][tempcol + j] == val) {
                    return false;
                }
            }
        }

        return true;
    }
}
