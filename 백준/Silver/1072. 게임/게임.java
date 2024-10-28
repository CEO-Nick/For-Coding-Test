import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static long x;
  static long y;
  static long z;

  public static void main(String[] args) throws IOException {
    // 소수점 버림
    // 절대 변하지 않는다면 -1 출력 -> 이미 정답률이 100퍼인 경우

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] inputs = br.readLine().split(" ");
    x = Long.parseLong(inputs[0]);
    y = Long.parseLong(inputs[1]);
    z = (long) ((double) y * 100) / x;

    // 절대 변하지 않는 경우
    if (z >= 99 || x == y) {
      System.out.println(-1);
      return;
    }

    long ans = binarySearch(0, Long.MAX_VALUE);
    System.out.println(ans);
  }

  public static long binarySearch(long start, long end) {
    long mid = 0;
    while (start <= end) {
      mid = (start + end) / 2;
      long new_total = x + mid;
      long new_win = y + mid;
      long newWinRate = (long) (((double) new_win * 100) / new_total);
      if (newWinRate < z+1) start = mid + 1;
      else end = mid - 1;
    }
    return start;
  }

}
