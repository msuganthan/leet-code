package array;

import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.List;

public class MatchingSubSequence {
    public static void main(String[] args) {
        numMatchingSubSeq("abcde", new String[]{"a", "bb", "acd", "ace"});
    }

    public static int numMatchingSubSeq(String S, String[] words) {
        List<StringCharacterIterator>[] waiting = new List[128];
        for (int c = 0; c <= 'z'; c++)
            waiting[c] = new ArrayList();
        for (String w : words)
            waiting[w.charAt(0)].add(new StringCharacterIterator(w));
        for (char c : S.toCharArray()) {
            List<StringCharacterIterator> advance = waiting[c];
            waiting[c] = new ArrayList();
            for (StringCharacterIterator it : advance)
                waiting[it.next() % it.DONE].add(it);
        }
        return waiting[0].size();
    }
}
