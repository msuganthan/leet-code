package dynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        System.out.println("How Sum ==> " + new HowSum().howSum(new int[]{2, 3}, 7).stream().map(String::valueOf).collect(Collectors.joining(", ")));
        //4, 3
        System.out.println("How Sum ==> " + new HowSum().howSum(new int[]{5, 3, 4, 7}, 7).stream().map(String::valueOf).collect(Collectors.joining(", ")));
        //null
        System.out.println("How Sum ==> " + new HowSum().howSum(new int[]{2, 4}, 7));
        //2, 2, 2, 2
        System.out.println("How Sum ==> " + new HowSum().howSum(new int[]{2, 3, 5}, 8).stream().map(String::valueOf).collect(Collectors.joining(", ")));
        //null
        System.out.println("How Sum ==> " + new HowSum().howSum(new int[]{7, 14}, 300));

        /**
         * Best Sum
         */
        //7
        System.out.println("Best Sum ==> " + new BestSum().bestSum(new int[]{5, 3, 4, 7}, 7).stream().map(String::valueOf).collect(Collectors.joining(", ")));
        //3, 5
        System.out.println("Best Sum ==> " + new BestSum().bestSum(new int[]{2, 3, 5}, 8).stream().map(String::valueOf).collect(Collectors.joining(", ")));
        //4, 4
        System.out.println("Best Sum ==> " + new BestSum().bestSum(new int[]{1, 4, 5}, 8).stream().map(String::valueOf).collect(Collectors.joining(", ")));
        //25, 25, 25, 25
        System.out.println("Best Sum ==> " + new BestSum().bestSum(new int[]{1, 2, 5, 25}, 100).stream().map(String::valueOf).collect(Collectors.joining(", ")));

        /**
         * Can construct
         */
        //true
        System.out.println("Can construct ==> " + new CanConstruct().canConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"})); //true
        //false
        System.out.println("Can construct ==> " + new CanConstruct().canConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"})); //false
        //true
        System.out.println("Can construct ==> " + new CanConstruct().canConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"})); //true
        //false
        System.out.println("Can construct ==> " + new CanConstruct().canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeee"})); //false

        /**
         * Count construct
         */
        //2
        System.out.println("Count construct ==> " + new CountConstruct().countConstruct("purple", new String[]{"purp", "p", "ur", "le", "purpl"}));
        //1
        System.out.println("Count construct ==> " + new CountConstruct().countConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
        //0
        System.out.println("Count construct ==> " + new CountConstruct().countConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
        //4
        System.out.println("Count construct ==> " + new CountConstruct().countConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}));
        //0
        System.out.println("Count construct ==> " + new CountConstruct().countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeee"}));

        /**
         * All construct
         */
        System.out.println("All construct ==> " + new AllConstruct().allConstruct("purple", new String[]{"purp", "p", "ur", "le", "purpl"}).stream().flatMap(x -> x.stream()).collect(Collectors.joining(", ")));
        System.out.println("All construct ==> " + new AllConstruct().allConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}).stream().flatMap(x -> x.stream()).collect(Collectors.joining(", ")));
        System.out.println("All construct ==> " + new AllConstruct().allConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}).stream().flatMap(x -> x.stream()).collect(Collectors.joining(", ")));
        System.out.println("All construct ==> " + new AllConstruct().allConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}).stream().flatMap(x -> x.stream()).collect(Collectors.joining(", ")));
        System.out.println("All construct ==> " + new AllConstruct().allConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeee"}).stream().flatMap(x -> x.stream()).collect(Collectors.joining(", ")));
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
                List<Integer> integers = howSum(nums, key);
                if (integers != null)
                    integers.add(nums[i]);

                map.put(key, integers);
                if (integers != null)
                    return map.get(key);
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

    static class CanConstruct {
        Map<String, Boolean> map = new HashMap<>();

        public boolean canConstruct(String target, String[] wordBank) {
            if (map.containsKey(target)) return map.get(target);
            if (target.equals("")) return true;

            for (int i = 0; i < wordBank.length; i++) {
                if (target.indexOf(wordBank[i]) == 0) {
                    String slice = target.substring(wordBank[i].length());
                    if (canConstruct(slice, wordBank)) {
                        map.put(slice, true);
                        return true;
                    }
                }
            }
            map.put(target, false);
            return false;
        }
    }

    static class CountConstruct {
        Map<String, Integer> map = new HashMap<>();

        public int countConstruct(String target, String[] wordBank) {
            if (map.containsKey(target)) return map.get(target);
            if (target.equals("")) return 1;

            int totalCount = 0;
            for (int i = 0; i < wordBank.length; i++) {
                if (target.indexOf(wordBank[i]) == 0) {
                    String slice = target.substring(wordBank[i].length());
                    int numOfWays = countConstruct(slice, wordBank);
                    totalCount += numOfWays;
                }
            }
            map.put(target, totalCount);
            return totalCount;
        }
    }

    static class AllConstruct {
        Map<String, List<List<String>>> memo = new HashMap<>();

        public List<List<String>> allConstruct(String target, String[] wordBank) {
            if (memo.containsKey(target)) return memo.get(target);
            if (target.equals("")) {
                List<List<String>> tmp = new ArrayList<>();
                List<String> list = new ArrayList<>();
                tmp.add(list);
                return tmp; // a list with one element [[]]
            }
            List<List<String>> result = new ArrayList<>();
            for (String word : wordBank) {
                if (target.startsWith(word)) {
                    String suffix = target.substring(word.length());
                    List<List<String>> suffixWays = allConstruct(suffix, wordBank);
                    List<List<String>> targetWays = new ArrayList<>();
                    for (List<String> suffixWay : suffixWays) {
                        List<String> tmp = new ArrayList<>(suffixWay);
                        tmp.add(0, word);
                        targetWays.add(tmp);
                    }
                    result.addAll(targetWays);
                }
            }
            memo.put(target, result);
            return result;
        }
    }
}
