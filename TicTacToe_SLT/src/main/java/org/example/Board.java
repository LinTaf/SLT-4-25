package org.example;

public class Board {
    final int ROW = 3;	//number of rows
    final int COL = 3;	//number of cols
    char [][] board = new char[ROW][COL];
    private int moveCounter = 0;

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

}
