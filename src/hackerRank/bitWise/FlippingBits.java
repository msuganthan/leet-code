package hackerRank.bitWise;

public class FlippingBits {
    public static void main(String[] args) {

    }

    /**
     * 22 = 1 << 2 = (int) Math.pow(2, 2)
     * 210 = 1 << 10 = (int) Math.pow(2, 10)
     * @param n
     * @return
     */
    static long flippingBits(long n) {
        long THE_FLIPPING = (1L << 32) - 1;
        return n ^ THE_FLIPPING;
    }
}
