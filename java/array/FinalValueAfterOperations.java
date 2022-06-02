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
        int x = 0;
        for (String opertion : operations) {
            switch (opertion) {
                case "--X", "X--" -> --x;
                case "X++", "++X" -> x++;
            }
        }
        return x;
    }


    /**
     *         x = 0
     *         for operation in operations:
     *             if operation in ["--X", "X--"]:
     *                 x -= 1
     *             elif operation in ["++X", "X++"]:
     *                 x += 1
     *
     *         return x
     */


}
