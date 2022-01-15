package foobarWithGoogle.mine;

import java.util.Arrays;
import java.util.LinkedList;

public class Level1Problem1 {
    public static int[] solution(int area) {
        LinkedList<Integer> squares = new LinkedList<>();

        while(area > 0) {
            int square = (int) Math.floor(Math.sqrt(area));
            square *= square;
            squares.add(square);
            area -= square;
        }

        return squares.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(12))); // Expected [9, 1, 1, 1]
        System.out.println(Arrays.toString(solution(15324))); // Expected [15129, 169, 25, 1]
    }
}
