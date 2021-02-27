package contest.biweekly.bw45;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxValue {
    public static void main(String[] args) {

    }

    static int maxValue(int[][] events, int K) {
        //startDate, endDate, value
        Arrays.sort(events, (a, b) ->
                a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]
        );

        //ToDo: Suganthan get back

        return 0;
    }

}
