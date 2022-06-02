package string;

/**
 * 1528. Shuffle String
 * You are given a string s and an integer array indices of the same length. The string s will be shuffled
 * such that the character at the ith position moves to indices[i] in the shuffled string.
 *`
 * Return the shuffled string.
 */
public class RestoreString {
    public String restoreString(String s, int[] indices) {
        char[] arr = new char[s.length()];
        for (int i = 0; i < indices.length; i++) {
            arr[indices[i]] = s.charAt(i);
        }
        return String.valueOf(arr);
    }
}
