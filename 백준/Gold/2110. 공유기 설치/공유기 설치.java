
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // 공유기 사이의 거리(d)를 매개변수로 잡고 공유기를 배치해봄
        // 만약에 C개 미만으로 공유기를 배치하면 d를 줄임
        // 만약에 C개 이상 = 공유기 사이 거리가 촘촘 -> d를 늘림

        int N = sc.nextInt();
        int C = sc.nextInt();

        Integer[] house = new Integer[N];
        for (int i = 0; i < N; i++) {
            house[i] = sc.nextInt();
        }

        Arrays.sort(house);

        int l = 0, r = Integer.MAX_VALUE;
        int ans = -1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (isPossible(house, m, C)) {
                l = m + 1;
                ans = m;
            } else {
                r = m - 1;
            }
        }

        System.out.println(ans);

    }


    public static boolean isPossible(Integer[] array, int m, int C) {
        int std = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if ((array[i] - std) >= m) {
                count++;
                std = array[i];
            }
        }
        return count >= C;
    }
}
