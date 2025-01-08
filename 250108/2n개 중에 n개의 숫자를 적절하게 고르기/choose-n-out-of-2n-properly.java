import java.util.*;
import java.io.*;

public class Main {

    static int min = Integer.MAX_VALUE;

    static void recur(int idx, int count, int sumA) {
        min = Math.min(min, Math.abs(Math.abs(sumA - totalSum) - sumA));

        if (idx == 2*n) return;

        recur(idx+1, count, sumA);

        sumA += arr[idx];
        recur(idx+1, count+1, sumA);
        sumA -= arr[idx];
    }

    static int n;
    static int[] arr;
    static int totalSum = 0;

    public static void main(String[] args) throws IOException {
        // Please write your code here.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n*2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2*n; i++) {
            int num = Integer.parseInt(st.nextToken());
            totalSum += num;
            arr[i] = num;
        }

        recur(0,0,0);

        System.out.println(min);

    }
}