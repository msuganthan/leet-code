package contest218;

public class ConcatenatedBinary {
    public static void main(String[] args) {
        System.out.println(concatenatedBinary(12));
    }

    public static int concatenatedBinary(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(Integer.toBinaryString(i));
        }
        return binaryToInteger(sb.toString());
    }

    public static int binaryToInteger(String binary) {
        char[] numbers = binary.toCharArray();
        int result = 0;
        for(int i=numbers.length - 1; i>=0; i--)
            if(numbers[i]=='1')
                result += Math.pow(2, (numbers.length-i - 1));
        return result;
    }
}
