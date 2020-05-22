package com.ofloxacin.leetcode.interview.array;

import org.junit.jupiter.api.Test;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-05-13
 */
public class P0036_IsValidSudoku {

    @Test
    public void test() {
        System.out.println(isValidSudoku(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        }));
        System.out.println(isValidSudoku(new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        }));
    }

    public boolean isValidSudoku(char[][] board) {
        short[] rows = new short[board.length];
        short[] cols = new short[board.length];
        short[] boxes = new short[board.length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                short mask = (short) (1 << (board[row][col] - '1'));
                if ((rows[row] & mask) != 0) return false;
                if ((cols[col] & mask) != 0) return false;
                int boxIndex = 3 * (row / 3) + col / 3;
                if ((boxes[boxIndex] & mask) != 0) return false;
                rows[row] |= mask;
                cols[col] |= mask;
                boxes[boxIndex] |= mask;
            }
        }
        return true;
    }

    public boolean isValidSudoku2(char[][] board) {
        int len = board.length;
        for (int i = 0; i < len; i++) {
            if (noValid(board[i])) {
                return false;
            }
            char[] temp = new char[len];
            for (int j = 0; j < len; j++) {
                temp[j] = board[j][i];
            }
            if (noValid(temp)) {
                return false;
            }
        }
        for (int i = 0; i < len; i += 3) {
            for (int j = 0; j < len; j += 3) {
                char[] temp = new char[len];
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        temp[3 * x + y] = board[i + x][j + y];
                    }
                }
                if (noValid(temp)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean noValid(char[] board) {
        int bitmap = 0;
        for (char c : board) {
            if (c == '.') {
                continue;
            }
            int mask = 1 << c;
            if ((bitmap & mask) != 0) {
                return true;
            }
            bitmap |= mask;
        }
        return false;
    }
}
