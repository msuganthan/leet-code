package math;

public class TitleToNumber {

    public static void main(String[] args) {
        titleToNumber("AA");
    }

    static int titleToNumber(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += result * 26 + (s.charAt(i) - 'A' + 1);
        }

        return result;
    }
}
