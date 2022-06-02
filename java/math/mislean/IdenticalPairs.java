package math.mislean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by msuganthan on 4/7/20.
 */
public class IdenticalPairs {
    public static void main(String[] args) {
        System.out.println(identicalPairs(new int[]{1, 2, 3, 1}));
    }

    static int identicalPairs(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        // Finding frequency of each number.
        for (int i = 0; i < arr.length; i++) {
            if (hm.containsKey(arr[i]))
                hm.put(arr[i], hm.get(arr[i]) + 1);
            else
                hm.put(arr[i], 1);
        }
        int ans = 0;

        // Calculating count of pairs with equal values
        for (Map.Entry<Integer, Integer> it : hm.entrySet()) {
            int count = it.getValue();
            ans += (count * (count - 1)) / 2;
        }
        return ans;
    }
}
