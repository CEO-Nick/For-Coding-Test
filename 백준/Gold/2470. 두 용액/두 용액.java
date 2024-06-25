
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        Integer[] array = new Integer[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        int leftIdx = 0;
        int rightIdx = N-1;
        int ansAbs = Integer.MAX_VALUE;
        int ansLeft = 0, ansRight = 0;

        while (leftIdx < rightIdx) {
            int currentSum = array[leftIdx] + array[rightIdx];
            int currentAbs = Math.abs(currentSum);
            if (ansAbs > currentAbs) {
                ansAbs = currentAbs;
                ansLeft = leftIdx;
                ansRight = rightIdx;
            }
            if (currentSum > 0) rightIdx--;
            else leftIdx++;
        }


        System.out.printf("%d %d", array[ansLeft], array[ansRight]);
        br.close();
    }




}
