
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

// 센서 : 2212
public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int k = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    List<Integer> highway = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
      highway.add(Integer.parseInt(st.nextToken()));
    }
    // 센서 좌표 오름 차순 정렬
    highway.sort(Comparator.comparingInt(o -> o));

    // 센서 사이의 차이 배열
    int[] diff = new int[n - 1];
    for (int i = 0; i < n - 1; i++) {
      diff[i] = highway.get(i + 1) - highway.get(i);
    }

    // 기지국이 k개면 센서들을 k개로 묶는다는 것
    // 그럼 각 묶음 사이의 거리는 무시해도 된다 -> 묶음 사이 간격 개수가 k-1개
    // 간격이 가장 큰 부분들을 묶음 간의 간격으로 만들다

    Arrays.sort(diff);
    int sum = 0;
    for (int i = 0; i < n - k; i++) {
      sum += diff[i];
    }
    System.out.println(sum);

  }

}
