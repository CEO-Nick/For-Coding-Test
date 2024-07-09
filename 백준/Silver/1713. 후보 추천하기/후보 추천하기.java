import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 추천하면 반드시 사진틀에 게시되어야 함
        // 사진틀은 한정
        // 빈 사진틀 없으면 추천 횟수 제일 적은 학생의 사진 삭제하고 그 자리에 새 학생 넣음
        // 횟수 같으면 오래된 사진 삭제

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());


        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int number = Integer.parseInt(st.nextToken());
            boolean inList = false;

            for (int j = 0; j < list.size(); j++) {
                if (number == list.get(j).num) {
                    inList = true;
                    list.get(j).count++;
                    break;
                }
            }

            if (!inList) {
                if (list.size() < N) list.add(0, new Student(number, 1, i));
                else {
                    list.sort((o1, o2) -> {
                        if (o1.count == o2.count) {
                            return o1.postedAt - o2.postedAt;
                        }
                        return o1.count - o2.count;
                    });
                    list.set(0, new Student(number, 1, i));
                }
            }
        }

        list.sort(((o1, o2) -> o1.num - o2.num));
        for (Student s : list) bw.write(s.num + " ");


        bw.flush();
        bw.close();
        br.close();
    }

    static class Student {
        int num;
        int count;
        int postedAt;

        public Student(int num, int count, int postedAt) {
            this.num = num;
            this.count = count;
            this.postedAt = postedAt;
        }
    }

}
