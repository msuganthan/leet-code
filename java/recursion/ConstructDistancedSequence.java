package recursion;

/**
 * 1718. Construct the Lexicographically Largest Valid Sequence
 * <p>
 * Given an integer n, find a sequence that satisfies all of the following:
 *      The integer 1 occurs once in the sequence.
 *      Each integer between 2 and n occurs twice in the sequence.
 *      For every integer i between 2 and n, the distance between the two occurrences of i is exactly i.
 *
 * The distance between two numbers on the sequence, a[i] and a[j], is the absolute difference of their indices, |j - i|.
 *
 * Return the lexicographically largest sequence. It is guaranteed that under the given constraints, there is always a
 * solution.
 *
 * A sequence a is lexicographically larger than a sequence b (of the same length) if in the first position where a and b
 * differ, sequence a has a number greater than the corresponding number in b. For example, [0,1,9,0] is lexicographically
 * larger than [0,1,5,6] because the first position they differ is at the third number, and 9 is greater than 5.
 *
 */
public class ConstructDistancedSequence {
    public static void main(String[] args) {

    }

    public int[] constructDistancedSequence(int n) {
        int[] ans = new int[n * 2 - 1];
        boolean[] visited = new boolean[n + 1];
        calc(0, ans, visited, n);
        return ans;
    }

    boolean calc(int index, int[] ans, boolean[] visited, int n) {
        if (index == ans.length) {
            return true;
        }
        if (ans[index] != 0)
            return calc(index + 1, ans, visited, n); // value already assigned in this position. So go ahead with the next index.
        else {
            // we start from n to 1 since we need to find out the lexicographically largest sequence.
            for (int i = n; i >= 1; i--) {
                if (visited[i]) continue;
                visited[i] = true;
                ans[index] = i;
                if (i == 1) {
                    if (calc(index + 1, ans, visited, n)) return true;
                } else if (index + i < ans.length && ans[index + i] == 0) {
                    ans[i + index] = i; // assigning the second occurence of i in the desired position i.e, (current index + i )
                    if (calc(index + 1, ans, visited, n))
                        return true; // largest possible sequence satisfying the given conditions found.
                    ans[index + i] = 0;
                }
                ans[index] = 0;
                visited[i] = false;
            }

        }
        return false;
    }
}
