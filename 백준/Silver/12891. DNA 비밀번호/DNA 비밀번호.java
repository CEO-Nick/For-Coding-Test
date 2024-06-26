
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // dna 문자열의 부분문자열을 비밀번호로
        // 조건 각 염기서열 x개 이상씩 등장하는 부분문자열만 비밀번호로 가능
        // 같은 부분문자열이라도 idx가 다르면 다른걸로 취급

        int S = sc.nextInt();
        int P = sc.nextInt();

        char[] array = sc.next().toCharArray();

        int a = sc.nextInt();
        int c = sc.nextInt();
        int g = sc.nextInt();
        int t = sc.nextInt();

        int j = P - 1;
        int countA = 0, countC = 0, countG = 0, countT = 0;
        int ans = 0;
        // 0 ~ P-1 부분문자열의 각 개수 구하기
        for (int i = 0; i < P; i++) {
            if (array[i] == 'A') countA++;
            else if (array[i] == 'C') countC++;
            else if (array[i] == 'G') countG++;
            else if (array[i] == 'T') countT++;
        }
        if (countA >= a && countC >= c && countG >= g && countT >= t) ans++;

        for (int i = 1; i < S-P+1; i++) {
            // 이전 염기서열 개수 빼기
            char temp = array[i - 1];
            if (temp == 'A') countA--;
            else if (temp == 'C') countC--;
            else if (temp == 'G') countG--;
            else if (temp == 'T') countT--;

            // 마지막 염기서열 추가하기
            temp = array[++j];
            if (temp == 'A') countA++;
            else if (temp == 'C') countC++;
            else if (temp == 'G') countG++;
            else if (temp == 'T') countT++;

            if (countA >= a && countC >= c && countG >= g && countT >= t) ans++;
        }

        System.out.println(ans);

    }

}
