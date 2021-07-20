package crackingTheCodeInterview.arrayStrings;

import java.util.Arrays;

/**
 * Given an image represented by an N x N matrix, where each pixel is the image is
 * represented by an integer, write a method to rotate the image by 90 degrees.
 * Can you do this in place?
 *
 */
public class RotateMatrix {

    /**
     * Done in place with a complexity of O(n^2)
     * At first I wasn't able to do it in place
     * TODO: Try again in some time
     *
     * @param matrix int[][]
     * @return bool
     */
    static boolean rotateMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) return false;

        int n = matrix.length;
        for (int layer = 0; layer < n / 2; layer++) {
            int last = n - 1 - layer;
            for (int i = layer; i < last; i++) {
                int offset = i - layer;
                int top = matrix[layer][i];

                // Saves top
                matrix[layer][i] = matrix[last - offset][layer];

                // Bottom to left
                matrix[last - offset][layer] = matrix[last][last - offset];

                // Right to bottom
                matrix[last][last - offset] = matrix[i][last];

                // Top to Right
                matrix[i][last] = top;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] image = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        System.out.println(Arrays.deepToString(image));
        rotateMatrix(image);
        System.out.println(Arrays.deepToString(image));
    }
}


