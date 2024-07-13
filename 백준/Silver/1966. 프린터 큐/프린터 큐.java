
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        Queue<Document> q = new LinkedList<>();

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());

            Integer[] priority = new Integer[N];

            for (int i = 0; i < N; i++) {
                int priori = Integer.parseInt(st.nextToken());
                priority[i] = priori;
                q.add(new Document(priori, i));
            }

            Arrays.sort(priority, Comparator.reverseOrder());
            int idx = 0;
            int count = 0;
            while (!q.isEmpty()) {
                if (priority[idx] == q.element().priority) {
                    Document head = q.remove();
                    count++;
                    idx++;
                    if (head.index == M) {
                        sb.append(count).append("\n");
                        break;
                    }

                } else {
                    q.add(q.remove());
                }
            }


            q.clear();
        }
        System.out.println(sb);
    }

    static class Document {
        int priority;
        int index;

        public Document(int priority, int index) {
            this.priority = priority;
            this.index = index;
        }
    }
}
