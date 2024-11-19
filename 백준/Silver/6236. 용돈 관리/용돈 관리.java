
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int n;
  static int m;

  static int[] money;

  public static void main(String[] args) throws IOException {
    // M번 인출
    // K원 인출, 하루 다 보낼 수 있으면 그대로 사용, 모자라면 남은 금액 입금 & K원 인출
    // K를 최소화하자
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    money = new int[n];
    int total = 0;
    for (int i = 0; i < n; i++) {
      money[i] = Integer.parseInt(br.readLine());
      total += money[i];
    }

    int start = 0, end = total + 1;
    int ans = -1;
    while (start <= end) {
      // mid가 k원을 의미함
      int mid = (start + end) / 2;

      if (canUse(mid)) {
        ans = mid;
        end = mid - 1;
      } else {  // k원이 작아서 m번 이상 인출하거나, 하루에 쓸 돈 조차 커버가 안됨
        start = mid + 1;
      }
    }

    System.out.println(ans);

  }

  static boolean canUse(int oneDay) {
    int count = 1;
    int cur = oneDay;

    for (int amount : money) {
      // 하루 쓸 돈이 인출한 금액보다 크면 안됨
      if (amount > oneDay) return false;

      // 오늘 쓸 돈이 남은 돈보다 많음
      if (amount > cur) {
        // 이미 M번 인출함
        if (count == m) return false;

        count++;
        cur = oneDay;
      }

      cur -= amount;
    }

    return true;
  }

}

