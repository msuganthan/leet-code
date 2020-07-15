package miscellaneous;

public class FirstUniqueCharacter {

    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
    }

    public static int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int[] items = new int[26];
        for (int i = 0; i < chars.length; i++)
            items[chars[i] - 'a']++;
        for (int i = 0; i < chars.length; i++)
            if (items[chars[i] - 'a'] == 1)
                return i;
        return -1;
    }
}
