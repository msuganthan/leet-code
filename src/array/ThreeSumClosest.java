package array;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1,2,1,-4}, 1));
    }

    public static int threeSumClosest(int[] array, int target) {
        Integer result = array[0] + array[1] + array[array.length - 1];
        Arrays.sort(array);
        for(int i = 0; i < array.length - 2; i++) {

                int firstElement = array[i];
                int firstPointer = i + 1;
                int secondPointer = array.length - 1;

                while(firstPointer < secondPointer) {
                    int firstPointerElement = array[firstPointer];
                    int secondPointerElement = array[secondPointer];
                    int totalSum = firstElement + firstPointerElement + secondPointerElement;
                    if (totalSum > target)
                        secondPointer--;
                    else
                        firstPointer++;
                    if (Math.abs(totalSum - target) < Math.abs(result - target))
                        result = totalSum;
                }
        }
        return result;
    }
}
