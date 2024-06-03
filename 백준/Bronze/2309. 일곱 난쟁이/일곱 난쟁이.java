
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] height = new int[9];

        int total = 0;
        for (int i = 0; i < 9; i++) {
            height[i] = sc.nextInt();
            total += height[i];
        }

        for (int i = 0; i < 8; i++) {
            boolean find = false;
            for (int j = i+1; j < 9; j++) {
                if ((total - height[i] - height[j]) == 100) {
                    height[i] = 0;
                    height[j] = 0;
                    find = true;
                    break;
                }
            }
            if (find) break;
        }

        Arrays.sort(height);
        for (int i = 2; i < 9; i++) {
            System.out.println(height[i]);
        }


    }

}
