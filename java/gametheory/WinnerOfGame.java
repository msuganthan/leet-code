package gametheory;

public class WinnerOfGame {
    public boolean winnerOfGame(String colors) {
        int alice = 0, bob = 0;
        for(int i = 1; i < colors.length() - 1; i++) {
            if(colors.charAt(i - 1) == colors.charAt(i) && colors.charAt(i) == colors.charAt(i + 1)) {
                if(colors.charAt(i) == 'A') {
                    alice += 1;
                } else {
                    bob += 1;
                }
            }
        }
        return alice > bob;
    }
}
