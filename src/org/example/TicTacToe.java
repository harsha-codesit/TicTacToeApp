import java.util.Scanner;

public class TicTacToe {

    static char[] board = {
            '0',
            ' ', ' ', ' ',
            ' ', ' ', ' ',
            ' ', ' ', ' '
    };

    static Scanner sc = new Scanner(System.in);

    // Display Board
    static void displayBoard() {

        System.out.println();

        System.out.println(" " + board[1] + " | " + board[2] + " | " + board[3]);
        System.out.println("---|---|---");
        System.out.println(" " + board[4] + " | " + board[5] + " | " + board[6]);
        System.out.println("---|---|---");
        System.out.println(" " + board[7] + " | " + board[8] + " | " + board[9]);

        System.out.println();
    }

    // Player Move
    static void playerMove() {

        int position;

        do {
            System.out.print("Enter position (1-9): ");
            position = sc.nextInt();

        } while (position < 1 || position > 9 || board[position] != ' ');

        board[position] = 'X';
    }

    // Check Winning Condition
    static boolean checkWin(char symbol) {

        // Rows
        if ((board[1] == symbol && board[2] == symbol && board[3] == symbol) ||
            (board[4] == symbol && board[5] == symbol && board[6] == symbol) ||
            (board[7] == symbol && board[8] == symbol && board[9] == symbol)) {

            return true;
        }

        // Columns
        if ((board[1] == symbol && board[4] == symbol && board[7] == symbol) ||
            (board[2] == symbol && board[5] == symbol && board[8] == symbol) ||
            (board[3] == symbol && board[6] == symbol && board[9] == symbol)) {

            return true;
        }

        // Diagonals
        if ((board[1] == symbol && board[5] == symbol && board[9] == symbol) ||
            (board[3] == symbol && board[5] == symbol && board[7] == symbol)) {

            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        System.out.println("=== TIC TAC TOE ===");

        displayBoard();

        while (true) {

            playerMove();

            displayBoard();

            // Check Winner
            if (checkWin('X')) {

                System.out.println("Player Wins!");

                break;
            }
        }
    }
}
