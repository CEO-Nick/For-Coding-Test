
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Score {
        double score;
        char name;

        @Override
        public String toString() {
            return "Score{" +
                "score=" + score +
                ", name=" + name +
                '}';
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(br.readLine());    // 전체 참가자 수
        int N = Integer.parseInt(br.readLine());    // 스태프 수

        List<Score> list = new ArrayList<>();

        int n = N;
        boolean[] joinStaff = new boolean[26];
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char name = st.nextToken().charAt(0);
            int voteNum = Integer.parseInt(st.nextToken());

            // 득표수 5% 미만 제외
            if ( ((double)voteNum / X) < 0.05) {
                continue;
            }

            // 참가한 스태프 체크
            joinStaff[name-'A'] = true;

            // 점수 집합에 스태프 별 14개 점수 추가
            for (int i = 1; i <= 14; i++) {
                Score score = new Score();
                score.score = (double) voteNum / i;
                score.name = name;
                list.add(score);
            }
        }

        int[] chipCount = new int[26];

        // list에서 score를 기준으로 내림차순 정렬
        list.sort(Comparator.comparingDouble((Score s) -> s.score).reversed());

        // 0~13 인덱스까지 순회하면서 해당 알파벳에 chip 개수++
        for (int i = 0; i < 14; i++) {
            char name = list.get(i).name;
            chipCount[name-'A'] += 1;
        }


        // 득표율 5% 이상인 스태프에 대해 칩 개수 출력
        for (int i = 0; i < 26; i++) {
            if (joinStaff[i]) {
                bw.write((char) (i+'A') + " " + chipCount[i] + '\n');

            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}


