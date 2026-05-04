import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static char[] board = {
            '0',
            ' ', ' ', ' ',
            ' ', ' ', ' ',
            ' ', ' ', ' '
    };

    static Scanner sc = new Scanner(System.in);

    // Display board
    static void displayBoard() {

        System.out.println();

        System.out.println(" " + board[1] + " | " + board[2] + " | " + board[3]);
        System.out.println("---|---|---");
        System.out.println(" " + board[4] + " | " + board[5] + " | " + board[6]);
        System.out.println("---|---|---");
        System.out.println(" " + board[7] + " | " + board[8] + " | " + board[9]);

        System.out.println();
    }

    // Check valid move
    static boolean isValidMove(int position) {
        return board[position] == ' ';
    }

    // Player move
    static void playerMove() {

        int position;

        do {
            System.out.print("Enter position (1-9): ");
            position = sc.nextInt();

        } while (position < 1 || position > 9 || !isValidMove(position));

        board[position] = 'X';
    }

    // Computer move
    static void computerMove() {

        Random random = new Random();
        int position;

        do {
            position = random.nextInt(9) + 1;

        } while (!isValidMove(position));

        board[position] = 'O';

        System.out.println("Computer placed O at position " + position);
    }

    // Check win
    static boolean checkWin(char symbol) {

        return
                (board[1] == symbol && board[2] == symbol && board[3] == symbol) ||
                (board[4] == symbol && board[5] == symbol && board[6] == symbol) ||
                (board[7] == symbol && board[8] == symbol && board[9] == symbol) ||

                (board[1] == symbol && board[4] == symbol && board[7] == symbol) ||
                (board[2] == symbol && board[5] == symbol && board[8] == symbol) ||
                (board[3] == symbol && board[6] == symbol && board[9] == symbol) ||

                (board[1] == symbol && board[5] == symbol && board[9] == symbol) ||
                (board[3] == symbol && board[5] == symbol && board[7] == symbol);
    }

    // Check draw
    static boolean checkDraw() {

        for (int i = 1; i <= 9; i++) {
            if (board[i] == ' ') {
                return false;
            }
        }

        return true;
    }

    // Main method
    public static void main(String[] args) {

        boolean gameOver = false;

        System.out.println("=== TIC TAC TOE ===");

        displayBoard();

        // Continuous game loop
        while (!gameOver) {

            // Player turn
            playerMove();
            displayBoard();

            if (checkWin('X')) {
                System.out.println("Player Wins!");
                gameOver = true;
                break;
            }

            if (checkDraw()) {
                System.out.println("Game Draw!");
                gameOver = true;
                break;
            }

            // Computer turn
            computerMove();
            displayBoard();

            if (checkWin('O')) {
                System.out.println("Computer Wins!");
                gameOver = true;
                break;
            }

            if (checkDraw()) {
                System.out.println("Game Draw!");
                gameOver = true;
            }
        }
    }
}
