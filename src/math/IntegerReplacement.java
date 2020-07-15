package math;

public class IntegerReplacement {

    public static void main(String[] args) {
        integerReplacement(8);
    }

    /**
     * If n is even, halve it.
     * If n=3 or n-1 has less 1's than n+1, decrement n.
     * Otherwise, increment n.
     */
    public static int integerReplacement(int n) {
        int c = 0;
        while (n != 1) {

            //If n is even, halve it.
            if ((n & 1) == 0)
                n >>>= 1;

            //we just need to remove as many 1's as possible
            else if (n == 3 || Integer.bitCount(n + 1) > Integer.bitCount(n - 1))
                --n;

            else
                ++n;

            ++c;

        }

        return c;
    }

}
