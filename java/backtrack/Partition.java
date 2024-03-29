package backtrack;

import java.util.ArrayList;
import java.util.List;

public class Partition {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        dfs(0, result, new ArrayList<>(), s);
        return result;
    }

    void dfs(int start, List<List<String>> result, List<String> currentList, String s) {
        if(start >= s.length()) result.add(new ArrayList<>(currentList));
        for(int end = start; end < s.length(); end++) {
            if(isPalindrome(s, start, end)) {
                currentList.add(s.substring(start, end + 1));
                dfs(end + 1, result, currentList, s);
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s, int low, int high) {
        while(low < high) {
            if(s.charAt(low++) != s.charAt(high--)) return false;
        }
        return true;
    }
}
