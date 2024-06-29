
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // 회문 -> 0, 유사회문 -> 1, 그 외 -> 2
        // 유사회문은 한 문자 삭제하면 회문 되는 경우

        int N = sc.nextInt();
        int[] ans = new int[N];
        int idx = 0;
        while (N-- > 0) {
            char[] temp = sc.next().toCharArray();
            ans[idx++] = checkPalindrome(temp);
        }

        for (int n : ans) {
            System.out.println(n);
        }


    }

    private static int checkPalindrome(char[] temp) {
        int leftIdx = 0, rightIdx = temp.length - 1;
        int leftAns = 0;
        // 다를 때, 왼쪽을 움직이는 경우
        while (leftIdx < rightIdx) {
            if (temp[leftIdx] == temp[rightIdx]) {
                leftIdx++;
                rightIdx--;
            } else {
                leftIdx++;
                leftAns++;
            }
        }
        leftIdx = 0;
        rightIdx = temp.length - 1;
        int rightAns = 0;
        // 다를 때, 오른쪽을 움직이는 경우
        while (leftIdx < rightIdx) {
            if (temp[leftIdx] == temp[rightIdx]) {
                leftIdx++;
                rightIdx--;
            } else {
                rightIdx--;
                rightAns++;
            }
        }
        if (leftAns == 0 && rightAns == 0) return 0;
        if (Math.min(leftAns, rightAns) >= 2) return 2;
        return 1;
    }
}
