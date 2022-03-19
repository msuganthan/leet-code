package array;

/**
 * 2011. Final Value of Variable After Performing Operations
 *
 * There is a programming language with only four operations and one variable X:
 *
 * ++X and X++ increments the value of the variable X by 1.
 * --X and X-- decrements the value of the variable X by 1.
 * Initially, the value of X is 0.
 *
 * Given an array of strings operations containing a list of operations, return the final value of X after
 * performing all the operations.
 */
public class FinalValueAfterOperations {

    static int finalValueAfterOperations(String[] operations) {
        int X = 0;
        for (int i = 0; i < operations.length; i++) {
            String operation = operations[i];
            switch (operation) {
                case "--X":
                case "X--":
                    X--;
                    break;
                case "X++":
                case "++X":
                    X++;
                    break;
            }
        }
        return X;
    }
}
