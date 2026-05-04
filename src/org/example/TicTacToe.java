import java.util.Random;

public class TicTacToe{

    
    static void displayBoard(char[] board) {
        System.out.println();

        System.out.println(" " + board[1] + " | " + board[2] + " | " + board[3]);
        System.out.println("---|---|---");
        System.out.println(" " + board[4] + " | " + board[5] + " | " + board[6]);
        System.out.println("---|---|---");
        System.out.println(" " + board[7] + " | " + board[8] + " | " + board[9]);

        System.out.println();
    }

    
    static boolean isValidMove(char[] board, int position) {
        return board[position] == ' ';
    }

    
    static void computerMove(char[] board) {

        Random random = new Random();
        int position;

        
        do {
            
            position = random.nextInt(9) + 1;

        } while (!isValidMove(board, position));

       
        board[position] = 'O';

        System.out.println("Computer placed O at position " + position);
    }

    public static void main(String[] args) {

      
        char[] board = {
                '0',
                ' ', ' ', ' ',
                ' ', ' ', ' ',
                ' ', ' ', ' '
        };

        System.out.println("Initial Board:");
        displayBoard(board);

        
        computerMove(board);

        System.out.println("Board After Computer Move:");
        displayBoard(board);
    }
}