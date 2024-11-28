
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int[] dp1 = new int[n];
    int[] dp2 = new int[n];

    for (int i = 0; i < n; i++) {
      dp1[i] = 1;
      int std = arr[i];

      for (int j = 0; j < i; j++) {
        if (arr[j] < std) dp1[i] = Math.max(dp1[i], dp1[j] + 1);
      }
    }

    for (int i = n - 1; i >= 0; i--) {
      dp2[i] = 1;
      int std = arr[i];

      for (int j = n - 1; j > i; j--) {
        if (arr[j] < std) dp2[i] = Math.max(dp2[i], dp2[j] + 1);
      }

    }


    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      max = Math.max(max, dp1[i] + dp2[i] - 1);
    }

    System.out.println(max);
  }

}
