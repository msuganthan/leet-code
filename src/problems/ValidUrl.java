package problems;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ValidUrl {
    public static void main(String[] args) {

    }

    public static String getPotentialDomains(List<String> lines) {
    // Write your code here
        /*Pattern pa = Pattern.compile("http[s]?:\\/\\/(ww[w2]\\.)?(([a-zA-Z0-9\\-]+\\.)+([a-zA-Z\\-])+)");
        Set<String> domainNames =  lines.stream()
                                    .map(line -> {
                                        return pa.matcher(line);
                                    })
                                    .filter(Matcher::find)
                                    .map(match -> {
                                        String tempEmail = line.substring(match.start(), match.end());
                                        String[] domain = tempEmail.trim().split("//");
                                        String temp = domain[1].trim().replace("www.", "");
                                        temp = temp.replace("_", "");
                                        return temp.trim();
                                    }
                                    .collect(Collectors.toSet());
        return Array.from(set).join(";");*/
        return null;
    }
}
