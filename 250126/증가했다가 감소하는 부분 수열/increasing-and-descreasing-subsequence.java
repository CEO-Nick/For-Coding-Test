import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // Please write your code here.    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp_asc = new int[n];  // i번째까지 가장 긴 증가 부분 수열의 길이
        int[] dp_desc = new int[n]; // i번째까지 가장 긴 감소 부분 수열의 길이

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp_asc[i] = 1;
            dp_desc[i] = 1;
        }

        // 먼저 증가 부분 수열 구하기
        for (int i = 1; i < n; i++) {
            int curValue = arr[i];
            for (int j = 0; j < i; j++) {
                if (arr[j] < curValue) {
                    dp_asc[i] = Math.max(dp_asc[i], dp_asc[j] + 1);
                }
            }
        }

        // 감소하는 부분 수열 구하기
        for (int i = n-2; i >= 0; i--) {
            int curValue = arr[i];
            for (int j = i +1; j < n; j++) {
                if (arr[j] < curValue) {
                    dp_desc[i] = Math.max(dp_desc[i], dp_desc[j] + 1);
                }
            }
        }

        int ans = -1;
        for (int i = 0; i < n; i++) {
            // 각 index에 대해서 증가 부분 수열 길이 + 감소 부분 수열 길이 - 1(현재 index가 2번 포함되서 1번은 제외해야 함)
            ans = Math.max(ans, dp_asc[i] + dp_desc[i] - 1);
        }

        System.out.println(ans);

    }
}
