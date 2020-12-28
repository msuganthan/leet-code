package string;

/**
 * Created by msuganthan on 6/9/20.
 */
public class CustomSortString {
    public static void main(String[] args) {
        customSort("cba", "abcd");
    }

    static String customSort(String S, String T) {
        int[] count = new int[26];

        StringBuilder sb = new StringBuilder();
        for (char c: T.toCharArray())
            ++count[c - 'a'];

        for (char c: S.toCharArray())
            while (count[c - 'a']-- > 0)
                sb.append(c);

        for (char c = 'a'; c <= 'z' ; c++)
            while (count[c - 'a']-- > 0)
                sb.append(c);

        return sb.toString();
    }
}
