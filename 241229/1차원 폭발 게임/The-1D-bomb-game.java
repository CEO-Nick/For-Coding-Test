import java.util.*;
import java.io.*;

public class Main {
    static int endOfArray;
    static int[] arr;
    static int n;
    static int m;

    public static void bomb() {
        int[] tmp = new int[n];
        int tmpIdx = 0;
        int arrIdx = 0;
        while (arrIdx < endOfArray) {
            int std = arr[arrIdx];
            int stdIdx = arrIdx;
            int count = 1;

            while (++arrIdx < endOfArray && arr[arrIdx] == std) count++;
            
            if (count < m) {
                for (int i = stdIdx; i < arrIdx; i++) {
                    tmp[tmpIdx++] = arr[i];
                }
            }
            
        }
        arr = tmp;
        endOfArray = tmpIdx;
        // System.out.println(Arrays.toString(arr));
        // System.out.println(endOfArray);

    }

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());   
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 연속된 1개면 모든 폭탄이 터짐
        if (m == 1) {
            System.out.println(0);
            return;
        }

        endOfArray = n;
        int before = n;
        while (true) {
            bomb();
            // 배열의 개수가 이전과 변화가 없다면 더이상 m개 이상 연속된 폭탄이 없다는 의미
            if (before == endOfArray) break;
            before = endOfArray;
        }

        System.out.println(endOfArray);
        for (int i = 0; i < endOfArray; i++) {
            System.out.println(arr[i]);
        }
        
    }
}