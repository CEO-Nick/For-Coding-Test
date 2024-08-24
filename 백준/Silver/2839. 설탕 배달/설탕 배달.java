
import java.io.IOException;
import java.util.Scanner;

public class Main {

    static int n;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        // 가장 가까운 5의 배수가 될 때까지 -3 씩 진행
        int count = 0;

        while (n % 5 != 0 && n >= 0) {
            count++;
            n -= 3;
        }
        if (n % 5 == 0) {
            count += n / 5;
        } else {
            count = -1;
        }

        System.out.println(count);
    }
}
