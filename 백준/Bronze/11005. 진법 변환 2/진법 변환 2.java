import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int B = sc.nextInt();


        char[] alphabet = new char[26];
        for (int i = 0; i < 26; i++) {
            alphabet[i] = (char) ('A' + i);
        }

        String ans = "";
        while (true) {
            int modular = N % B;
            if (modular < 10) ans += modular;
            else ans += (alphabet[modular-10]);

            N /= B;

            if (N < B) {
                if (N == 0) break;
                if (N < 10) ans += N;
                else ans += (alphabet[N-10]);
                break;
            }
        }

        for (int i = ans.length()-1; i >= 0; i--) {
            System.out.print(ans.charAt(i));
        }
        System.out.println();

    }
}


