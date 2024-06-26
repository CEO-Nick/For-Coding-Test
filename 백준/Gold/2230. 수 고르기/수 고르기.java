import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        Integer[] array = new Integer[N];
        for (int i = 0; i < N; i++) {
            array[i] = sc.nextInt();
        }

        // 2개 골랐을 때
        // 차이가 M 이상 && 그 중 차이가 제일 작은 경우

        // 정렬을 해야 차이가 M 미만일 때, 다음 원소 선택하면 차이가 증가하는걸 기대할 수 있음
        Arrays.sort(array);

        int j = 0;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            while (array[j] - array[i] < M && j < N-1) {
                j++;
            }
            int diff = array[j] - array[i];
            if (diff >= M) ans = Math.min(ans, diff);
        }

        System.out.println(ans);
    }




}
