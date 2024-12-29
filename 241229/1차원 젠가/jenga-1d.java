import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int s1 = sc.nextInt() - 1;
        int e1 = sc.nextInt() - 1;
        int s2 = sc.nextInt() - 1;
        int e2 = sc.nextInt() - 1;

        int[] tmp = new int[n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (i >= s1 && i <= e1) continue;
            tmp[idx++] = arr[i];
        }
        arr = tmp;
        tmp = new int[n];

        int idx2 = 0;
        for (int i = 0; i < idx; i++) {
            if (i >= s2 && i <= e2) continue;
            tmp[idx2++] = arr[i];
        }
        arr = tmp;

        System.out.println(idx2);
        for (int i = 0; i < idx2; i++) {
            System.out.println(arr[i]);
        }
        

    }
}