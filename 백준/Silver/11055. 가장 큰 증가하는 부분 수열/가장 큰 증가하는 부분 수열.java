
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int n;
  static int[] arr;
  static int[] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    arr = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    dp = new int[n];
    dp[0] = arr[0];
    // i번째 항이 최댓값인 부분 증가 수열의 합
    for (int i = 0; i < n; i++) {
      int std = arr[i];
      dp[i] = std;
      for (int j = 0; j < i; j++) {
        if (arr[j] < std) dp[i] = Math.max(dp[i], dp[j] + arr[i]);
      }
    }

    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      max = Math.max(max, dp[i]);
    }

    System.out.println(max);
  }

}
