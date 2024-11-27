import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
   
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[] arr = new int[n];
    for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());

    int[] dp = new int[n];
    for (int i = 0; i < n; i++) {
      dp[i] = 1;
      int std = arr[i];
      for (int j = 0; j < i; j++) {
        if (arr[j] < std) dp[i] = Math.max(dp[i], dp[j] + 1);
      }
    }

    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      max = Math.max(max, dp[i]);
    }
    System.out.println(n-max);

  }

}
