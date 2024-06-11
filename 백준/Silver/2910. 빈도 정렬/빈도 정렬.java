import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int C = sc.nextInt();

        // 삽입 순서 유지하기 위해 LinkedHashMap 사용
        Map<Integer, Integer> messages = new LinkedHashMap<>();
        for (int i = 0; i < N; i++) {
            int message = sc.nextInt();
            messages.put(message, messages.getOrDefault(message, 0) + 1);
        }

        Integer[] frequencies = messages.keySet().toArray(new Integer[0]);

        // key에 대한 value가 큰 게 앞으로 = 빈도 수가 높은게 앞으로
        // 근데 Integer 배열이니깐 stable하게
        Arrays.sort(frequencies, (o1, o2) -> messages.get(o2) - messages.get(o1));

        for (int frequency : frequencies) {
            int count = messages.get(frequency);
            while (count-- > 0) {
                System.out.printf("%d ", frequency);
            }
        }

    }

}
