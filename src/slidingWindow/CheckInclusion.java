package slidingWindow;

public class CheckInclusion {

    public static void main(String[] args) {
        checkInclusion("ab", "eidbaooo");
    }

    static boolean checkInclusion(String s1, String s2) {
        /*if (s1.length() > s2.length())
            return false;

        int[] s1M

        ap = new int[26];
        int[] s2Map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Map[s1.charAt(i) - 'a']++;
            s2Map[s2.charAt(i) - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            int r = s2.charAt(i + s1.length()) - 'a';
            int l = s2.charAt(i) - 'a';

            System.out.println("Right ==> "+r);
            System.out.println("Left  ==> "+l);

            if (count == 26)
                return true;

            s2Map[r]++;
            if (s2Map[r] == s1Map[r])
                count++;
            else if (s2Map[r] == s1Map[r] + 1)
                count--;

            s2Map[l]--;
            if (s2Map[l] == s1Map[l])
                count++;
            else if (s2Map[l] == s2Map[l] - 1)
                count--;
        }
        return count == 26;*/
        return false;
    }
}
