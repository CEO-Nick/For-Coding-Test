
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Integer> q = new PriorityQueue<>();

        int i = sc.nextInt();
        while (i-- > 0) {
            int n = sc.nextInt();
            if (n == 0) {
                if (q.isEmpty()) {
                    bw.write("0\n");
                } else {
                    bw.write(q.remove() + "\n");
                }
            } else {
                q.offer(n);
            }
        }

        bw.flush();
        bw.close();
    }
}
