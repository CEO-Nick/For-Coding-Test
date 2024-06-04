import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static int isPalindrome(int num) {
        for (int i = 2; i <= 64; i++) {
            int number = num;
            boolean same = true;

            // i진법으로 변환(역순으로 되어있지만 상관 없음)
            String changedNum = changeNumToiFormation(number, i);

            // 회문인 수인지 확인
            char[] array = changedNum.toCharArray();
            int length = array.length;
            for (int j = 0; j < (length / 2); j++) {
                if (array[j] != array[length - 1 - j]) {
                    same = false;
                    break;
                }
            }

            // 회문이면 return 1
            if (same) {
                return 1;
            }
        }

        // 2진법부터 64진법까지 변환 후 회문 검사 모두 실패 시 return 0
        return 0;
    }

    private static String changeNumToiFormation(int number, int i) {
        String ans = "";
        while (number > 0) {
            int modular = number % i;
            if (modular < 10) ans += modular;
            else ans += ((char)('A' + modular));

            number /= i;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while(T-- > 0) {
            // 각 수에 대해서 2~64진법으로 변환하고 회문인지 체크하기
            System.out.println(isPalindrome(sc.nextInt()));
        }
    }
}


