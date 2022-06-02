package evertz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddPair {
    public static void main(String[] args) {
        //[1, 2, 3, 4, 5, 6] --> [3, 7, 11]
        new AddPair().add(Arrays.asList(1, 2, 3, 4, 5, 6, 7))
                .forEach(System.out::println);
    }

    public List<Integer> add(List<Integer> nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.size(); i = i + 2)
            result.add(i + 1 < nums.size() ? nums.get(i) + nums.get(i + 1) : nums.get(i));
        return result;
    }
}
