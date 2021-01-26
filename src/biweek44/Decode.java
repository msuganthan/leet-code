package biweek44;

public class Decode {
    public static void main(String[] args) {

    }

    static int[] decode(int[] encoded) {
        int a = 0;
        int N = encoded.length + 1;
        int[] decoded = new int[N];
        for(int i = 0; i <= N; i++) {
            a ^= i;
            if(i < N && i % 2 == 1)
                a ^= encoded[i];
        }
        decoded[0] = a;
        for(int i = 0; i < N - 1; i++)
            decoded[i + 1] = decoded[i] ^ encoded[i];
        return decoded;
    }
}
