package contest.weekly.w274;

import java.util.Arrays;

public class AsteroidsDestroyed {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long m = mass;
        for (int asterMass : asteroids) {
            if (m < asterMass) return false;
            else
                m += asterMass;
        }
        return true;
    }
}
