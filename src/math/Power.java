package math;

public class Power {

    public static void main(String[] args) {
        System.out.println(myPow(3, 2));
    }

    static double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n == Integer.MIN_VALUE) {
            n = n / 2;
            x = x * x;
        } else if (n < 0) {
            n = -n;
            x = 1 / x;
        }

        return x % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}
