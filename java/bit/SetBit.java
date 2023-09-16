package bit;

public class SetBit {

    static int setBit(int n) {
        int ones = 0;
        while (n > 0) {
            ones += (n & 1);
            n >>= 1;
        }
        return ones;
    }

    static int setBitRev(int n) {
        if (n == 0)
            return 0;

        return (n & 1) + setBitRev(n >> 1);
    }
}
