package string;

public class ReverseWords {
    public static void main(String[] args) {
        String str = " 3c      2zPeO dpIMVv2SG    1AM       o       VnUhxK a5YKNyuG     x9    EQ  ruJO       0Dtb8qG91w 1rT3zH F0m n G wU".trim();
        str = trimSentence(str);
        int N = str.length();
        int previousIndex;
        int nextIndex = str.indexOf(' ');
        StringBuilder stringBuilder = new StringBuilder();
        for (int from = N - 1; from >= N;) {
            stringBuilder.append(reverseWord(str, from, nextIndex - 1))
                         .append(' ');
            previousIndex = nextIndex;
            from          = (nextIndex + 1);
            nextIndex     = str.indexOf(' ', from);

            if (nextIndex == -1) {
                stringBuilder.append(reverseWord(str, previousIndex, N - 1));
                break;
            }
        }
        System.out.println(reverseWord(stringBuilder.toString(), 0, N - 1));
    }

    /**
     * How to reserve the word using two pointer.
     */
    static String reverseWord(String str, int i, int j) {
        StringBuilder sb = new StringBuilder();

        while (i <= j) {
            sb.append(str.charAt(j));
            j--;
        }
        return sb.toString();
    }


    static String trimSentence(String str) {
        str = str.trim();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < str.length()) {
            System.out.println(str.charAt(i) +" isLetter "+ Character.isLetter(str.charAt(i)));
            if (Character.isLetter(str.charAt(i)) || Character.isDigit(str.charAt(i))) {
                sb.append(str.charAt(i));
                i++;
                continue;
            } else if (str.charAt(i) == ' ' && (Character.isLetter(str.charAt(i + 1)) || Character.isDigit(str.charAt(i + 1)))) {
                sb.append(' ');
                sb.append(str.charAt(i + 1));
                i += 2;
                continue;
            }
            i++;
        }
        return sb.toString();
    }

    /**
     * Example 1:
     * the sky is blue
     * blue is the sky
     *
     * Example 2:
     *
     * "  hello world  "
     * "world hello"
     *
     * Example 3:
     *
     * "Bob Loves Alice"
     * "Alice Loves Bob"
     *
     * Example 4:
     *
     * "Alice does not even like bob"
     * "bob like even not does Alice"
     */
}