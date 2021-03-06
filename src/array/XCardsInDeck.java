package array;

import java.util.HashMap;
import java.util.Map;

public class XCardsInDeck {

    public static void main(String[] args) {
        hasGroupsSizeX(new int[]{1, 1, 2, 2, 2, 2});
    }

    public static boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> count = new HashMap<>();
        int res = 0;
        for (int i : deck) count.put(i, count.getOrDefault(i, 0) + 1);
        for (int i : count.values()) res = gcd(i, res);
        return res > 1;
    }

    public static int gcd(int a, int b) {
        return b > 0 ? gcd(b, a % b) : a;
    }
}
