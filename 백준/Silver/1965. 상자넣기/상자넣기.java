
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    // 앞 상자가 작으면 뒷 상자에 넣을 수 있음
    // 1, 5, 2, 3, 7 -> 5
    // 1,2,3,7 -> 4개의 상자를 한 상자에 들어가게 된다
    // 한 상자에 넣을 수 있는 최대 상자 개수

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] boxes = new int[n];
    int[] dp = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      boxes[i] = Integer.parseInt(st.nextToken());
    }

    // 각 상자가 최대 크기의 상자인 경우, 넣을 수 있는 박스 개수 세기
    // dp에 들어갈 값 = 현재 박스가 최대인 경우 들어갈 수 있는 박스 개수
    for (int i = 0; i < n; i++) {
      dp[i] = 1;
      int std = boxes[i];
      for (int j = 0; j < i; j++) {
        if (boxes[j] < std) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }

    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      max = Math.max(max, dp[i]);
    }
    System.out.println(max);
  }

}
