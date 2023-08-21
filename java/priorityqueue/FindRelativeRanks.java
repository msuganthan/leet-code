package priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 506. Relative Ranks
 * https://leetcode.com/problems/relative-ranks/
 *
 *
 */
public class FindRelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] result = new String[n];
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->score[b] - score[a]);
        for(int i=0; i < n; i++){
            queue.add(i);
        }
        int i=1;
        while(!queue.isEmpty()){
            int idx = queue.poll();
            if(i > 3){
                result[idx] = Integer.toString(i);
            } else if(i == 1){
                result[idx] = "Gold Medal";
            } else if(i == 2){
                result[idx] = "Silver Medal";
            } else if(i == 3){
                result[idx] = "Bronze Medal";
            }
            i++;
        }
        return result;
    }
}
