import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static boolean[] visited;
    static ArrayList<Integer> list;

    static void choose(int cnt) {
        if (cnt == n) {
            print();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            list.add(i);

            choose(cnt+1);

            visited[i] = false;
            list.remove(list.size()-1);
        }
    }

    static void print() {
        for (int num : list) System.out.print(num + " ");
        System.out.println();
    }


    public static void main(String[] args) throws IOException {
        // Please write your code here.
        // 점 m개 선택 -> 그 중 가장 먼 2개의 점 거리 구하기 -> 그게 최소 값이 되도록
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        list = new ArrayList<>();

        choose(0);
    }
}