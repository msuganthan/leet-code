package twopointers;

import java.util.HashMap;

public class CountPairs {
    public static void main(String[] args){
        System.out.println(countPairs(new int[] {1,1,1,3,3,3,7}));
    }

    static int countPairs(int[] arr) {
        int MOD = 1_000_000_007;
        long answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            int power = 1;
            for(int i = 0; i < 32; i++) {
                if (map.containsKey(power - num)) {
                    answer += map.get(power - num);
                    answer %= MOD;
                }
                power *= 2;
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return (int) answer;
    }
}
