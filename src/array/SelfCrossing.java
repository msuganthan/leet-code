package array;

public class SelfCrossing {

    public static void main(String[] args) {
        System.out.println(isSelfCrossing(new int[]{1, 1, 2, 1, 1}));
    }

    static boolean isSelfCrossing(int[] x) {
        if (x.length < 4) return false;

        int i = 2;

        /**
         * Third and fourth element is greater than first and second element.
         *
         * which means it is spiraling outside.
         */
        while (i < x.length && x[i] > x[i - 2])
            i++;

        if (i == x.length) return false;

        if ((i == 3 && x[i] == x[i - 2]) || (i >= 4 && x[i] >= x[i - 2] - x[i - 4]))
            x[i - 1] -= x[i - 3];

        i++;

        while (i < x.length) {
            /**
             * Third element is lesser than or equals first element
             */
            if (x[i] >= x[i - 2]) return true;
            i++;
        }

        return false;
    }
}
