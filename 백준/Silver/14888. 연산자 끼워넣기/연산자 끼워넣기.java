import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public  static int n;
    public static int[] array;
    public static int[] operators;
    public static int max = Integer.MIN_VALUE;
    public static int min = Integer.MAX_VALUE;
    public static final int PLUS = 0;
    public static final int MINUS = 1;
    public static final int MULTIPLY = 2;
    public static final int DIVISION = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        array = new int[n];
        for (int i = 0; i < n; i ++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        operators = new int[4];
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }


        solution(1, array[0]);

        System.out.println(max + "\n" + min);
        br.close();
    }

    public static void solution (int index, int sum) throws IOException {
        if (index == n) {
            max = Math.max(sum, max);
            min = Math.min(sum, min);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;
                switch (i) {
                    case PLUS -> solution(index + 1, sum + array[index]);
                    case MINUS -> solution(index + 1, sum - array[index]);
                    case MULTIPLY -> solution(index + 1, sum * array[index]);
                    case DIVISION -> solution(index + 1, sum / array[index]);
                }
                operators[i]++;
            }
        }
    }

}
