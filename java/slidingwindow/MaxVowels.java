package slidingwindow;

public class MaxVowels {
    public static void main(String[] args) {
        System.out.println(maxVowels("abciiidef", 3));
    }

    static int maxVowels(String s, int K) {
        int count = 0;
        int max   = 0;
        char[] chars = s.toCharArray();

        for (int i = 0; i < K; i++) {
            if (chars[i] == 'a' || chars[i] == 'e' || chars[i]== 'i' || chars[i] == 'o' || chars[i]== 'u')
                count++;
        }
        max = count;
        for (int i = K; i < s.length(); i++) {
            if (chars[i - K] == 'a' || chars[i - K] == 'e' || chars[i - K] == 'i' || chars[i - K] == 'o' || chars[i - K] == 'u')
                count--;
            if (chars[i] == 'a' || chars[i] == 'e' || chars[i]== 'i' || chars[i] == 'o' || chars[i]== 'u')
                count--;
            max = Math.max(max, count);
        }
        return max;
    }
}
