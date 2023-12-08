/*
 * @author AJ
 * @version 1.0 - 12/8/2023
 * @purpose This is a simple tic-tac-toe game that I decided to make. As I learn more java I would like to add more to it in order to make it more functional
 */

// Import scanner
import java.util.Scanner;
// Start of class
public class Main {

    // used to print board
    public static void printBoard(String[][] board) {
        for (int i = 0; i<3; i++) {
                
                for (int k = 0; k<3; k++) {
                    System.out.print(board[i][k]);
                }
                System.out.println("\n----||---||----");
            }
    }
    public static void main(String[] args) {
        // Arrays and variables
            // visible board
        String board[][] = {{"|   |", "|   |", "|   |"}, {"|   |", "|   |", "|   |"}, {"|   |", "|   |", "|   |"}};
            // used to check for winning
        int board2[][] = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
            // determines if the game is active
        boolean gameOn = true;
            // determines player or computer turn
        boolean playerTurn = true;
        boolean computerTurn = false;

        // used to select board spot
        Scanner chooseSpot = new Scanner(System.in);
        // board spots 
        int xSpot;
        int ySpot;
        // used to determine ties
        int tries = 0;

        // game itself
        while (gameOn) {
            printBoard(board);
            // initiates player turn
            while (playerTurn) {
                System.out.println("\nWhere would you like to go?");
                xSpot = chooseSpot.nextInt() - 1;
                ySpot = chooseSpot.nextInt() - 1;
                // checks if that spot already has a selection
                if (board2[ySpot][xSpot] == 4 || board2[ySpot][xSpot] == 1) {
                    System.out.println("try again.");
                }
                else {
                    board[ySpot][xSpot] = "| x |";
                    board2[ySpot][xSpot] = 1;
                    tries++;
                    computerTurn = true;
                    playerTurn = false;
                }
            } // end of player turn

            // checks for win
            for (int i = 0; i <3; i++) {
                if (board2[i][0] + board2[i][2] + board2[i][1] == 3) {
                    System.out.println("You win");
                    gameOn = false;
                    computerTurn = false;
                }
                else if(board2[0][i] + board2[1][i] + board2[2][i] == 3) {
                    System.out.println("You win");
                    gameOn = false;
                    computerTurn = false;
                }
                else if(board2[0][0] + board2[1][1] + board2[2][2] == 3) {
                    System.out.println("You win");
                    i = 3;
                    gameOn = false;
                    computerTurn = false;
                }
            } // end of win condition

            // checks for tie
            if (tries == 9 && gameOn == true) {
            System.out.println("This game is a tie");
            gameOn = false;
            computerTurn = false;
        }   
            // initiates computer turn
            while (computerTurn) {
                System.out.print("\nComputer turn\n");

                // generated random numbers for place
                xSpot = (int) (Math.random() * 3);
                ySpot = (int) (Math.random() * 3);
                if (board2[ySpot][xSpot] == 1 || board2[ySpot][xSpot] == 4) {
                    System.out.println("try again.");
                }
                else {
                    board[ySpot][xSpot] = "| o |";
                    board2[ySpot][xSpot] = 4;
                    tries++;
                    computerTurn = false;
                    playerTurn = true;
                }
            } // end of computer turn
            
            // checks for computer win
            for (int i = 0; i <3; i++) { 
                if (board2[i][0] + board2[i][2] + board2[i][1] == 12) {
                    System.out.println("You lose");
                    gameOn = false;
                }
                else if(board2[0][i] + board2[1][i] + board2[2][i] == 12) {
                    System.out.println("You lose");
                    gameOn = false;
                }
                else if(board2[0][0] + board2[1][1] + board2[2][2] == 12) {
                    System.out.println("You win");
                    i = 3;
                    gameOn = false;
                }
            } // end of win condition
        
        } // end of game
        printBoard(board);
    }
}
