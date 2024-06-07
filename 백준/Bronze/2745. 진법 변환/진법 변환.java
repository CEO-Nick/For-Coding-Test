
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        char[] N = sc.next().toCharArray();
        int B = sc.nextInt();

        int len = N.length;
        long ans = 0;

        for (int i = 0; i < len; i++) {
            long temp = 0L;
            if ('A' <= N[i] && N[i] <= 'Z') {
                temp = (long) ((N[i] - 'A' + 10) * Math.pow(B, len - i - 1));
            } else {
                temp = (long) ((N[i] - '0') * Math.pow(B, len - i - 1));
            }
            ans += temp;

        }

        System.out.println(ans);
    }
}


