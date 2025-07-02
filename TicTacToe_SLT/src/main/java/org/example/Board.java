package org.example;

public class Board {
    final int ROW = 3;	//number of rows
    final int COL = 3;	//number of cols
    char [][] board = new char[ROW][COL];
    private int moveCounter = 0;

    public Board () {
        //initialize board
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                board[row][col] = ' ';
            }
        }
    }

    public void printBoard() {
        for (int row = 0; row < ROW; row++) {
            System.out.println(board[row][0] + "|" + board[row][1] + "|" + board[row][2]);
            if (row < 2 )
                System.out.println("-----");
        }
    }

    public void moveIncrement() {
        moveCounter += 1;
    }

    public int getMoveCounter () {
        return moveCounter;
    }

    public void setBoard(int r, int c, int p) {
        if (p == 1) {
            board[r][c] = 'X';
        }
        if (p == 2) {
            board[r][c] = 'O';
        }
    }



}
