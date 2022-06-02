package string;

import java.util.HashSet;
import java.util.Set;

public class NumJewelsInStones {
    public int numJewelsInStones(String jewels, String stones) {
        int result = 0;
        Set<Character> setJ = new HashSet<>();
        for (Character c : jewels.toCharArray()) {
            setJ.add(c);
        }
        for (Character c: stones.toCharArray()) {
            if (setJ.contains(c)) {
                result++;
            }
        }
        return result;
    }
}
