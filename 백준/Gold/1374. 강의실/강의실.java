
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    StringTokenizer st;
    List<Integer> startList = new ArrayList<>(n);
    List<Integer> endList = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int lecture = Integer.parseInt(st.nextToken());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      startList.add(start);
      endList.add(end);
    }

    startList.sort(Comparator.comparingInt(o -> o));
    endList.sort(Comparator.comparingInt(o -> o));
    int startIdx = 0;
    int endIdx = 0;

    int room = 0;
    int maxRoom = Integer.MIN_VALUE;

    while (startIdx < n) {
      if (startList.get(startIdx) < endList.get(endIdx)) {
        room++;
        startIdx++;
      } else {
        room--;
        endIdx++;
      }
      maxRoom = Math.max(maxRoom, room);
    }
    System.out.println(maxRoom);

  }

}
