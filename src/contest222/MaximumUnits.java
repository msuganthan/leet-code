package contest222;

import java.util.Arrays;

public class MaximumUnits {
  public static void main(String[] args) {
    maximumUnits(new int[][] {{5, 10}, {2, 5}, {4, 7}, {3, 9}}, 10);
  }

  static int maximumUnits(int[][] boxTypes, int truckSize) {
      int answer = 0, index = 0;
      Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
      while (truckSize > 0) {
          if (truckSize > boxTypes[index][0]) {
              truckSize -= boxTypes[index][0];
              answer += boxTypes[index][1] * boxTypes[index][0];
              index++;

              if (index == boxTypes.length)
                  break;
          } else {
            answer += boxTypes[index][1] * truckSize;
            truckSize = 0;
          }
      }
      return answer;
  }
}
