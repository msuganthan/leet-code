package dynamicProgramming;

public class DivisorGame {
    public static void main(String[] args) {
        divisorGame(10);
    }
    
    static boolean divisorGame(int N) {
        return N % 2 == 0;
    }
}
