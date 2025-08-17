package array;

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        int[] arrA = new int[26];
        int[] arrB = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arrA[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            arrB[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < arrA.length; i++) {
            if (arrA[i] != arrB[i]) {
                return false;
            }
        }

        return true;
    }
}
