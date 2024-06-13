
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Integer[] array = new Integer[N];
        for (int i = 0; i < N; i++) {
            array[i] = sc.nextInt();
        }

        Arrays.sort(array);

        long startSum = 0;
        int std = array[0];
        for (int i = 1; i < N; i++) {
            startSum += array[i] - std;
        }

        int minIdx = 0;
        for (int i = 1; i < N; i++) {
            long difference = array[i] - array[i-1];
            long beforeSum = startSum;

            // 기준을 우측으로 한 칸 감으로써 발생하는 
            // 멀어진 거리
            startSum += i * difference;

            // 가까워진 거리
            startSum -= (N-i) * difference;

            if (startSum < beforeSum) {
                minIdx = i;
            }

        }

        System.out.println(array[minIdx]);

    }
}
