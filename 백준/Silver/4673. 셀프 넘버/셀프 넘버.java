
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {

    public static boolean d(int n) {
        for (int i = 1; i < n; i++) {
            String temp = String.valueOf(i);
            int sum = i;
            for (int j = 0; j < temp.length(); j++) {
                char c = temp.charAt(j);
                sum += (c - '0');
            }
            if (sum == n) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {

        for (int i = 1; i <= 10000; i++) {
            if (d(i)) continue;
            System.out.println(i);
        }
    }
}


