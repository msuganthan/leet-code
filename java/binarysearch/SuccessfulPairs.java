package binarysearch;

import java.util.Arrays;

public class SuccessfulPairs {

    public static void main(String[] args) {
        successfulPairs(new int[] {5,1,3}, new int[] {1,2,3,4,5}, 7);
    }
    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] answer = new int[spells.length];
        for(int i = 0; i < spells.length; i++) {
            int left = findNumber(potions, spells[i], success);
            if(left == -1) {
                answer[i] = 0;
            } else {
                int index = left - 1;
                int temp = left;
                while(spells[i] * potions[index] >= success) {
                    temp = index;
                    index--;
                }
                answer[i] = potions.length - temp;
            }
        }
        return answer;
    }

    static int findNumber(int[] potions, int n, long success) {
        int left = 0;
        int right = potions.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(n * potions[mid] >= success) {
                return mid;
            } else if(potions[mid] < success) {
                left = mid + 1;
            }
        }
        return -1;
    }
}
