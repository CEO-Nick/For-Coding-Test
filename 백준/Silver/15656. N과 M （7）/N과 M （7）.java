
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N, M;
    static int[] numbers;
    static boolean[] check;

    static int[] output;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = sc.nextInt();
        M = sc.nextInt();

        numbers = new int[N];
        check = new boolean[N];
        output = new int[M];

        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        Arrays.sort(numbers);
        perm(0, bw);
        bw.flush();
        bw.close();
    }

    public static void perm(int depth, BufferedWriter bw) throws IOException {
        if (depth == M ) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(output[i]).append(" ");
            }
            bw.write(sb + "\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            output[depth] = numbers[i];
            perm(depth+1, bw);
        }
    }

}
