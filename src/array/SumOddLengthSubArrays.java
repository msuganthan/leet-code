package array;

public class SumOddLengthSubArrays {
    public static void main(String[] args) {
        System.out.println(sumOddLengthSubArrays(new int[] {1, 4, 2, 5, 3}));
    }

    static int sumOddLengthSubArrays(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++)
            result += ((i + 1) * (arr.length - i) + 1) / 2 * arr[i];
        return result;
    }
}
