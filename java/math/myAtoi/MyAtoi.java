package math.myAtoi;

public class MyAtoi {
    public static void main(String[] args) {
        System.out.println(Math.pow(2, 31));
        System.out.println(myAtoi("-91283472332"));
    }

    static int myAtoi(String str) {
        str = str.trim();
        if (str.isEmpty())
            return 0;
        int sign = 1, i = 0;
        if (str.charAt(0) == '-' || str.charAt(0) == '+') {
            sign = (str.charAt(0) == '-') ? -1 : 1;
            i++;
        }
        int n = 0;
        while (i < str.length()) {
            if (Character.isDigit(str.charAt(i))) {
                int d = str.charAt(i) - '0';
                if (n > (Integer.MAX_VALUE - d) / 10)  //Detect the integer overflow.
                    return (sign == -1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;

                n = n * 10 + d;
            } else {
                break;
            }
            i++;
        }
        return sign * n;
    }
}
