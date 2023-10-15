package twopointers;

public class StrStr {
    public static void main(String[] args) {
        System.out.println(new StrStr().strStr("hello", "ll"));
    }
    public int strStr(String haystack, String needle) {
        for(int i = 0; i < haystack.length(); i++) {
            int k = i;
            int j = i;
            while(j < needle.length()
                    && k < haystack.length()
                    && needle.charAt(j++) == haystack.charAt(k++)) {
            }
            if(j == needle.length()) {
                return i;
            }
        }
        return -1;
    }
}
