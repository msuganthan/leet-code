package contest218;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class MaxOperations {

    public static void main(String[] args) {
        System.out.println(maxOperations(new int[]{2, 5, 4, 4, 1, 3, 4, 4, 1, 4, 4, 1, 2, 1, 2, 2, 3, 2, 4, 2}, 3));
    }

    /**
     * [2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2]
     * 3
     *
     * @param nums
     * @param k
     * @return
     */
    public static int maxOperations(int[] nums, int k) {
        AtomicInteger count = new AtomicInteger();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        map.keySet().stream()
                .forEach(key -> {
                    if (key <= k) {
                        Integer left = key;
                        Integer search;
                        if (k == left)
                            search = 0;
                        else
                            search = k - left;
                        System.out.println("Left ==> " + left);
                        System.out.println("Search ==> " + search);
                        Integer rightCount = map.get(search);
                        Integer leftCount = map.get(key);
                        if (left == search && leftCount > 1) {
                            count.set(count.get() + map.get(left) / 2);
                            map.put(key, 0);
                        } else if (left != search
                                && rightCount != null && rightCount > 0
                                && leftCount != null && leftCount > 0) {
                            int c = map.get(left) < map.get(search) ? map.get(left) * 2 : map.get(search) * 2;
                            c /= 2;
                            count.set(count.get() + c);
                            map.put(key, 0);
                            map.put(search, 0);
                        }
                    } else {
                        //doNothing
                    }

                });
        return count.get();
    }
}
