
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        String[] logs = new String[N];

        for (int i = 0; i < N; i++) {
            logs[i] = sc.next();
            sc.next();
        }

        Arrays.sort(logs, Collections.reverseOrder());

        int idx = 0;
        while (idx < N) {
            
            if (idx == N - 1) {
                System.out.println(logs[idx]);
                break;
            }
            if (logs[idx].equals(logs[idx + 1])) {
                idx += 2;
                continue;
            }

            System.out.println(logs[idx]);
            idx++;
        }
    }

}
