package contest.weekly.w230;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountMatches {
    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList("phone","blue","pixel"));
        list.add(Arrays.asList("phone","gold","iphone"));
        list.add(Arrays.asList("computer","silver","lenovo"));
        countMatches(list, "color", "silver");
    }

    static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int rule = 0;
        if (ruleKey == "color")
            rule = 1;
        if (ruleKey == "name")
            rule = 2;

        int count = 0;
        for (int i = 0; i < items.size(); i++) {
            List<String> strings = items.get(i);
            if (strings.get(rule).equals(ruleValue))
                count++;
        }
        return count;
    }

}
