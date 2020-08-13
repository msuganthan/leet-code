package array;

public class MaxDistance {

    public static void main(String[] args) {
        maxDistToClosest(new int[] {1,0,0,0} );
    }

    static int maxDistToClosest(int[] seats) {
        int maxDistance = Integer.MIN_VALUE;

        for(int i = 0; i < seats.length; i++) {
            int left = i - 1;
            int right = i + 1;

            if(seats[i] != 1) {

                while(left > 0 && seats[left] == 0)
                    left--;

                while(right < seats.length && seats[right] == 0)
                    right++;

                int min = 0;
                if(right > seats.length - 1)
                    min = i - left;
                else if(left < 0)
                    min = right - i;
                else
                    min = i - left < right - i ? i - left : right - i;

                if(min > maxDistance)
                    maxDistance = min;
            }
        }
        return maxDistance;

    }
}
