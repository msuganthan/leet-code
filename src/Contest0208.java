public class Contest0208 {
    public static void main(String[] args) {
        System.out.println(countGoodTriplets(new int[]{3,0,1,1,9,7}, 7, 2, 3));
    }
    public static int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        for(int i = 0; i < arr.length - 2; i++) {
            int firstElement = arr[i];
            int firstPointer = 0;
            int secondPointer = arr.length - 1;

            while(firstPointer < secondPointer) {
                int firstPointerElement = arr[firstPointer];
                int secondPointerElement = arr[secondPointer];
                if(
                       (Math.abs(firstElement - firstPointerElement) <= a)
                    && (Math.abs(firstPointerElement - secondPointerElement) <= b)
                    && (Math.abs(firstElement - secondPointerElement) <= c))
                    count++;
                firstElement++;
                secondPointer--;
            }
        }
        return count;
    }
}
