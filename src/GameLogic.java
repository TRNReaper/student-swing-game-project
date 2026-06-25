import java.util.ArrayList;
import java.util.Random;

public class GameLogic {
    private char[] board;

    public GameLogic() {
        board = new char[9];
        resetBoard();
    }

    public void resetBoard() {
        for (int i = 0; i < board.length; i++) {
            board[i] = ' ';
        }
    }

    public boolean makeMove(int index, char symbol) {
        if (index < 0 || index >= 9) {
            return false;
        }
        if (board[index] != ' ') {
            return false;
        }
        board[index] = symbol;
        return true;
    }

    public boolean checkWinner(char symbol) {
        int[][] patterns = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Rows
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Columns
                {0, 4, 8}, {2, 4, 6}             // Diagonals
        };

        for (int i = 0; i < patterns.length; i++) {
            int a = patterns[i][0];
            int b = patterns[i][1];
            int c = patterns[i][2];
            if (board[a] == symbol && board[b] == symbol && board[c] == symbol) {
                return true;
            }
        }
        return false;
    }

    public boolean isDraw() {
        for (int i = 0; i < board.length; i++) {
            if (board[i] == ' ') {
                return false;
            }
        }
        return true;
    }

    public int computerMove() {
        // utk nemuin empty cell
        ArrayList<Integer> emptyCells = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            if (board[i] == ' ') {
                emptyCells.add(i);
            }
        }

        // Return -1 klo board nya penuh
        if (emptyCells.isEmpty()) {
            return -1;
        }

        // Select a random empty cell
        Random rand = new Random();
        int randomIndex = rand.nextInt(emptyCells.size());
        return emptyCells.get(randomIndex);
    }

    public char[] getBoard() {
        return board;
    }


}
