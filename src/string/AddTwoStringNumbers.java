package string;

public class AddTwoStringNumbers {

    public static void main(String[] args) {
        System.out.println(addString("123", "456"));
    }

    static String addString(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        while (i >= 0 || j >= 0 || carry != 0) {
            if (i > 0) carry += num1.charAt(i--) - '0';
            if (j > 0) carry += num2.charAt(j--) - '0';
            result.append(carry % 10);
            carry /= 10;
        }
        return result.reverse().toString();
    }
}
