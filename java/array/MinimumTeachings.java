package array;

import java.util.HashSet;
import java.util.Set;

public class MinimumTeachings {
    public static void main(String[] args) {
        System.out.println(minimumTeachings(3,
                new int[][]{
                        {1},
                        {2},
                        {1, 2}

                },
                new int[][]{
                        {1, 4},
                        {1, 2},
                        {3, 4},
                        {2, 3}
                }));
    }

    static int minimumTeachings(int N, int[][] languages, int[][] friendships) {
        Set<Integer> cannotCommunicate = new HashSet<>();
        for (int[] friends : friendships) {
            int firstFriend = friends[0] - 1;
            int secondFriend = friends[1] - 1;
            Set<Integer> firstFriendLanguage = new HashSet<>();
            for (int num: languages[firstFriend])
                firstFriendLanguage.add(num);
            Set<Integer> secondFriendLanguage = new HashSet<>();
            for (int num: languages[secondFriend])
                secondFriendLanguage.add(num);
            firstFriendLanguage.retainAll(secondFriendLanguage);
            if (firstFriendLanguage.size() == 0) {
                cannotCommunicate.add(firstFriend);
                cannotCommunicate.add(secondFriend);
            }
        }
        int[] frequency = new int[N + 1];
        for (int index: cannotCommunicate)
            for (int languageIndex: languages[index])
                frequency[languageIndex]++;
        int mostSpokenLanguage = 0;
        for (int i = 0; i < N + 1; i++) {
            if (frequency[i] > mostSpokenLanguage)
                mostSpokenLanguage = frequency[i];
        }
        return cannotCommunicate.size() - mostSpokenLanguage;
    }
}
