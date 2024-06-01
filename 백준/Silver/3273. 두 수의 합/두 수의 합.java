
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        int x = sc.nextInt();

        int result = 0;
        // 두 수의 합이 13을 만족하는 pair 구하기
        for (int i = 0; i < n - 1; i++) {
            if (array[i] >= x) continue;

            int target = x - array[i];
            for (int j = i+1; j < n; j++) {
                if (target == array[j]) {
                    result++;
                    break;  // 뒤에 또 같은 array[j] 값이 나올 일이 없음 (서로 다른 정수 수열이니까)
                }
            }
        }

        System.out.println(result);

    }

}
