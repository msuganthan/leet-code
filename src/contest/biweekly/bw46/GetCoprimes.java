package contest.biweekly.bw46;

/**
 * Tree of Coprimes
 *
 * There is a tree (i.e., a connected, undirected graph that has no cycles) consisting of n nodes numbered from 0 to n - 1
 * and exactly n - 1 edges. Each node has a value associated with it, and the root of the tree is node 0.
 *
 * To represent this tree, you are given an integer array nums and a 2D array edges. Each nums[i] represents the ith node's
 * value, and each edges[j] = [uj, vj] represents an edge between nodes uj and vj in the tree.
 *
 * Two values x and y are coprime if gcd(x, y) == 1 where gcd(x, y) is the greatest common divisor of x and y.
 *
 * An ancestor of a node i is any other node on the shortest path from node i to the root. A node is not considered an
 * ancestor of itself.
 *
 * Return an array ans of size n, where ans[i] is the closest ancestor to node i such that nums[i] and nums[ans[i]] are
 * coprime, or -1 if there is no such ancestor.
 *
 * Input: nums = [2,3,3,2], edges = [[0,1],[1,2],[1,3]]
 * Output: [-1,0,0,1]
 *
 * Input: nums = [5,6,10,2,3,6,15], edges = [[0,1],[0,2],[1,3],[1,4],[2,5],[2,6]]
 * Output: [-1,0,-1,0,0,0,-1]
 *
 * ToDo
 */

public class GetCoprimes {
    public static void main(String[] args) {

    }

    public int[] getCoprimes(int[] nums, int[][] edges) {
        int N = nums.length;
        int[] answer = new int[N];

        return answer;
    }
}
