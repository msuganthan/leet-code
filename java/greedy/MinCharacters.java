package greedy;

public class MinCharacters {
    public static void main(String[] args) {
        minCharacters("aba", "caa");
    }

    static int minCharacters(String a, String b) {
        return Math.min(Math.min(operationOne(a, b), operationOne(b, a)), operationTwo(a, b));
    }

    static int operationOne(String a, String b) {

        int result = Integer.MAX_VALUE;
        for(int i = 1; i < 26; i++) {
            char[] aChars = a.toCharArray();
            char[] bChars = b.toCharArray();

            int count = 0;
            for(int j = 0; j < aChars.length; j++)
                if(aChars[j] - 'a' >= i)
                    count++;

            for(int j = 0; j < bChars.length; j++)
                if(bChars[j] - 'a' < i)
                    count++;

            result = Math.min(result, count);
        }
        return result;
    }

    static int operationTwo(String a, String b) {
        int[] A = new int[26];

        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        for(int i = 0; i < aChars.length; i++)
            A[aChars[i] - 'a']++;

        for(int i = 0; i < bChars.length; i++)
            A[bChars[i] - 'a']++;

        int result = 0;
        for (int i = 0; i < 26; i++) {
            result = Math.max(result, A[i]);
        }

        return a.length() + b.length() - result;
    }
}
