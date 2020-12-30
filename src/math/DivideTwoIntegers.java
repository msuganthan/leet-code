package math;

public class DivideTwoIntegers {

    public static void main(String[] args) {
        System.out.println(divide(20, 3));
    }

    public static int divide(int dividend, int divisor) {
        if (divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;


        int res = 0;
        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);
        while (dvs <= dvd) {
            long temp = dvs, count = 1;
            while (dvd >= temp << 1) {
                temp <<= 1;
                count <<= 1;
            }
            dvd -= temp;
            res += count;
        }
        return sign == 1 ? res : -res;

    }
}
