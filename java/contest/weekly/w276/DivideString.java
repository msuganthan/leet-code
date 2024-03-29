package contest.weekly.w276;

import java.util.ArrayList;
import java.util.List;

/**
 * 5980. Divide a String Into Groups of Size k
 * https://leetcode.com/contest/weekly-contest-276/problems/divide-a-string-into-groups-of-size-k/
 *
 * A string s can be partitioned into groups of size k using the following procedure:
 *
 * The first group consists of the first k characters of the string, the second group consists of the next k characters
 * of the string, and so on. Each character can be a part of exactly one group.
 * For the last group, if the string does not have k characters remaining, a character fill is
 * used to complete the group.
 * Note that the partition is done so that after removing the fill character from the last group
 * (if it exists) and concatenating all the groups in order, the resultant string should be s.
 *
 * Given the string s, the size of each group k and the character fill, return a string array
 * denoting the composition of every group s has been divided into, using the above procedure.
 */
public class DivideString {
    public static void main(String[] args) {
        final String[] strings = divideString("abcdefghij", 3, 'x');
        System.out.println(strings);
    }
    static String[] divideString(String s, int k, char fill) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i+=k) {
            result.add(s.substring(i, i + k < s.length() ? i + k : i + (s.length() - i)));
        }
        String lastString = result.get(result.size() - 1);
        if (lastString.length() < k) {
            StringBuilder builder = new StringBuilder();
            builder.append(lastString);
            for (int i = lastString.length(); i < k; i++) {
                builder.append(fill);
            }
            result.remove(result.size() - 1);
            result.add(result.size(),  builder.toString());
        }
        return result.toArray(String[]::new);
    }
}
