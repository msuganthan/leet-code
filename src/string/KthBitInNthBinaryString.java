package string;

/**
 * Created by msuganthan on 5/9/20.
 */
public class KthBitInNthBinaryString {

    public static void main(String[] args) {
        findKthBit(3, 1);
    }

    public static char findKthBit(int n, int k) {
        int count = 0;
        int length = (1 << n) - 1;
        System.out.println(length);
        return count % 2 == 0 ? '0' : '1';
    }
}
