package tree;

/**
 * 1010. Pairs of Songs With Total Durations Divisible by 60
 *
 * You are given a list of songs where the ith song has a duration of time[i] seconds.
 *
 * Return the number of pairs of songs for which their total duration in seconds is divisible by 60.
 * Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.
 */
public class NumPairsDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] time) {
        int[] cnt = new int[60];
        int result = 0;
        for (int t : time) {
            result += cnt[(600 - t) % 60];
            cnt[t % 60] += 1;
        }
        return  result;
    }
}
