package contest225;

public class MaximumTime {
    public static void main(String[] args) {
        System.out.println(maximumTime("?4:03"));
    }

    static String maximumTime(String time) {
        char[] cTime = new char[5];
        cTime[0] = time.charAt(0) == '?' ? '2' : time.charAt(0);
        cTime[1] = time.charAt(1) == '?' ? (cTime[0] == '2' ? '3' : '9') : time.charAt(1);

        cTime[0] = cTime[1] > '3' && cTime[0] == '2' ? '1' : cTime[0];

        cTime[2] = ':';
        cTime[3] = time.charAt(3) == '?' ? '5' : time.charAt(3);
        cTime[4] = time.charAt(4) == '?' ? '9' : time.charAt(4);
        return new String(cTime);
    }
}
