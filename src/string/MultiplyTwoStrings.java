package string;

public class MultiplyTwoStrings {

    public static void main(String[] args) {
        System.out.println(multiply("123", "45"));
    }

    public static String multiply(String num1, String num2) {
        int m = num1.length() - 1, n = num2.length() - 1;
        int[] pos = new int[m + n + 2];

        for (int i = m; i >=  0; i--) {
            for (int j = n; j >= 0 ; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

                int p1 = i + j;
                int p2 = i + j + 1;

                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = sum % 10;
            }
        }
        StringBuilder result = new StringBuilder();
        for(int p : pos)
            if (result.length() != 0 || p != 0)
                result.append(p);

        return result.length() == 0 ? "0" : result.toString();

    }
}
