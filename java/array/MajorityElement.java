package array;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement {
    public static void main(String[] args) {
        new MajorityElement().majorityElement(new int[]{1,2});
    }
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums.length == 0) {
            return result;
        }
        int count1 = 0, count2 = 0, candidate1 = 0, candidate2 = 1;
        for (int n: nums) {
            if(n == candidate1) count1++;
            else if (n == candidate2) count2++;
            else if (count1 == 0) {
                candidate1 = n;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = n;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0; count2 = 0;
        for(int n: nums) {
            if(n == candidate1) count1++;
            else if(n == candidate2) count2++;
        }
        if (count1 > nums.length / 3) result.add(candidate1);
        if (count2 > nums.length / 3) result.add(candidate2);
        return result;
    }
}
