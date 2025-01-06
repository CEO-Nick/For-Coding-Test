import java.util.*;
import java.io.*;

public class Main {
    
    // static boolean first = false;

    static void recur(int idx) {
        if (idx == n) {
            for (int a : list) System.out.print(a);
            System.exit(0);
            // return;
        }

        for (int i = 4; i <= 6; i++) {
            // 애초에 연속된 숫자는 안만들기
            // if (idx > 0 && list.get(idx-1) == i) continue;
            
            list.add(i);
            if (isPossible()) recur(idx+1);
            list.remove(list.size()-1);
            
        }
    }

    static boolean isPossible() {
        for (int len = list.size()/2; len >= 1; len--) {
            for (int i = 0; i < list.size(); i++) {
                // 2번째 부분 수열이 범위를 벗어나는 경우
                if (i + len * 2 > list.size()) {
                    break;
                }

                // 연속된 두 부분수열이 동일한지 확인
                if (list.subList(i, i + len).equals(list.subList(i + len, i + len*2))) {
                    return false;
                }
            }
        }

        return true;
    }

    static int n;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new ArrayList<>(n);

        if (n == 1) {
            System.out.println(4);
            return;
        }
        recur(0);
    }
}
