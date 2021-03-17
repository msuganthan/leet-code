package recursion;

/**
 * N-th Tribonacci Number
 *
 * The Tribonacci sequence Tn is defined as follows:
 *
 * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
 *
 * Given n, return the value of Tn.
 */
public class Tribonacci {
    public static void main(String[] args) {

    }

    public int tribonacci(int n) {
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
        int a = 0, b = 1, c = 1, d = 0;

        while(n-- > 2) {
            d = a + b + c;
            a = b;
            b = c;
            c = d;
        }
        return d;
    }
}
