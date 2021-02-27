package stack;

import java.util.*;

/**
 * 71. Simplify Path
 */
public class SimplifyPath {
    public static void main(String[] args) {

    }

    String simplifyPath(String path) {
        Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));
        Deque<String> deque = new LinkedList<>();
        String result = "";
        String[] directories = path.split("/");
        for (String directory: directories) {
            if (directory.equals("..") && !deque.isEmpty()) deque.pop();
            else if (!skip.contains(directory)) deque.push(directory);
        }
        for (String directory: deque)
            result = "/" + directory + result;

        return result.isEmpty() ? "/" : result;
    }
}
