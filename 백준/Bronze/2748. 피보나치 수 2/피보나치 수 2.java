
import java.util.Scanner;

public class Main {

    static long[] memory = new long[100];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(fibo(n));
    }

    static long fibo(int n) {
        memory[1] = memory[2] = 1;

        for (int i = 3; i <= n; i++) {
            memory[i] = memory[i - 1] + memory[i - 2];
        }

        return memory[n];
    }
}
