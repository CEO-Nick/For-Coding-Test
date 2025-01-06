import java.util.*;

public class Main {

    static int min = Integer.MAX_VALUE;

    static void recur(int idx, int count) {
        if (idx == n-1) {
            min = Math.min(min, count);
            return;
        } 

        int canJump = arr[idx];
        for (int i = 1; i <= canJump; i++) {
            int next = idx + i;
            if (next < n) {
                recur(next, count + 1);
            }
        }
    }

    static int n;
    static int[] arr;

    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        recur(0, 0);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
}