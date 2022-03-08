/*This program is a 3 X 3 tic-tac-toe game.

Written by Asia Griffith March 2022
 */


package Griffith.assignment.ch8;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {

//SETTING UP TIC TAC TOE BOARD
        char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

//PLAYERS ENTER THEIR NAMES
        System.out.println("Please enter your name Player 1: ");
        Scanner scanner = new Scanner(System.in);
        String playerOne = scanner.nextLine();

        System.out.println("Please enter your name Player 2: ");
        String playerTwo = scanner.nextLine();


//PLAYER ONE MOVE
        boolean game = true;
        do {
            playersMove(playerOne, board, 'X');
            printBoard(board);

            if (gameStatusWon(board, 'X')) {
                System.out.println("Congratulations!!! " + playerOne + " you won the game!!!\n");
                System.out.println("GAME OVER");
                System.exit(1);
            }
            
            //This is where the issue starts. It says the game is over when it is not
            if (gameStatusDraw(board)) ;
            {
                System.out.println("Sorry, you both lose");
                System.exit(3);
            }

//PLAYER TWO MOVE
            playersMove(playerTwo, board, 'O');
            printBoard(board);


            if (gameStatusWon(board, 'X')) {
                System.out.println("Congratulations!!! " + playerTwo + " you won the game!!\n");
                System.out.println("GAME OVER");
                System.exit(1);
            }
        } while (game = true);
    }

    // METHOD THAT PRINTS BOARD
    private static void printBoard(char[][] board) {

        System.out.println("|" + board[0][0] + "|" + board[0][1] + "|" + board[0][2] + "|");
        System.out.println("-------");
        System.out.println("|" + board[1][0] + "|" + board[1][1] + "|" + board[1][2] + "|");
        System.out.println("-------");
        System.out.println("|" + board[2][0] + "|" + board[2][1] + "|" + board[2][2] + "|");

    }


    //METHOD THAT INITIATES PLAYERS MOVE
    private static void playersMove(String playersName, char[][] board, char character) {
        boolean done = true;
        do {
            System.out.println(playersName + ", please enter a row (0, 1, or 2): ");
            Scanner scanner = new Scanner(System.in);
            int row = scanner.nextInt();

            System.out.println("Now enter a column (0, 1, or 2) for player X: ");
            int column = scanner.nextInt();

            if (board[row][column] == ' ') {
                board[row][column] = character;
                done = false;
            } else System.out.println("Invalid move. Try again.");

        } while (done == true);
    }

    // METHOD THAT CHECKS THE "WIN" STATUS OF THE GAME
    public static boolean gameStatusWon(char[][] board, char character) {
        // Assessing Left diagonal
        if (character == board[0][0] && character == board[1][1] && character == board[2][2]) return true;

        // Assessing right diagonal
        if (character == board[0][2] && character == board[1][1] && character == board[2][0]) return true;

        // Assessing rows
        for (int i = 0; i < 3; i++)
            if (character == board[i][0] && character == board[i][1] && character == board[i][2]) return true;

        // Assessing columns
        for (int j = 0; j < 3; j++)
            if (character == board[0][j] && character == board[1][j] && character == board[2][j]) return true;


        return false;
    }

    // METHOD THAT CHECKS THE "DRAW STATUS OF THE GAME
    public static boolean gameStatusDraw(char[][] board) {
        boolean draw = true;

        // DETERMINING IF GAME IS STILL ON
        for (int i = 0; i < 3; i++) {
            for (int x = 0; x < 3; x++) {
                if (board[i][x] == ' ') {
                    draw = false;
                }
            }
        }

        // IS THE BOARD FULL?
        if(draw) {
            // DID SOMEONE WIN?
            if(gameStatusWon(board, 'X') || gameStatusWon(board, 'O')) {
                draw = false;
            }
        }
        
        
        return draw;
    }
}
