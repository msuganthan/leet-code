package contest.weekly.w232;

import java.util.ArrayList;
import java.util.List;

/**
 * Check if One String Swap Can Make Strings Equal
 *
 * You are given two strings s1 and s2 of equal length. A string swap is an operation where you choose two indices in a
 * string (not necessarily different) and swap the characters at these indices.
 *
 * Return true if it is possible to make both strings equal by performing at most one string swap on exactly one of the
 * strings. Otherwise, return false.
 *
 * Input: s1 = "bank", s2 = "kanb"
 * Output: true
 * Explanation: For example, swap the first character with the last character of s2 to make "bank".
 */
public class AreAlmostEqual {

    public static void main(String[] args) {
        new AreAlmostEqual().areAlmostEqual("bank", "kanb");
    }

    public boolean areAlmostEqual(String s1, String s2) {
        int count = 0;
        List<Character> l1 = new ArrayList<>();
        List<Character> l2 = new ArrayList<>();

        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)){
                count++;
                l1.add(s1.charAt(i));
                l2.add(s2.charAt(i));
            }
        }

        if(count != 2){
            return false;
        }

        if(l1.get(0) != l2.get(1) || l1.get(1) != l2.get(0)){
            return false;
        }
        return true;
    }
}
