package math.mislean;


/**
 * Created by msuganthan on 4/7/20.
 */
public class InsertAndMax {
    public static void main(String[] args) {
        System.out.println(maxPossibleNumber(268));
    }

    static int maxPossibleNumber(Integer n) {
        String intStr = n.toString();
        StringBuilder stringBuilder = new StringBuilder();
        char[] chrs = intStr.toCharArray();
        boolean found = false;
        for (int j = 0; j < chrs.length; ) {
            char num = chrs[j];
            if (chrs[0] == '-' && num > '5' && found == false) {
                found = true;
                stringBuilder.append(5);
                stringBuilder.append(num);
            } else if (chrs[0] != '-' && num < '5' && found == false) {
                found = true;
                stringBuilder.append(5);
                stringBuilder.append(num);
            } else {
                stringBuilder.append(num);
            }
            j++;
        }

        return Integer.parseInt(stringBuilder.toString());
    }
}
