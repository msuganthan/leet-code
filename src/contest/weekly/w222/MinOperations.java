package contest.weekly.w222;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MinOperations {
    public static void main(String[] args){
        System.out.println(minOperations(new int[] {6,4,8,1,3,2}, new int[] {4,7,6,2,3,8,6,1}));
    }

    static int minOperations(int[] target, int [] arr) {
        Map<Integer, Integer> positionMap = new HashMap<>();
        for(int i = 0; i < target.length; i++)
            positionMap.put(target[i], i);

        ArrayList<Integer> stack = new ArrayList<>();
        for (int a: arr) {
            if (!positionMap.containsKey(a)) continue;

            if (stack.size() == 0 || positionMap.get(a) > stack.get(stack.size() - 1)) {
                stack.add(positionMap.get(a));
                continue;
            }

            int left = 0, right = stack.size() - 1, mid;
            while (left < right) {
                mid = (left + right) / 2;
                if (stack.get(mid) < positionMap.get(a))
                    left = mid + 1;
                else
                    right = mid;
            }
            stack.set(left, positionMap.get(a));
        }
        return target.length - stack.size();
     }
}
