package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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

    // *********** Test for printing board pattern START ***********

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private Board game;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        game = new Board();

        game.board = new char[][] {
                {'X', 'O', 'X'},
                {'O', 'X', 'O'},
                {'X', ' ', 'O'}
        };
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void test_if_PrintBoard_prints_correct_pattern() {
        game.printBoard();

        String expectedOutput = String.join(System.lineSeparator(),
                "X|O|X",
                "-----",
                "O|X|O",
                "-----",
                "X| |O"
        ) + System.lineSeparator();
        // final newline from last println in loop

        assertEquals(expectedOutput, outContent.toString());
    }

    // *********** Test for printing board pattern END ***********
}