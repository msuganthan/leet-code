package math.squareRoot;

/**
 * Created by msuganthan on 13/3/20.
 */
public class SquareRoot {
    public static void main(String[] args) {
        System.out.println(sqrtRoot(16));
    }

    static int sqrtRoot(int x) {
        long r = x;
        while (r*r > x)
            r = (r + x/r) / 2;
        return (int) r;
    }
}
