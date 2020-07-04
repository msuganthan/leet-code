package math.mislean;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by msuganthan on 30/5/20.
 */
public class DayOfWeek {
    public static void main(String[] args) {
        String[] daysOfWeek = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        String target = "Wed";
        int k = 2;
        int targetIndex = IntStream.range(0, daysOfWeek.length)
                                   .filter(i -> target.equals(daysOfWeek[i]))
                                   .findFirst()
                                   .orElse(-1);
        String s = daysOfWeek[(targetIndex + k) % 7];

        /*String x = "a";
        Runnable r = () -> System.out.println(x);
        x = "b";
        r.run();*/




    }
}
