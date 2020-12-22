package checker;

/**
 * GameChecker class used to check current state of the board and determine if a winner has been decided
 */
public class GameChecker {
    /**
     * 2d array to store current board state
     */
    char[][] board;

    /**
     * Constructor for board
     * @param gameState     current board state passed into the class
     */
    public GameChecker(char[][] gameState) {
        board = gameState;
    }

    /**
     * Function to check the outcome of the game
     * @return              string outlining the game outcome
     */
    public String isGameOver() {
        char winner = gameStateChecker();

        if (winner == 'X') {
            return "X has won!";
        } else if (winner == 'O') {
            return "O has won!";
        } else {
            return "Game is undecided...";
        }
    }

    /**
     * Function to check if any of the rows have a winning condition. When checking, we add 1 if 'X' is
     * encountered, add -1 if 'O' is encountered and break out of loop if neither
     * @return              returns winner char ('X' or 'O') and if undecided returns 'U'
     */
    public char checkRows() {
        for (int i = 0; i < 3; i++) {
            // set temp total for each row
            int tempTotal = 0;
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 'X') tempTotal++;
                else if (board[i][j] == 'O') tempTotal--;
                else break;
            }
            if (tempTotal == 3) return 'X';
            else if (tempTotal == -3) return 'O';
        }

        return 'U';
    }

    /**
     * Function to check if any of the columns have a winning condition. When checking, we add 1 if 'X' is
     * encountered, add -1 if 'O' is encountered and break out of loop if neither
     * @return              returns winner char ('X' or 'O') and if undecided returns 'U'
     */
    public char checkCols() {
        for (int i = 0; i < 3; i++) {
            // set temp total for each row
            int tempTotal = 0;
            for (int j = 0; j < 3; j++) {
                if (board[j][i] == 'X') tempTotal++;
                else if (board[j][i] == 'O') tempTotal--;
                else break;
            }
            if (tempTotal == 3) return 'X';
            else if (tempTotal == -3) return 'O';
        }

        return 'U';
    }

    /**
     * Function to check if any of the diagonals have a winning condition. When checking, we add 1 if 'X' is
     * encountered, add -1 if 'O' is encountered and break out of loop if neither
     * @return              returns winner char ('X' or 'O') and if undecided returns 'U'
     */
    public char checkDiags() {
        int tempTotal1 = 0;
        for (int i = 0; i < 3; i++) {
            if (board[i][i] == 'X') tempTotal1++;
            else if (board[i][i] == 'O') tempTotal1--;
            else break;
        }
        if (tempTotal1 == 3) return 'X';
        else if (tempTotal1 == -3) return 'O';

        int tempTotal2 = 0;
        for (int j = 0; j < 3; j++) {
            if (board[j][2-j] == 'X') tempTotal2++;
            else if (board[j][2-j] == 'O') tempTotal2--;
            else break;
        }
        if (tempTotal2 == 3) return 'X';
        else if (tempTotal2 == -3) return 'O';

        return 'U';
    }

    /**
     * Function that checks rows, columns and diagonals.
     * @return              returns winner char ('X' or 'O') and if undecided returns 'U'
     */
    public char gameStateChecker() {
        char rows = checkRows();
        if (rows == 'X') return 'X';
        if (rows == 'O') return 'O';

        char cols = checkCols();
        if (cols == 'X') return 'X';
        if (cols == 'O') return 'O';

        char diags = checkDiags();
        if (diags == 'X') return 'X';
        if (diags == 'O') return 'O';

        return 'U';
    }

}
