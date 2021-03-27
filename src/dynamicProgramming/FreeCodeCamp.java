package dynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class FreeCodeCamp {
    public static void main(String[] args) {
        /**
         * Fibonacci memoization
         */
        System.out.println("Fibonacci => " + new Fibonacci().fibonacci(50));

        /**
         * Grid Traveller
         */
        System.out.println("Grid Traveller ==> " + new GridTraveller().gridTraveller(18, 18));

        /**
         * Can Sum
         */
        System.out.println("Can Sum ==> " + new CanSum().canSum(new int[]{2, 3, 5}, 8)); //true
        System.out.println("Can Sum ==> " + new CanSum().canSum(new int[]{5, 3, 4, 7}, 7)); //true
        System.out.println("Can Sum ==> " + new CanSum().canSum(new int[]{2, 4}, 7)); // false
        System.out.println("Can Sum ==> " + new CanSum().canSum(new int[]{2, 3, 5}, 8)); //true
        System.out.println("Can Sum ==> " + new CanSum().canSum(new int[]{7, 14}, 300)); // false

        /**
         * How Sum
         */
        //3, 2, 2
        System.out.println("How Sum ==> "+new HowSum().howSum(new int[] {2, 3}, 7).stream().map(String::valueOf).collect(Collectors.joining(", ")));
        //4, 3
        System.out.println("How Sum ==> "+new HowSum().howSum(new int[] {5, 3, 4, 7}, 7).stream().map(String::valueOf).collect(Collectors.joining(", ")));
        //null
        System.out.println("How Sum ==> "+new HowSum().howSum(new int[] {2, 4}, 7));
        //2, 2, 2, 2
        System.out.println("How Sum ==> "+new HowSum().howSum(new int[] {2, 3, 5}, 8).stream().map(String::valueOf).collect(Collectors.joining(", ")));
        //null
        System.out.println("How Sum ==> "+new HowSum().howSum(new int[] {7, 14}, 300));

        /**
         * Best Sum
         */
        //7
        System.out.println("Best Sum ==> "+new BestSum().bestSum(new int[] {5, 3, 4, 7}, 7).stream().map(String::valueOf).collect(Collectors.joining(", ")));
        //3, 5
        System.out.println("Best Sum ==> "+new BestSum().bestSum(new int[] {2, 3, 5}, 8).stream().map(String::valueOf).collect(Collectors.joining(", ")));
        //4, 4
        System.out.println("Best Sum ==> "+new BestSum().bestSum(new int[] {1, 4, 5}, 8).stream().map(String::valueOf).collect(Collectors.joining(", ")));
        //25, 25, 25, 25
        System.out.println("Best Sum ==> "+new BestSum().bestSum(new int[] {1, 2, 5, 25}, 100).stream().map(String::valueOf).collect(Collectors.joining(", ")));
    }

    static class Fibonacci {
        HashMap<Integer, Long> map = new HashMap<>();

        public long fibonacci(int n) {
            if (map.containsKey(n)) return map.get(n);
            if (n <= 2) return 1;
            long result = fibonacci(n - 1) + fibonacci(n - 2);
            map.put(n, result);
            return map.get(n);
        }
    }

    static class GridTraveller {
        HashMap<String, Long> map = new HashMap<>();
        public Long gridTraveller(int m, int n) {
            String key = m + "," + n;
            if (map.containsKey(key)) return map.get(key);
            if (m == 1 && n == 1) return 1L; // |__|
            if (m == 0 || n == 0) return 0L;
            long numberOfWays = gridTraveller(m - 1, n) + gridTraveller(m, n - 1);
            map.put(key, numberOfWays);
            return map.get(key);
        }
    }

    static class CanSum {
        HashMap<Integer, Boolean> map = new HashMap<>();
        public boolean canSum(int[] nums, int target) {
            if (map.containsKey(target)) return map.get(target);
            if (target == 0) return true;
            if (target < 0) return false;

            for (int i = 0; i < nums.length; i++) {
                int key = target - nums[i];
                map.put(key, canSum(nums, key));
                if (map.get(key))
                    return true;
            }
            return false;
        }
    }

    static class HowSum {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        public List<Integer> howSum(int[] nums, int target) {
            if (map.containsKey(target)) return map.get(target);
            if (target == 0) return new ArrayList<>();
            if (target < 0) return null;

            for (int i = 0; i < nums.length; i++) {
                int key = target - nums[i];
                map.put(key, howSum(nums, key));
                if (map.get(key) != null) {
                    map.get(key).add(nums[i]);
                    return map.get(key);
                }
            }
            return null;
        }
    }

    static class BestSum {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        public List<Integer> bestSum(int[] nums, int targetSum) {
            if (map.containsKey(targetSum)) return map.get(targetSum);
            if (targetSum == 0) return new ArrayList<>();
            if (targetSum < 0) return null;
            List<Integer> shortestCombination = null;
            for (int i = 0; i < nums.length; i++) {
                int remainderSum = targetSum - nums[i];
                List<Integer> remainderCombination = bestSum(nums, remainderSum);
                if (remainderCombination != null) {
                    ArrayList<Integer> integers = new ArrayList<>(remainderCombination);
                    integers.add(nums[i]);
                    map.put(targetSum, integers);
                    if (shortestCombination == null || integers.size() < shortestCombination.size())
                        shortestCombination = integers;
                }
            }
            map.put(targetSum, shortestCombination);
            return shortestCombination;
        }
    }
}
