package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        threeSum(new int[]{0, 0, 0, 0});
    }

    public static List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < num.length - 2; i++) {
            int firstElement = num[i];
            int firstPointer = i + 1;
            int secondPointer = num.length - 1;

            while (firstPointer < secondPointer) {
                int firstPointerElement = num[firstPointer];
                int secondPointerElement = num[secondPointer];
                int totalSum = firstElement + firstPointerElement + secondPointerElement;
                if (totalSum == 0) {
                    result.add(Arrays.asList(firstElement, firstPointerElement, secondPointerElement));

                    while (firstPointer < secondPointer && num[firstPointer] == num[firstPointer + 1]) firstPointer++;
                    while (firstPointer < secondPointer && num[secondPointer] == num[secondPointer - 1])
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
