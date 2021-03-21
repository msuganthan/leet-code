package contest.weekly.w233;

/**
 * Count Pairs With XOR in a Range
 *
 * Given a (0-indexed) integer array nums and two integers low and high, return the number of nice pairs.
 *
 * A nice pair is a pair (i, j) where 0 <= i < j < nums.length and low <= (nums[i] XOR nums[j]) <= high.
 *
 * Input: nums = [1,4,2,7], low = 2, high = 6
 * Output: 6
 * Explanation: All nice pairs (i, j) are as follows:
 *     - (0, 1): nums[0] XOR nums[1] = 5
 *     - (0, 2): nums[0] XOR nums[2] = 3
 *     - (0, 3): nums[0] XOR nums[3] = 6
 *     - (1, 2): nums[1] XOR nums[2] = 6
 *     - (1, 3): nums[1] XOR nums[3] = 3
 *     - (2, 3): nums[2] XOR nums[3] = 5
 *
 * Input: nums = [9,8,4,2,1], low = 5, high = 14
 * Output: 8
 * Explanation: All nice pairs (i, j) are as follows:
 *     - (0, 2): nums[0] XOR nums[2] = 13
 *     - (0, 3): nums[0] XOR nums[3] = 11
 *     - (0, 4): nums[0] XOR nums[4] = 8
 *     - (1, 2): nums[1] XOR nums[2] = 12
 *     - (1, 3): nums[1] XOR nums[3] = 10
 *     - (1, 4): nums[1] XOR nums[4] = 9
 *     - (2, 3): nums[2] XOR nums[3] = 6
 *     - (2, 4): nums[2] XOR nums[4] = 5
 */
//ToDo: Comeback to this later
public class CountPairs {
    public static void main(String[] args) {
        System.out.println(new CountPairs().countPairs(new int[] {9,8,4,2,1}, 5, 14));
    }

    public int countPairs(int[] nums, int low, int high) {
        int n = nums.length;
        // Create root node of Trie
        TrieNode root = new TrieNode();
        // Stores count of pairs that satisfy the given conditions
        int cntPairs = 0;
        // Traverse the given array
        for(int i = 0; i < n; i++) {
            // Update cntPairs
            cntPairs += cntSmaller(root, nums[i], high + 1) - cntSmaller(root, nums[i], low);
            // Insert nums[i] into Trie
            insertTrie(root, nums[i]);
        }
        return cntPairs;
    }

    // Function to count elements in Trie whose XOR with N less than K
    private int cntSmaller(TrieNode root, int N, int K) {
        //Stores count of elements whose XOR with N less than K
        int cntPairs = 0;
        //Traverse binary representation of N and K in Trie
        for (int i = 31; i >= 0 && root != null; i--) {
            //Stores ith bit of N
            int x = (N >> i) & 1;
            //Stores ith bit of K
            int y = (K >> i) & 1;
            //If the ith bit of K is 1
            if (y == 1) {
                //If an element already present in Trie having ith bit (x)
                if (root.child[x] != null)
                    cntPairs += root.child[x].cnt;
                root = root.child[1 - x];
            } else {
                //Update root
                root = root.child[x];
            }
        }
        return cntPairs;
    }

    //Function to insert a number into Trie
    private void insertTrie(TrieNode root, int N) {
        //Traverse the binary representation of X
        for (int i = 31; i >= 0; i--) {
            //Stores ith bit of N
            int x = (N >> i) & 1;
            //Check if an element already present in Trie having ith bit x
            if (root.child[x] == null) {
                //Create a new node of Trie
                root.child[x] = new TrieNode();
            }
            // Update count of elements whose ith bit is x
            root.child[x].cnt += 1;
            // Update root
            root = root.child[x];
        }
    }

    class TrieNode {
        TrieNode child[] = new TrieNode[2];
        int cnt;

        public TrieNode() {
            cnt = 0;
        }
    }
}
