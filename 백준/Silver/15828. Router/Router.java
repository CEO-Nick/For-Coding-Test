
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> buffer = new LinkedList<>();
        while (true) {
            int p = Integer.parseInt(br.readLine());
            if (p == -1) break;
            if (p == 0) buffer.remove();
            else {
                if (buffer.size() < N) {
                    buffer.add(p);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if (buffer.isEmpty()) {
            sb.append("empty");
        } else {
            for (int p : buffer) sb.append(p).append(" ");
        }
        System.out.println(sb);
    }
}
