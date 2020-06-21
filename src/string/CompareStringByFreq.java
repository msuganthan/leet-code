package string;

import java.util.Map;
import java.util.TreeMap;

public class CompareStringByFreq {
    public static void main(String[] args) {
        final String str = "zaasdasaaz";
    }

    /**
     * Couldn't able to understand the question.
     * @param queries
     * @param words
     * @return
     */
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int [] fCount = new int[11];

        for(String word : words){
            int count = smallestCharacterOccurences(word);
            fCount[count]++;
        }

        int sum = 0;
        for(int i = 0;i < fCount.length;i++){
            sum += fCount[i];
            fCount[i] = sum;
        }

        int [] res = new int[queries.length];

        for(int i=0;i<queries.length;i++){
            int count = smallestCharacterOccurences(queries[i]);
            res[i] = fCount[fCount.length -1] - fCount[count];
        }

        return res;
    }

    //Suganthan implemented this.
    private static int smallestCharacterOccurences(String str) {
        Map<Character, Integer> sortedMap = new TreeMap<>();
        char[] charArray = str.toCharArray();
        for(char ch: charArray) {
            sortedMap.put(ch, 1 + sortedMap.getOrDefault(ch, 0));
        }
        return sortedMap.entrySet().iterator().next().getValue();
    }
}
