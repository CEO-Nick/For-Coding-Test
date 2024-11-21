
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int n;
  static int[][] dice;

  public static void main(String[] args) throws IOException {
    /*
    주사위 쌓기 1번 주사위(맨 아래) ~ 6번 주사위(맨위)
    붙어있는 면 -> 숫자 같아야 함
    마주보는 면
      idx 0 <-> idx 5
      idx 1 <-> idx 3
      idx 2 <-> idx 4
    1번 주사위 정하면 쭈루룩 n번 주사위까지 정해짐
    그럼 각 주사위에서 아래 위 면 제외하고 최댓값을 더하고 그 최댓값 중 최댓값을 구하면 된다
     */


    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    n = Integer.parseInt(br.readLine());
    dice = new int[n][6];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 6; j++) {
        dice[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int maxSum = Integer.MIN_VALUE;
    // 1번 주사위 윗면 고르기
    for (int i = 0; i < 6; i++) {
      // 2번 주사위부터 n번 주사위까지 각 옆면의 최댓값들의 합
      int sum = sum(dice[0][i]);
      // 1번 주사위의 옆 면 중 최댓값 누적
      sum += maxWithOutUD(0, i);
      maxSum = Math.max(maxSum, sum);
    }

    System.out.println(maxSum);
  }

  static int sum(int stuckNum) {
    int sum = 0;
    for (int i = 1; i < n; i++) {
      int idx = 0;
      // 붙어있는 면 찾기
      for (int j = 0; j < 6; j++) {
        if (dice[i][j] == stuckNum) {
          idx = j;
          stuckNum = dice[i][otherSideIdx(idx)];
          break;
        }
      }

      // 최댓값 누적하기
      sum += maxWithOutUD(i, idx);
    }
    return sum;
  }

  static int otherSideIdx(int idx) {
    if (idx == 0) return 5;
    else if (idx == 1) return 3;
    else if (idx == 2) return 4;
    else if (idx == 3) return 1;
    else if (idx == 4) return 2;
    else return 0;
  }

  // i번째 주사위의 idx와 idx 맞은편을 제외한 4면 중 최댓값 구하기
  static int maxWithOutUD(int i, int idx) {
    int max = Integer.MIN_VALUE;
    for (int j = 0; j < 6; j++) {
      if (j == idx || j == otherSideIdx(idx)) continue;
      max = Math.max(max, dice[i][j]);
    }
    return max;
  }
}