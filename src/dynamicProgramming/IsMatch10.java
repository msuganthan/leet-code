package dynamicProgramming;

public class IsMatch10 {
    public static void main(String[] args) {

    }

    boolean isMatch(String s, String p) {
        boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
        match[s.length()][p.length()] = true;
        for (int i = s.length(); i >= 0; i--) {
            for (int j = p.length(); j >= 0; j--) {
                boolean firstMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

                if (j + 1 < p.length() && p.charAt(j + 1) == '*')
                    match[i][j] = match[i][j + 2] || firstMatch && match[i + 1][j];
                else
                    match[i][j] = firstMatch && match[i + 1][j + 1];
            }
        }
        return match[0][0];
    }
}
