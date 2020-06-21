package math;

public class RomanNumerals {
    public static void main(String[] args) {
        String str = "IV";
        int[] a = new int[26];

        System.out.println('I' - 'A');
        System.out.println('V' - 'A');
        System.out.println('X' - 'A');
        System.out.println('L' - 'A');
        System.out.println('C' - 'A');
        System.out.println('D' - 'A');
        System.out.println('M' - 'A');
        a['I' - 'A'] = 1;
        a['V' - 'A'] = 5;
        a['X' - 'A'] = 10;
        a['L' - 'A'] = 50;
        a['C' - 'A'] = 100;
        a['D' - 'A'] = 500;
        a['M' - 'A'] = 1000;
        char prev = 'A';
        int sum = 0;
        for(char s : str.toCharArray()) {
            if(a[s - 'A'] > a[prev - 'A']) {
                sum = sum - 2 * a[prev - 'A'];
            }
            sum = sum + a[s - 'A'];
            prev = s;
        }
        System.out.println(sum);

    }


}
