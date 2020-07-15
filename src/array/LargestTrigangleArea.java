package array;

public class LargestTrigangleArea {


    //

    public static double largestTriangleArea(int[][] points) {
        double max = 0.0;
        for (int x = 0; x < points.length - 2; x++)
            for (int y = 0; y < points.length - 1; y++)
                for (int z = 0; z < points.length; z++)
                    max = Math.max(max, areaCalc(points[x], points[y], points[z]));
        return max;
    }

    //Ax(By-Cy)+Bx(Cy−Ay)+Cx(Ay-By) / 2
    static double areaCalc(int[] x, int[] y, int[] z) {
        return Math.abs(
                x[0] * (y[1] - z[1])
                + y[0] * (z[1] - x[1])
                + z[0] * (x[1] - y[1])) / 2.0;
    }
}
