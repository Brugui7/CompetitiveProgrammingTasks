package crackingTheCodeInterview.arrayStrings;

import java.util.Arrays;

/**
 * Write an algorithm such that if an element in an M x N matrix is 0,
 * its entire row and column are set to 0
 */
public class ZeroMatrix {
    public static void zeroMatrix(int[][] matrix) {
        boolean[] zeroesInRows = new boolean[matrix.length];
        boolean[] zeroesInColumns = new boolean[matrix[0].length];


        // Saves the positions where there is a 0
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroesInColumns[j] = true;
                    zeroesInRows[i] = true;
                }
            }
        }

        // Sets to zero the rows with at least one 0
        for (int row = 0; row < zeroesInRows.length; row++) {
            if (!zeroesInRows[row]) continue;
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[row][i] = 0;
            }
        }

        // Sets to zero the columns with at least one 0
        for (int column = 0; column < zeroesInColumns.length; column++) {
            if (!zeroesInColumns[column]) continue;
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][column] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4, 0}, {5, 6, 7, 8, 8}, {9, 10, 11, 12, 2}, {13, 14, 15, 16, 56}};
        System.out.println(Arrays.deepToString(matrix));
        zeroMatrix(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
