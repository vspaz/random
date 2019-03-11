package class_4;

import java.util.Random;
import java.util.Scanner;

class Move {
    int col;
    int row;
    char mark;

    Move(int col, int row, char mark) {
        this.col = col;
        this.row = row;
        this.mark = mark;
    }
}

public class TicTacToe {
    private int ROWS = 5;
    private int COLS = 5;
    private int winningSequence = 4;
    private char[][] grid = new char[COLS][ROWS];

    private char USER_MARK = 'X';
    private char AI_MARK = 'O';
    private char EMPTY_MARK = '.';
    private int cellMarked = 0;
    private int prevAIMove = 0;

    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    private Move userLastMove;

    public void initGrid() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                grid[i][j] = EMPTY_MARK;
            }
        }
    }

    public void printGrid() {
        System.out.print(" ");
        for (int n = 0; n < COLS; n++) {
            System.out.print(String.format(" %d", n + 1));
        }
        System.out.println();
        for (int i = 0; i < ROWS; i++) {
            System.out.print(String.format("%d|", i + 1));
            for (int j = 0; j < COLS; j++) {
                System.out.print(String.format("%s|", grid[i][j]));
            }
            System.out.println();
        }
    }

    public void markCell(Move move) {
        grid[move.row][move.col] = move.mark;
        cellMarked++;
    }

    private boolean isOutOfBound(int row, int col) {
        return row < 0 || col < 0 || row > ROWS - 1 || col > COLS - 1;
    }

    private boolean isCellFree(int col, int row) {
        if (isOutOfBound(row, col)) {
            System.out.println(String.format("row %d col %d are out of bound", row, col));
            return false;
        }
        return grid[row][col] == EMPTY_MARK;
    }

    public void makeMove(String playerType) {
        Move move;
        do {
            move = getMove(playerType);
        } while (!isCellFree(move.col, move.row));
        markCell(move);
    }

    private int getUserNum() {
        return scanner.nextInt() - 1;
    }

    private int getRandNum(int cap) {
        return random.nextInt(cap);
    }

    private Move getRandomAIMove() {
        return new Move(getRandNum(COLS - 1), getRandNum(ROWS - 1), AI_MARK);
    }


    private Move getLeftDiogonalMove() {
        // exclude lower & upper bounds.
        for (int i = 1; i < COLS - 1; i++) {
            for (int j = 1; j < ROWS - 1; j++) {
                if (i == j && grid[i][j] == EMPTY_MARK) {
                    return new Move(i, j, AI_MARK);
                }
            }
        }
        return getRandomAIMove();
    }

    private Move getRightDiagonalMove() {
        for (int i = COLS - 1; i > 1; i--) {
            for (int j = ROWS - 1; j > 1; j--) {
                if (i == j && grid[i][j] == EMPTY_MARK) {
                    return new Move(i, j, AI_MARK);
                }
            }
        }
        return getRandomAIMove();
    }

    private Move aiMove() {
        switch (prevAIMove) {
            case 0:
                prevAIMove++;
                return new Move(userLastMove.col, getRandNum(ROWS - 1), AI_MARK);
            case 1:
                prevAIMove++;
                return new Move(getRandNum(COLS - 1), userLastMove.row, AI_MARK);
            case 2:
                prevAIMove++;
                return getLeftDiogonalMove();
            case 3:
                prevAIMove++;
                return getRightDiagonalMove();
            default:
                prevAIMove = 0;
                return getRandomAIMove();
        }
    }

    private Move getMove(String playerType) {
        if (playerType.equals("user")) {
            System.out.println("Please, input col and row: ");
            userLastMove = new Move(getUserNum(), getUserNum(), USER_MARK);
            return userLastMove;
        }
        System.out.println("Bot move: ");
        return aiMove();

    }

    public boolean isDraw() {
        // all moves are exhausted.
        return cellMarked == COLS * ROWS;
    }

    boolean isWinSequenceAchieved(int count) {
        return count == winningSequence;
    }

    boolean isRowComplete(char[] row, char mark) {
        int count = 0;
        for (char markedField : row) {
            if (markedField == mark) {
                if (isWinSequenceAchieved(++count)) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        return false;
    }

    boolean isAnyRowComplete(char mark) {
        for (int i = 0; i < COLS; i++) {
            if (isRowComplete(grid[i], mark)) {
                return true;
            }
        }
        return false;
    }

    boolean isColumnComplete(int rowIdx, char mark) {
        int count = 0;
        for (int i = 0; i < COLS; i++) {
            if (grid[i][rowIdx] == mark) {
                if (isWinSequenceAchieved(++count)) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        return false;
    }

    boolean isAnyColumComplete(char mark) {
        for (int i = 0; i < ROWS; i++) {
            if (isColumnComplete(i, mark)) {
                return true;
            }
        }
        return false;
    }

    boolean isRightDiagonalCompelte(char mark) {
        int count = 0;
        for (int i = 0; i < COLS; i++) {
            for (int j = 0; j < ROWS; j++) {
                if (i == j) {
                    if (grid[i][j] == mark) {
                        if (isWinSequenceAchieved(++count)) {
                            return true;
                        }
                    } else {
                        count = 0;
                    }
                }
            }
        }
        return false;
    }

    boolean isLeftDiagonalComplete(char mark) {
        int count = 0;
        for (int i = 0; i < COLS; i++) {
            for (int j = 0; j < ROWS; j++) {
                if (i + j == ROWS - 1)
                    if (grid[i][j] == mark) {
                        if (isWinSequenceAchieved(++count)) {
                            return true;
                        }
                    } else {
                        count = 0;
                    }
            }
        }
        return false;
    }

    boolean isAnyDiagonalComplete(char mark) {
        return isRightDiagonalCompelte(mark) || isLeftDiagonalComplete(mark);
    }

    public boolean isWin(String playerType) {
        char mark = playerType.equals("user") ? USER_MARK : AI_MARK;
        return isAnyColumComplete(mark) || isAnyRowComplete(mark) || isAnyDiagonalComplete(mark);
    }
}
