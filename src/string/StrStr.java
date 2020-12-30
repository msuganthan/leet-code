package string;

/**
 * Created by msuganthan on 10/3/20.
 */
public class StrStr {
    public static void main(String[] args) {
        strStr("hello", "ll");
    }

    static int strStr(String hayStack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == hayStack.length()) return -1;
                if (needle.charAt(j) != hayStack.charAt(i + j)) break;
            }
        }

    }
}
