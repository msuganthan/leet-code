package design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomizedSet {
    private Map<Integer, Integer> indexing;
    private List<Integer> numbers;

    public RandomizedSet() {
        this.indexing = new HashMap<>();
        this.numbers = new ArrayList<>();
    }

    public boolean insert(int val) {
        if(this.indexing.containsKey(val)) {
            return false;
        }
        int indexInsert = this.numbers.size();
        this.numbers.add(val);
        this.indexing.put(val, indexInsert);
        return true;
    }

    public boolean remove(int val) {
        if(!this.indexing.containsKey(val)) {
            return false;
        }

        int lastIndex = this.numbers.size() - 1;
        int lastElement = this.numbers.get(lastIndex);
        int indexElement = this.indexing.get(val);

        this.numbers.set(indexElement, lastElement);

        this.indexing.put(lastElement, indexElement);
        this.indexing.remove(val);

        this.numbers.remove(lastIndex);
        return true;
    }

    public int getRandom() {
        int randomIndex = (int) (Math.random() * this.numbers.size());
        return this.numbers.get(randomIndex);
    }
}
