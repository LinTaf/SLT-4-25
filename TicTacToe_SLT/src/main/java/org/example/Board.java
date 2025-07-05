package org.example;

import java.util.Scanner;

public class Board {
    final int ROW = 3;	//number of rows
    final int COL = 3;	//number of cols
    char [][] board = new char[ROW][COL];
    private int moveCounter = 0;
    boolean isOver = false;


    public Board () {
        //initialize board with empty rows/cols
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                board[row][col] = ' ';
            }
        }
    }

    public char[][] getBoard() {
        return board;
    }


    public void setBoard(char[][] board) {
        this.board = board;
    }

    public void setMoveCounter(int moveCounter) {
        this.moveCounter = moveCounter;
    }


    public void moveIncrement() {
        moveCounter += 1;
    }

    public int getMoveCounter () {
        return moveCounter;
    }

    public void placeSymbolOnBoard(int row, int col, int player) {
        if (player == 1) {
            board[row][col] = 'X';
        }
        if (player == 2) {
            board[row][col] = 'O';
        }
    }

    boolean legalMove (int r, int c) {
        if (r > 2 && c > 2) {
            System.out.println("Invalid Row & Column Input - Choose 0,1, or 2");
            return false;
        } else if (r > 2 ) {
            System.out.println("Invalid Row Input - Choose 0,1, or 2");
            return false;
        } else if (c > 2) {
            System.out.println("Invalid Column Input - Choose 0,1, or 2");
            return false;
        }
        if (board[r][c] != ' ') {
            System.out.println("Illegal Move");
            return false;
        } else {
            return true;
        }
    }


    public void printBoard() {
        for (int row = 0; row < ROW; row++) {
            System.out.println(board[row][0] + "|" + board[row][1] + "|" + board[row][2]);
            if (row < 2 )
                System.out.println("-----");
        }
    }


    // ************* WINNER CHECKS START *************
    public boolean draw() {
        if (moveCounter == 9) {
            System.out.println("Draw!");
            printBoard();
            return true;
        }
        else {
            return false;
        }
    }


    public boolean winByRow(int player){
        for (int i=0; i < 3; i++) {
            if (board[i][0] == board[i][1] &&
                    board[i][1] == board[i][2] &&
                    board[i][0] != ' ') {
                if (player == 1) {
                    System.out.println("Player X  wins!");
                    printBoard();
                    return true;
                }
                else {
                    System.out.println("Player O wins!");
                    printBoard();
                    return true;
                }
            }
        }
        return false;
    }

    public boolean winByColumn(int player){
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == board[1][i] &&
                    board[1][i] == board[2][i] &&
                    board[0][i] != ' ') {
                if (player == 1) {
                    System.out.println("Player X  wins!");
                    printBoard();
                    return true;
                }
                else {
                    System.out.println("Player O wins!");
                    printBoard();
                    return true;
                }
            }
        }
        return false;
    }
    public boolean winByDiagonal(int player){
        if (board[0][0] == board[1][1] &&
                board[1][1] == board[2][2] &&
                board[0][0] != ' ') {
            if (player == 1) {
                System.out.println("Player X  wins!");
                printBoard();
                return true;
            }
            else {
                System.out.println("Player O wins!");
                printBoard();
                return true;
            }
        }
        if (board[0][2] == board[1][1] &&
                board[1][1] == board[2][0] &&
                board[0][2] != ' ') {
            if (player == 1) {
                System.out.println("X player wins!");
                printBoard();
                return true;

            }
            else {
                System.out.println("O player wins!");
                printBoard();
                return true;
            }
        }
        return false;
    }

    public void checkForWinner(int player){
        if (getMoveCounter() >= 4) {
            if (winByColumn(player)) {
                isOver = true;
                playGame();

            } else if (winByDiagonal(player)) {
                isOver = true;
                playGame();

            } else if (winByRow(player)) {
                isOver = true;
                playGame();

            } else if (draw()) {
                isOver = true;
                playGame();
            }
        }
    }
    // ************* WINNER CHECKS END *************

    // ************* PLAY TIC-TAC-TOE *************
    public void playGame(){
        Scanner sc = new Scanner (System.in);
        int p1r,p1c,p2r,p2c;
        char playOrNot;

        System.out.println("Press Y to play, or N to exit");
        playOrNot = sc.next().charAt(0);

        if (playOrNot == 'Y') {

            System.out.println("Welcome to Tic-Tac-Toe");
            System.out.println("======================");

            //do loop while game is running
            do {
                //do until user chooses valid input
                //invalid input message is shown AFTER both row & col have been entered
                do {
                    printBoard();
                    System.out.println("Player 1's turn: 'X'");
                    System.out.println("Which Row would you like?");
                    p1r = sc.nextInt();
                    System.out.println("Which Col would you like?");
                    p1c = sc.nextInt();
                } while (!legalMove(p1r, p1c));

                //after getting valid input, place move on board, and increment move value
                placeSymbolOnBoard(p1r,p1c, 1);
                moveIncrement();

                //check if win or draw
                //If there are less than 5 moves, skip win checks
                checkForWinner(1);

                //if game is already over, skip player 2
                if (!isOver) {
                    //do until user chooses valid input
                    do {
                        printBoard();
                        System.out.println("Player 2's turn: 'O'");
                        System.out.println("Which Row would you like?");
                        p2r = sc.nextInt();
                        System.out.println("Which Col would you like?");
                        p2c = sc.nextInt();
                    } while (!legalMove(p2r, p2c));

                    //after getting valid input, place move on board, increment move value
                    placeSymbolOnBoard(p2r,p2c, 2);
                    moveIncrement();

                    //check if win, or draw
                    //If there are less than 5 moves, skip win / draw checks
                    checkForWinner(2);
                }
            } while (!isOver);
            //If player chooses not to play, program is terminated
        } else if (playOrNot == 'N') {
            System.out.println("Goodbye!");
            System.exit(0);
        }

    }
}
