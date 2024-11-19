
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static int n;
  static int m;
  static int[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    arr = new int[n];
    for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());

    Arrays.sort(arr);

    int j = 0;
    int ans = Integer.MAX_VALUE;

    for (int i = 0; i < n; i++) {
      while (arr[j] - arr[i] < m && j < n-1) {
        j++;
      }
      int diff = arr[j] - arr[i];
      if (diff >= m) ans = Math.min(ans, diff);
    }

    System.out.println(ans);

  }
}
