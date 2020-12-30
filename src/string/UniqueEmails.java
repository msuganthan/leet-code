package string;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmails {

    public static void main(String[] args) {
        System.out.println(numberOfUniqueEmails(new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"}));
    }

    private static int numberOfUniqueEmails(String[] emails) {
        Set<String> normalized = new HashSet<>();
        for (String s : emails) {
            String[] parts = s.split("@");
            String[] local = parts[0].split("\\+");
            normalized.add(local[0].replace(".", "") + "@" + parts[1]);
        }

        return normalized.size();
    }
}
