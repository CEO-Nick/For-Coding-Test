
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] dp = new int[n+6];

    // 11 -> 5 * 1 + 2 * 3
    // 3 -> -1
    for (int i = 0; i <= n+5; i++) {
      dp[i] = Integer.MAX_VALUE;
    }
    dp[2] = 1;
    dp[5] = 1;

    // 2일 때 + 2, + 4, +5, ... min 값 저장하기
    // 5일 때 ...
    //

    int[] coin = new int[] {2, 5};

    for (int i = 2; i <= n; i++) {
      if (dp[i] == Integer.MAX_VALUE) continue;
      for (int j = 0; j < 2; j++) {
        dp[i + coin[j]] = Math.min(dp[i+coin[j]], dp[i] + 1);
      }
    }

    if (dp[n] == Integer.MAX_VALUE) System.out.println(-1);
    else System.out.println(dp[n]);
  }

}
