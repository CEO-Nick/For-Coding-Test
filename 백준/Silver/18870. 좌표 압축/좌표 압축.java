import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // Xi를 압축 -> Xi보다 작은 서로 다른 좌표 개수

        int N = sc.nextInt();

        // 각 값에 대한 index 저장
        Set<Integer> set = new TreeSet<>();
        int[] real = new int[N];

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            set.add(x);
            real[i] = x;
        }

        Integer[] array = set.toArray(new Integer[0]);

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], i);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++) {
            bw.write(map.get(real[i]) + " ");
        }
        bw.newLine();
        bw.flush();
        bw.close();

    }
}
