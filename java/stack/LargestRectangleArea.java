package stack;

import java.util.Stack;

public class LargestRectangleArea {

    int largestRectangleArea(int[] height) {
        int area = 0, n = height.length;
        int start;
        Stack<CustomPair> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            start = i;
            while (!stack.empty() && stack.peek().getValue() > height[i]) {
                CustomPair pair = stack.pop();
                area = Math.max(area, pair.getValue() * (i - pair.getKey()));
                start = pair.getKey();
            }
            stack.push(new CustomPair(start, height[i]));
        }

        while (!stack.isEmpty()) {
            CustomPair pair = stack.pop();
            area = Math.max(area, pair.getValue() * (n - pair.getKey()));
        }
        return area;
    }

    static class CustomPair {
        private final Integer key;
        private final Integer value;

        CustomPair(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public Integer getKey() {
            return key;
        }

        public Integer getValue() {
            return value;
        }
    }
}
