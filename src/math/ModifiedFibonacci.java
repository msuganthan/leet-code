package math;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class ModifiedFibonacci {

    public static void main(String[] args) {
        System.out.println(solution(10));
    }

    static int solution(int N) {
        if (N <= 1)
            return N;

        int first  = 0;
        int second = 1;
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            first = Arrays.stream(Integer.toString(first).chars().map(c -> c - '0').toArray()).sum();
            second = Arrays.stream(Integer.toString(second).chars().map(c -> c - '0').toArray()).sum();
            sum = first + second;
            second = first;
            first = sum;
        }
        return sum;
    }
}
