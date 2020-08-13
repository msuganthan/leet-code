package array;

public class PlusOne {

    public static void main(String[] args) {
        plusOne(new int[] {9});
    }

    static int[] plusOne(int[] digits) {
        int N = digits.length;
        for (int i = N - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] newNumber = new int[N + 1];
        return newNumber;
    }
}
