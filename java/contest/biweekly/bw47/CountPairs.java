package contest.biweekly.bw47;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Count Pairs Of Nodes
 *
 * You are given an undirected graph represented by an integer n, which is the number of nodes, and edges,
 * where edges[i] = [ui, vi] which indicates that there is an undirected edge between ui and vi.
 * You are also given an integer array queries.
 *
 * The answer to the jth query is the number of pairs of nodes (a, b) that satisfy the following conditions:
 *
 * a < b
 * cnt is strictly greater than queries[j], where cnt is the number of edges incident to a or b.
 * Return an array answers such that answers.length == queries.length and answers[j] is the answer of the jth query.
 *
 * Note that there can be repeated edges.
 */
public class CountPairs {
    public static void main(String[] args) {

    }

    public int[] countPairs(int n, int[][] edges, int[] queries) {
        int[] degree = new int[n];
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int[] edge: edges) {
            degree[--edge[0]]++;
            degree[--edge[1]]++;
            if (edge[0] > edge[1]) {
                int temp = edge[0];
                edge[0] = edge[1];
                edge[1] = temp;
            }
            //store the number of edges for each node pair
            cnt.put(edge[0] * 20000 + edge[1], cnt.getOrDefault(edge[0] * 20000 + edge[1], 0) + 1);
        }

        int[] sorted = degree.clone();
        Arrays.sort(sorted);

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int ans = 0;
            for (int l = 0, r = sorted.length - 1; l < r;) {
                if (sorted[l] + sorted[r] > queries[i]) {
                    ans += (r - l);
                    r--;
                } else {
                    l++;
                }
            }

            for (int k: cnt.keySet()) {
                int first = k / 20000;
                int second = k % 20000;

                if (degree[first] + degree[second] > queries[i] && degree[first] + degree[second] - cnt.get(k) <= queries[i])
                    ans--;
            }
            result[i] = ans;
        }
        return result;
    }

}
