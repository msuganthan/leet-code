package contest.weekly.w234;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Evaluate the Bracket Pairs of a String
 *
 * You are given a string s that contains some bracket pairs, with each pair containing a non-empty key.
 *
 * For example, in the string "(name)is(age)yearsold", there are two bracket pairs that contain the keys "name" and "age".
 *
 * You know the values of a wide range of keys. This is represented by a 2D string array knowledge where each
 * knowledge[i] = [keyi, valuei] indicates that key keyi has a value of valuei.
 *
 * You are tasked to evaluate all of the bracket pairs. When you evaluate a bracket pair that contains some key keyi, you will:
 *  Replace keyi and the bracket pair with the key's corresponding valuei.
 *  If you do not know the value of the key, you will replace keyi and the bracket pair with a question mark "?"
 *
 *  Each key will appear at most once in your knowledge. There will not be any nested brackets in s.
 *
 *  Return the resulting string after evaluating all of the bracket pairs.
 */

public class Evaluate {

    public static void main(String[] args) {
        System.out.println(new Evaluate().evaluate("(a)(b)", Arrays.asList(Arrays.asList("a","b"), Arrays.asList("b","a"))));
    }

    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> knowledgeMap = new HashMap<>();
        for (int i = 0; i < knowledge.size(); i++)
            knowledgeMap.put(knowledge.get(i).get(0), knowledge.get(i).get(1));

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < s.length();) {
            if (s.charAt(i) == '(') {
                int nextIndex = s.indexOf(')', i);
                String key = s.substring(i + 1, nextIndex);
                answer.append(knowledgeMap.containsKey(key) ? knowledgeMap.get(key) : '?');
                i = nextIndex + 1;
            } else {
                answer.append(s.charAt(i));
                i++;
            }
        }
        return answer.toString();
    }
}
