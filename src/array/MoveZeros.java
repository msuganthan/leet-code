package array;

public class MoveZeros {

    public static void main(String[] args) {
        moveZeros(new int[]{0, 1, 0, 3, 12});
    }

    static void moveZeros(int[] nums) {

        int insertPosition = 0;
        for (int num : nums) {
            if (num != 0)
                nums[insertPosition++] = num;
        }

        while (insertPosition < nums.length)
            nums[insertPosition++] = 0;
    }
}
