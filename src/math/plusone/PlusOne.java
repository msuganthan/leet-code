package math.plusone;

/**
 * Created by msuganthan on 13/3/20.
 */
public class PlusOne {

    public static void main(String[] args) {
        System.out.println(plusOne(new int[]{0,3,2,9,9}));
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >=0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                break;
            } else {
                digits[i] = 0;
            }
        }
        if (digits[0] == 0) {
            int[] res = new int[digits.length+1];
            res[0] = 1;
            return res;
        }
        return digits;
    }
}
