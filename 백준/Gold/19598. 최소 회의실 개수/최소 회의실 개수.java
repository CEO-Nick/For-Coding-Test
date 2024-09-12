
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    static class Meeting {
        int start;
        int end;
        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Meeting{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
    public static void main(String[] args) throws IOException {
        // N개의 회의를 모두 진행할 수 있는 최소 회의실 개수 구하기
        // 끝남과 동시에 시작할 수 있음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // end에 대한 최소힙
        PriorityQueue<Meeting> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.end));

        int n = Integer.parseInt(br.readLine());

        List<Meeting> meetings = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            meetings.add(new Meeting(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1])));
        }

        // 회의 시작하는 순서대로 정렬 (같은 경우 먼저 끝나는 순서대로)
        meetings.sort((o1, o2) -> {
            if (o1.start == o2.start) return o1.end - o2.end;
            return o1.start - o2.start;
        });

        int ans = -1;
        for (Meeting m : meetings) {
            if (pq.isEmpty()) {
                pq.offer(m);
                continue;
            }

            // pq에서 새 회의(m) 시작시간보다 일찍 끝나는 회의들 모두 제거
            while (!pq.isEmpty() && pq.peek().end <= m.start) {
                pq.poll();
            }
            pq.offer(m);
            ans = Math.max(ans, pq.size());
        }
        System.out.println(ans);
    }
}
