
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        // 중앙값을 매번 뽑아내는 방법
        // 최대 힙 & 최소 힙 2개 사용하기
        // 중앙 값보다 작거나 같은 값을 담는 힙(최대 힙)
        // 중앙 값보다 큰 값을 담는 힙(최소 힙)

        // 처리 순서
            // 1. 2개의 힙에 수를 번갈아가면 넣기(사이즈가 같으면 최대 힙 먼저)
            // 2. 각 힙의 루트에서 수를 뽑은 뒤, 대소 관계를 비교
            // 3. 오른쪽 힙에 더 작은 값이 있다면 위치를 서로 바꾼다.

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        // 왼쪽이 최대힙
        PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
        // 오른쪽이 최소힙
        PriorityQueue<Integer> right = new PriorityQueue<>(Comparator.comparingInt(o -> o));

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            if (left.size() == right.size()) {
                left.offer(sc.nextInt());
            } else {
                right.offer(sc.nextInt());
            }

            if (!left.isEmpty() && !right.isEmpty()) {
                int l = left.peek(); int r = right.peek();
                if (l > r) {
                    left.poll(); right.poll();
                    left.offer(r); right.offer(l);
                }
            }
            sb.append(left.peek()).append("\n");
        }
        System.out.println(sb);
    }
}
