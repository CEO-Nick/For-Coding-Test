import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] fibo = new int[n+2];
        fibo[1] = 1;
        fibo[2] = 1;
        for (int i = 3; i <= n; i++) {
            fibo[i] = fibo[i-1] + fibo[i-2];
        }

        System.out.println(fibo[n]);

    }
}