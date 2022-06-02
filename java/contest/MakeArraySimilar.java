package contest;

public class MakeArraySimilar {
    public static void main(String[] args) {
        System.out.println(minOperations(6));
    }

    static int minOperations(int n) {
        int low = 0;
        int high = n;
        int mid = low + ((high - low) / 2);
        if (n % 2 == 0)
            mid -= 1;

        int[] arr = new int[high];
        for (int i = 0; i < high; i++)
            arr[i] = (2 * i) + 1;

        int increment = 0;
        int decrement = 0;
        int operationCount = 0;
        int ll = high - 1;
        while (low < ll) {
            increment += arr[mid] - arr[low];
            decrement += arr[ll] - arr[mid];

            arr[low] += increment;
            arr[ll] -= decrement;
            operationCount = Math.max(increment, decrement);

            if (arr[low] == arr[mid])
                low++;
            if (arr[ll] == arr[mid])
                ll--;
        }
        return operationCount;
    }


}
