package math.isPalindrome;

/**
 * Created by msuganthan on 9/3/20.
 */
public class IsPanlindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(10000001));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0))
            return false;
        int result = 0;
        while(x > result) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return (x == result) || (x == result / 10);
    }
}
