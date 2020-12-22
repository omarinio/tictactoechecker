package checker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Class used for testing GameChecker class. Players represented by chars 'X' and 'O' while empty spaces are
 * represented by 'U'.
 */
public class GameCheckerTest {
    GameChecker gameState;

    @Test
    public void winnerIsXRow() {
        char[][] temp = {
                {'X', 'X', 'X'},
                {'X', 'O', 'U'},
                {'O', 'U', 'O'}
        };
        gameState = new GameChecker(temp);

        assertEquals(gameState.isGameOver(), "X has won!");
    }

    @Test
    public void winnerIsXCol() {
        char[][] temp = {
                {'X', 'O', 'X'},
                {'X', 'O', 'U'},
                {'X', 'U', 'O'}
        };
        gameState = new GameChecker(temp);

        assertEquals(gameState.isGameOver(), "X has won!");
    }

    @Test
    public void winnerIsXDiag() {
        char[][] temp = {
                {'X', 'O', 'X'},
                {'O', 'X', 'U'},
                {'O', 'U', 'X'}
        };
        gameState = new GameChecker(temp);

        assertEquals(gameState.isGameOver(), "X has won!");
    }

    @Test
    public void winnerIsORow() {
        char[][] temp = {
                {'U', 'X', 'X'},
                {'O', 'O', 'O'},
                {'X', 'U', 'X'}
        };
        gameState = new GameChecker(temp);

        assertEquals(gameState.isGameOver(), "O has won!");
    }

    @Test
    public void winnerIsOCol() {
        char[][] temp = {
                {'X', 'O', 'X'},
                {'X', 'O', 'U'},
                {'U', 'O', 'X'}
        };
        gameState = new GameChecker(temp);

        assertEquals(gameState.isGameOver(), "O has won!");
    }

    @Test
    public void winnerIsODiag() {
        char[][] temp = {
                {'X', 'O', 'O'},
                {'X', 'O', 'X'},
                {'O', 'U', 'X'}
        };
        gameState = new GameChecker(temp);

        assertEquals(gameState.isGameOver(), "O has won!");
    }

    @Test
    public void undecidedGame() {
        char[][] temp = {
                {'U', 'O', 'U'},
                {'X', 'X', 'O'},
                {'U', 'U', 'U'}
        };
        gameState = new GameChecker(temp);

        assertEquals(gameState.isGameOver(), "Game is undecided...");
    }

    @Test
    public void drawGame() {
        char[][] temp = {
                {'O', 'X', 'O'},
                {'X', 'X', 'O'},
                {'X', 'O', 'X'}
        };
        gameState = new GameChecker(temp);

        assertEquals(gameState.isGameOver(), "Game is undecided...");
    }
}
