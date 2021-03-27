package recursion;

public class CanReach {
    public static void main(String[] args) {

    }
    public boolean canReach(int[] arr, int start) {
        if(start >= 0 && start < arr.length && arr[start] >= 0) {
            if (arr[start] == 0)
                return true;

            arr[start] = -arr[start];
            return canReach(arr, start + arr[start]) || canReach(arr, start - arr[start]);
        }
        return false;
    }
}
