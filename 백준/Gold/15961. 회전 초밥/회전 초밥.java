import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // 한 위치에서 k개 접시 연속 -> 할인
        // 쿠폰에 적힌 초밥 하나 무료 제공 -> 이 번호 적히 초밥 현재 벨트 위에 없으면 새로 만들어 제공

        // 가능한 다양한 종류 초밥
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            Integer cnt = map.getOrDefault(arr[i], 0);
            map.put(arr[i], cnt+1);
        }
        int max;
        if (map.containsKey(c)) max = map.size();
        else max = map.size() + 1;
        int l = 0;
        int r = k;
        while (r != k-1) {
            Integer removeCnt = map.get(arr[l]);
            if (removeCnt == 1) map.remove(arr[l]);
            else map.put(arr[l], removeCnt-1);

            map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);

            if (map.containsKey(c)) max = Math.max(max, map.size());
            else max = Math.max(max, map.size() + 1);

            l = (l + 1) % n;
            r = (r + 1) % n;
        }

        System.out.println(max);
    }
}
