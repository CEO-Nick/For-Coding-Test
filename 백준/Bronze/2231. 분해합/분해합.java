
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 1; i < N; i++) {
            int sum = i;
            String temp = String.valueOf(i);
            for (int j = 0; j < temp.length(); j++) {
                char c = temp.charAt(j);
                sum += (c-'0') ;
            }
            if (sum == N) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}


