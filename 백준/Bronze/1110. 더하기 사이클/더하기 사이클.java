
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int count = 0;
        String temp = Integer.toString(N);
        while (true) {
            if (Integer.parseInt(temp) < 10) {
                temp = temp.charAt(temp.length() - 1) + String.valueOf(temp.charAt(temp.length() - 1));
            } else {
                int sum = 0;
                for (int i = 0; i < temp.length(); i++) {
                    sum += temp.charAt(i) - '0';
                }
                temp = temp.charAt(temp.length() - 1) + Integer.toString(sum % 10);
            }
            count++;

            if (Integer.parseInt(temp) == N) {
                System.out.println(count);
                return;
            }
        }
    }
}


