package miscellaneous;

public class MirrorReflection {

    public static void main(String[] args) {
        System.out.println(mirrorReflection(5, 3));
    }

    static int mirrorReflection(int p, int q) {
        int m = 1, n = 1;
        while(m * p != n * q){
            n++;
            m = n * q / p;
        }
        if (m % 2 == 0 && n % 2 == 1) return 0;
        if (m % 2 == 1 && n % 2 == 1) return 1;
        if (m % 2 == 1 && n % 2 == 0) return 2;
        return -1;
    }

    static int mirrorReflection_1(int p, int q) {
        if (q == 0)
            return 0;

        int lcm = p * q / gcd(p, q);
        if ((lcm / q) % 2 == 0)
            return 2;
        if ((lcm / p) % 2 == 0)
            return 0;

        return 1;
    }

    public static int gcd(int a, int b) {
        return b > 0 ? gcd(b, a % b) : a;
    }
}
