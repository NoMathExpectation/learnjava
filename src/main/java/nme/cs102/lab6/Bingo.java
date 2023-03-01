package nme.cs102.lab6;

import java.util.Scanner;

public class Bingo {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int[][] board = new int[sc.nextInt()][sc.nextInt()];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    board[i][j] = sc.nextInt();
                }
            }

            int bingo = 0;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (check(board, i, j)) {
                        bingo++;
                    }
                }
            }

            System.out.printf("There are %d bingo grids.", bingo);
        }
    }

    public static boolean check(int[][] board, int row, int column) {
        try {
            return board[row][column] == 0 && board[row - 1][column] == 1 && board[row + 1][column] == 1 && board[row][column - 1] == 1 && board[row][column + 1] == 1;
        } catch (IndexOutOfBoundsException ignored) {}
        return false;
    }
}
