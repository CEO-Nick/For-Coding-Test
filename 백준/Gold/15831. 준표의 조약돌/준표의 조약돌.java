
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // 산책한 구간에 있는 모든 조약돌 줍는다
        // 까만돌 B개 이하 & 흰 돌 W개 이상 -> 이런 구간들 중 가장 긴 구간 구하기
        // 이 조건 없으면 바로 집 간다

        int N = sc.nextInt(), B = sc.nextInt(), W = sc.nextInt();

        char[] rockInfos = sc.next().toCharArray();

        int black = 0, white = 0;
        int max = -1;
        int j = 0;
        for (int i = 0; i < N; i++) {
            while (j < N) {
                char color = rockInfos[j];

                if (black == B && color == 'B') break;

                if (color == 'B') black++;
                else white++;

                j++;
            }

            if (white >= W) max = Math.max(max, j - i);

            if (rockInfos[i] == 'B') black--;
            else white--;
        }

        System.out.println(max == -1 ? 0 : max);
    }
}
