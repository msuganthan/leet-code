package slidingwindow;

/**
 * 424. Longest Repeating Character Replacement
 */
public class CharacterReplacement {

    int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        int maxFrequency = 0;
        int answer = 0;
        int i = 0;
        for(int j = 0; j < s.length(); j++) {
            arr[s.charAt(j) - 'A']++;
            maxFrequency = Math.max(maxFrequency, arr[s.charAt(j) - 'A']);
            int windowLength = j - i + 1;
            if(windowLength - maxFrequency > k) {
                arr[s.charAt(i) - 'A']--;
                i++;
            }
            answer = Math.max(answer, j - i + 1);
        }
        return answer;
    }
}
