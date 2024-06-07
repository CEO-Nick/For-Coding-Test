
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int S1 = sc.nextInt();
        int S2 = sc.nextInt();
        int S3 = sc.nextInt();

        int[] sumCount = new int[S1+S2+S3+1];

        int max = 0;
        int maxIndex = 0;
        for (int i = 1; i <= S1; i++) {
            for (int j = 1; j <= S2; j++) {
                for (int k = 1; k <= S3; k++) {
                    int temp = i + j + k;
                    sumCount[temp] += 1;
                    if (sumCount[temp] > max) {
                        max = sumCount[temp];
                        maxIndex = temp;
                    }
                }
            }
        }

        System.out.println(maxIndex);

    }
}


