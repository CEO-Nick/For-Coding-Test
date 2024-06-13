
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Meeting[] infos = new Meeting[N];
        for (int i = 0; i < N; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            infos[i] = new Meeting(start, end);

        }

        // 1. 종료 시간 순으로 오름 차순
        // 2. 종료 시간 같으면 시작 시간으로 오름 차순
        Arrays.sort(infos, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                if (o1.end == o2.end) return o1.start - o2.start;
                return o1.end - o2.end;
            }
        });

        System.out.println(getMaxCount(N, infos));

    }

    private static int getMaxCount(int N, Meeting[] infos) {
        int endTime = 0;
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (infos[i].start >= endTime) {
                endTime = infos[i].end;
                count++;
            }
        }

        return count;
    }

    static class Meeting {
        int start;
        int end;

        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }


}
