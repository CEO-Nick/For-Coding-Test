
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n-- > 0) {
            int k = sc.nextInt();
            System.out.println(isSumOfThreeTriangularNumbers(k));
        }
    }

    private static int isSumOfThreeTriangularNumbers(int k) {
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= k; j++) {
                for (int l = 1; l <= k; l++) {
                    int ti = i*(i+1)/2;
                    int tj = j*(j+1)/2;
                    int tl = l*(l+1)/2;

                    if (k == (ti+tj+tl)) return 1;
                }
            }
        }

        return 0;
    }

}
