package divideAndConquer;

import java.util.ArrayList;
import java.util.List;

public class DiffWaysToCompute {
    public static void main(String[] args) {
        diffWaysToCompute("2*3-4*5");
    }

    static List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        int N = input.length();
        for (int i = 0; i < N; i++) {
            if (input.charAt(i) == '-'
                || input.charAt(i) == '*'
                || input.charAt(i) == '+') {
                String partOne = input.substring(0, i);
                String partTwo = input.substring(i + 1);
                List<Integer> partOneValues = diffWaysToCompute(partOne);
                List<Integer> partTwoValues = diffWaysToCompute(partTwo);
                System.out.println("\nPart One Values...");
                partOneValues.stream()
                        .forEach(e -> System.out.print("  ==>"+e));
                System.out.println("\nPart Two Values...");
                partTwoValues.stream()
                        .forEach(e -> System.out.print("  ==>"+e));
                for (Integer p1: partOneValues) {
                    for (Integer p2: partTwoValues) {
                        int c = 0;
                        switch (input.charAt(i)) {
                            case '+': c = p1 + p2; break;
                            case '-': c = p1 - p2; break;
                            case '*': c = p1 * p2; break;
                        }
                        result.add(c);
                    }
                }
            }
        }
        if (result.size() == 0)
            result.add(Integer.valueOf(input));
        return result;
    }
}
