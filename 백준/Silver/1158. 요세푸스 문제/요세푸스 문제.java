import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>(N);
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        int index = 0;
        List<Integer> answer = new ArrayList<>(N);
        while (!list.isEmpty()) {
            index = (index + (K-1)) % list.size();
            answer.add(list.remove(index));
        }

        for (int i = 0; i < N; i++) {
            if (i == 0) {
                System.out.print("<");
            }
            System.out.print(answer.get(i));

            if (i != N-1) {
                System.out.print(", ");
            } else {
                System.out.print(">");
            }
        }
    }

}
