package priorityqueue;

/**
 * 1753. Maximum Score From Removing Stones
 *
 * You are playing a solitaire game with three piles of stones of sizes a, b, and c respectively.
 * Each turn you choose two different non-empty piles, take one stone from each, and add 1 point to your score.
 * The game stops when there are fewer than two non-empty piles (meaning there are no more available moves).
 *
 * Given three integers a, b, and c, return the maximum score you can get.
 */
//ToDo: This is a tricky problem should come back to this later.
public class MaximumScore {
    public int maximumScore(int a, int b, int c) {
        return Math.min((a + b + c) / 2, (a + b + c) - Math.max(a, Math.max(b , c)));
    }
}
