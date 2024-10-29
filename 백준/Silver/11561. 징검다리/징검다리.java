import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static long n;
  static final long start = 0L;
  static final long end = 1000000001L;
  //10000000000000000
  public static void main(String[] args) throws IOException {
    // 첫 점프 -> 아무 거나 다 밟을 수 있음
    // 이후 점프부터는 이전 점프 길이 더 긴 거리 뛰어야함
    // N 징검다리 무조건 밟아야 함
    // 징검다리 1 ~ N 개 있음
    // 밟을 수 있는 징검다리 최대 개수

    // 1부터 쭉 더해서 n을 넘지 않은 가까운 수 구하기
    // k(k+1) < 2 * n -> k를 찾기

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    while (t-- > 0) {
      n = Long.parseLong(br.readLine());
      sb.append(binarySearch()).append("\n");
    }

    System.out.println(sb);
  }

  public static long binarySearch() {
    long s = start;
    long e = end;

    while (s <= e) {
      long mid = (s + e) / 2;
      long calc = (mid * (mid + 1)) / 2;
      if (calc > n) e = mid - 1;
      else if (calc < n) s = mid + 1;
      else return mid;
    }
    return e;
  }

}