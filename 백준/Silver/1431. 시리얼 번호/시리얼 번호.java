
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // 1. 길이 짧은거 먼저
        // 2. 숫자에 대해서 자리수 합 작은게 먼저
        // 3. 사전 순 (숫자가 알파벳보다 사전순으로 작음)

        int N = sc.nextInt();
        String[] array = new String[N];
        for (int i = 0; i < N; i++) {
            array[i] = sc.next();
        }

        Arrays.sort(array, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    int result = compareString(o1, o2);
                    if (result == 0) {
                        return o1.compareTo(o2);
                    }
                    return result;
                }
                return o1.length() - o2.length();
            }
        });

        for (String number : array) {
            System.out.println(number);
        }
    }

    public static int compareString(String o1, String o2) {
        int o1Sum = 0;
        int o2Sum = 0;

        for (int i = 0; i < o1.length(); i++) {
            if (Character.isDigit(o1.charAt(i))) {
                 o1Sum += o1.charAt(i) - '0';
            }
            if (Character.isDigit(o2.charAt(i))) {
                o2Sum += o2.charAt(i) - '0';
            }
        }

        return o1Sum - o2Sum;
    }
}
