package design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomizedSet {
    public static void main(String[] args) {

    }

    List<Integer> numbers;
    Map<Integer, Integer> location;
    java.util.Random random = new java.util.Random();
    public RandomizedSet() {
        numbers = new ArrayList<>();
        location = new HashMap<>();
    }

    boolean insert(int val) {
        if (location.containsKey(val))
            return false;

        location.put(val, numbers.size());
        numbers.add(val);
        return true;
    }

    boolean remove(int val) {
        if (!location.containsKey(val))
            return false;

        int loc = location.get(val);
        if (loc < numbers.size() - 1) {
            int lastOne = numbers.get(numbers.size() - 1);
            numbers.set(loc, lastOne);
            location.put(lastOne, loc);
        }
        location.remove(val);
        numbers.remove(numbers.size() - 1);
        return true;
    }

    int getRandom() {
        return numbers.get(random.nextInt(numbers.size()));
    }
}
