package array;

public class MaximumAreaOfAPieceOfCake {

    public static void main(String[] args) {
        System.out.println(Math.pow(10, 9) + 7);
        getMaxArea(5, new int[] {1, 2, 4});
    }

    static int getMaxArea(int end, int[] cuts) {
        int from   = 0;
        int result = 0;

        for (int c : cuts) {
            result = Math.max(result, c - from);
            from   = c;
        }
        return Math.max(result, end - from);
    }
}
