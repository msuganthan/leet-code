package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        threeSum(new int[]{0, 0, 0, 0});
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int firstElement = nums[i];
            int firstPointer = i + 1;
            int secondPointer = nums.length - 1;

            while (firstPointer < secondPointer) {
                int firstPointerElement = nums[firstPointer];
                int secondPointerElement = nums[secondPointer];
                int totalSum = firstElement + firstPointerElement + secondPointerElement;
                if (totalSum == 0) {
                    result.add(Arrays.asList(firstElement, firstPointerElement, secondPointerElement));

                    while (firstPointer < secondPointer && nums[firstPointer] == nums[firstPointer + 1]) firstPointer++;
                    while (firstPointer < secondPointer && nums[secondPointer] == nums[secondPointer - 1])
                        secondPointer--;

                    firstPointer++;
                    secondPointer--;
                } else if (totalSum < 0)
                    firstPointer++;
                else
                    secondPointer--;
            }
        }
        return result;
    }
}
