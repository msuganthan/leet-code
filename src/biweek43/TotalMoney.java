package biweek43;

public class TotalMoney {
    public static void main(String[] args) {
        totalMoney(4);
    }

    static int totalMoney(int n) {
        int answer = 0;

        if (n <= 7)
            return (n * (n + 1)) / 2;
        else {
            int times = n / 7;
            int remainder = n % 7;
            int nextStartingPoint = 0;
            int start = 4;
            for (int i = 0; i < times; i++) {
                answer += ((start + i) * 7 );
                nextStartingPoint++;
            }

            int cal = 0;
            for (int i = 0; i < remainder; i++) {
                nextStartingPoint++;
                cal += (nextStartingPoint);
            }
            answer += cal;
        }

        return answer;
    }
}
