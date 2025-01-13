import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        long[] S = new long[n];
        long[] count = new long[m];
        
        long answer = 0;
        
        S[0] = sc.nextInt();
        for (int i = 1; i < n; i++) {
            S[i] = S[i-1] + sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int remainder = (int) (S[i] % m);
            
            if (remainder == 0) answer++;

            count[remainder]++;
        }

        for (int i = 0; i < m; i++) {
            if (count[i] > 1) {
                answer += (count[i] * (count[i]-1) / 2);  // nC2 구하는 공식 
            }
        }
        
        System.out.println(answer);

    }

}
