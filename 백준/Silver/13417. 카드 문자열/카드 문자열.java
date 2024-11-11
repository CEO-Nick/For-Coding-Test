
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class Main {
  static int n;
  static String[] cards;
  static Deque<String> deque;
  public static void main(String[] args) throws IOException {

    // 처음에는 그냥 가져오고
    // 그 다음에 가져올 때는 내 앞에 카드 중 가장 왼쪽의 알파벳과 비교
      // 작으면 가장 왼쪽에 두고 크면 가장 오른쪽에 둔다

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    while (t-- > 0) {
      n = Integer.parseInt(br.readLine());
      cards = br.readLine().split(" ");
      deque = new ArrayDeque<>(n);

      for (int i = 0; i < n; i++) {
        if (deque.isEmpty()) {
          deque.add(cards[i]);
          continue;
        }
        // 비교 결과가 음수면 card[i]가 앞의 알파벳이라는 의미 (0이면 동일하다)
        if (cards[i].compareTo(deque.getFirst()) <= 0) {
          deque.addFirst(cards[i]);
        } else deque.addLast(cards[i]);
      }

      Iterator<String> iterator = deque.iterator();
      for (int i = 0; i < n; i++) {
        sb.append(iterator.next());
      }
      sb.append("\n");
    }
    System.out.println(sb);

  }

}
