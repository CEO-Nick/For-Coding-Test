
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(fibonacci(n));
    }

    static int[] memory = new int[50];
    static int fibonacci(int n) {
        if (n == 1 || n == 2) return 1;
        if (memory[n] != 0) return memory[n];

        memory[n] = fibonacci(n - 1) + fibonacci(n - 2);
        return memory[n];
    }

}
