package org.example;

import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void does_moveCounter_work_when_moved_increment() {
        Board board = new Board();
        assertEquals(0, board.getMoveCounter());
        board.moveIncrement();
        board.moveIncrement();
        assertEquals(2, board.getMoveCounter());
    }

    @Test
    void placeSymbolOnBoard_Player1_placeX_valid_rowCol() {
        /* testen ob, wenn ausgeführt, das gewünschte feld [r][c] mit dem richtigen
        char für den jeweiligen spieler befüllt ist*/
        Board board = new Board();
        board.placeSymbolOnBoard(0, 0, 1);
        assertEquals('X', board.getBoard()[0][0]);
    }

    @Test
    void placeSymbolOnBoard_Player2_placeO_rowCol() {
        Board board = new Board();
        board.placeSymbolOnBoard(2, 2, 2);
        assertEquals('O', board.getBoard()[2][2]);
    }

    @Test
    void is_legalMove_true_with_valid_parameters() {
        Board board = new Board();
        assertTrue(board.legalMove(0, 0));
    }

    @Test
    void is_legalMove_false_with_invalid_parameters() {
        Board board = new Board();
        assertFalse(board.legalMove(3, 3));
    }
}