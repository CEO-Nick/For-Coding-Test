
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        while(N --> 0) {
            int T = sc.nextInt();
            int[] H = new int[20];
            for (int j = 0; j < 20; j++){
                H[j] = sc.nextInt();
            }
            
            int[] line = new int[20];
            int cnt = 0;
            line[0] = H[0];
            for (int i = 1; i < 20; i++) {
                 boolean isTall = true;
                for (int j = 0; j < i; j++) {
                    
                    // 1. 내 앞에 나보다 큰 애 있을 때
                    if (line[j] > H[i]) {
                        for (int k = i; k > j; k--) {
                            line[k] = line[k-1];
                            cnt++;
                        }
                        line[j] = H[i];
                        isTall = false;
                        break;
                    }
                }
                if (isTall) line[i] = H[i];
            }

            System.out.println(T + " " + cnt);
        }
    }
}
