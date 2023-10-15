package sort;

public class SortSentence {
    public String sortSentence(String s) {
        String[] strs = s.split(" ");
        String[] answer = new String[strs.length];
        for(String str: strs) {
            int i = str.length() - 1;
            answer[str.charAt(i) - '1'] = str.substring(0, i);
        }
        return String.join(" ", answer);
    }
}
