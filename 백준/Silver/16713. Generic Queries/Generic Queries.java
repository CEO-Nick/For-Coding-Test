
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int Q = sc.nextInt();

        int[] array = new int[N+1];
        // 다르면 참
        for (int i = 1; i <= N; i++) {

            array[i] = array[i-1] ^ sc.nextInt();
        }

        int ans = 0;
        while(Q-- > 0) {
            int i = sc.nextInt();
            int j = sc.nextInt();

            ans ^= (array[j] ^ array[i-1]);
        }
        System.out.println(ans);

    }
}
