package contest216;

import java.util.Arrays;

public class SmallestString {
    public static void main(String[] args) {
        System.out.println(getSmallestString(3, 27));
    }

    public static String getSmallestString(int n, int k) {
        char[] chars = new char[n];
        Arrays.fill(chars, 'a');
        k -= n;

        while (k > 0) {
            if (chars[n - 1] < 'z') {
                chars[n - 1]++;
                k--;
            } else
                n--;
        }

        return new String(chars);
    }
}
