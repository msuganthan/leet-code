package array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle2 {

    public static void main(String[] args) {
        pascalTriangle2(4);
    }

    static List<Integer> pascalTriangle2(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        result.add(1);

        for (int i = 1; i < rowIndex; i++) {
            for (int j = i - 1; j >= 1; j--)
                result.set(j, result.get(j - 1) + result.get(j));
            result.add(1);
        }

        return result;
    }
}
