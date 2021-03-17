package recursion;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Check if Number is a Sum of Powers of Three 3^x
 *
 * Given an integer n, return true if it is possible to represent n as the sum of distinct powers of three.
 * Otherwise, return false.
 *
 * An integer y is a power of three if there exists an integer x such that y == 3x.
 *
 * Input: n = 12
 * Output: true
 * Explanation: 12 = 3^1 + 3^2
 *
 * Input: n = 91
 * Output: true
 * Explanation: 91 = 3^0 + 3^2 + 3^4
 */
public class CheckPowersOfThree {
    public static void main(String[] args) {
        System.out.println(new CheckPowersOfThree().checkPowersOfThree(11));
    }

    /*public boolean checkPowersOfThree(int n) {
        TreeSet<Double> set = new TreeSet<>(Comparator.reverseOrder());
        for (int i = 0; Math.pow(3, i) <= n; i++)
            set.add(Math.pow(3, i));

        int size = set.size();
        for (int i = 0; i < size; i++) {
            Double aDouble = set.pollFirst();
            if (n >= aDouble) {
                n -= aDouble;
            }
        }

        return n == 0;
    }*/

    public boolean checkPowersOfThree(int n) {
       while (n > 0) {
           if (n % 3 == 2)
               return false;
           else
               n /= 3;
       }
       return true;
    }
}
