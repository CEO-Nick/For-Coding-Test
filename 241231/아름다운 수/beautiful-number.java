import java.util.*;

public class Main {
    static int n;

    static int ans = 0;
    static ArrayList<Integer> list;

    static boolean isBeautilful() {
        for (int i = 0; i < n; i++) {
            int cur = list.get(i);
            int count = 0;
            int curIdx = i;
            
            while (curIdx < n && list.get(curIdx) == cur) {
                count++;
                curIdx++;
            }
            
            // 동일한 숫자만 존재하는 경우
            if (i == 0 && curIdx == n) {
                count %= cur;
                if (count == 0) {
                    return true;
                }
                else return false;
            }

            if (cur == 1) continue;

            if (count != cur && count % cur != 0) {
                return false;
            }

            // while문에서 읽은만큼 건너뛰기
            i = curIdx-1;
        }

        return true;
    }

    static void makeNum(int cnt) {
        if (cnt == n) {
            
            if (isBeautilful()) {
                // for (int i = 0; i < n; i++) System.out.print(list.get(i));
                // System.out.println();
                ans++;
            }
            return;
        }

        for (int i = 1; i <= 4; i++) {
            list.add(i);
            makeNum(cnt+1);
            list.remove(list.size()-1);
        }

    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        list = new ArrayList<>();
        makeNum(0);
        System.out.println(ans);
    }
}