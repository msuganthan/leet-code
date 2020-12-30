package math;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

    public static void main(String[] args) {
        List<Integer> result = new ArrayList<>();
        fib(5, result);
        result.stream()
                .forEach(System.out::println);
    }

    static int fib(int N, List<Integer> result) {
        if (N == 0)
            return 0;

        if (N == 1)
            return 1;

        result.add(fib(N - 1, result) + fib(N - 2, result));
        return 0;
    }
}
