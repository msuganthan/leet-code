package array;

public class CountGoodTriplets {
    public static void main(String[] args) {
        System.out.println(countGoodTriplets(new int[] {3, 0, 1, 1, 9, 7}, 7, 2, 3));
    }

    static int countGoodTriplets(int[] arr, int a, int b, int c) {
        int N = arr.length;
        int result = 0;
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                if (Math.abs(arr[i] - arr[j]) > a)
                    continue;
                for (int k = j + 1; k < N; k++) {
                    if (Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[k] - arr[i]) <= c)
                        result++;
                }
            }
        }
        return result;
    }
}
