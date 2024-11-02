
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int n;
  static int m;
  static int[] heights;
  static long ans = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    heights = new int[n];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      heights[i] = Integer.parseInt(st.nextToken());
    }

    binarySearch();

    System.out.println(ans);
  }

  static void binarySearch() {
    long start = 0L, end = Long.MAX_VALUE;

    while (start <= end) {
      long mid = (start + end) / 2;
      long sum = calc(mid);

      if (sum >= m) {
        ans = mid;
        start = mid + 1;
      }
      else end = mid - 1;

    }
  }

  public static long calc(long std) {
    long sum = 0;
    for (int i = 0; i < n; i++) {
      if (heights[i] > std) {
        sum += heights[i] - std;
      }
    }
    return sum;
  }
}
