package math.mislean;

/**
 * Created by msuganthan on 4/7/20.
 */
public class AbeforeB {
    public static void main(String[] args) {
        System.out.println(aBeforeB("abba"));
        System.out.println(aBeforeB("aabbb"));
        System.out.println(aBeforeB("aaa"));
        System.out.println(aBeforeB("b"));
        System.out.println(aBeforeB("ba"));
    }

    static boolean aBeforeB(String s) {
        int i = s.lastIndexOf('a');
        if (i == -1 || i == 0)
            return true;
        char b = s.charAt(i - 1);
        return b != 'b';
    }
}
