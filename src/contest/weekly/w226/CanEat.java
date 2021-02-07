package contest.weekly.w226;

public class CanEat {
    //ToDo: Sugan, Comeback to this later
    public static void main(String[] args) {

    }

    static boolean[] canEat(int[] candiesCount, int[][] queries) {
        boolean[] answer = new boolean[queries.length];
        long[] count = new long[candiesCount.length];
        count[0] = candiesCount[0];
        for (int i = 1; i < candiesCount.length; i++) {
            count[i] += (candiesCount[i] + count[i - 1]);
        }
        for (int i = 0; i < queries.length; i++) {
            int type = queries[i][0];
            int day  = queries[i][1];
            int cap = queries[i][2];
            long max = (day + 1) * cap;
            //2 Conditions: We have enough to reach ith day or there are enough days to be eating 1 candy at a time
            answer[i] = (max > ((type == 0) ? 0 : count[type - 1]) && day + 1 <= count[type]);
        }
        return answer;

    }


}
