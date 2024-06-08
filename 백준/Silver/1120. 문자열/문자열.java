
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");

        String A = input[0];
        String B = input[1];

        // A와 B 비교 후 차이가 최소가 되는 값을 찾는다면, 
        // 나머지 부분은 B와 같도록 A의 앞뒤에 알파벳 붙여준다고 가정하면 된다
        
        int min = 51;
        for (int i = 0; i <= B.length() - A.length(); i++) {
            int count = 0;
            for (int j = 0; j < A.length(); j++) {
                if (A.charAt(j) != B.charAt(i+j)) count++;
            }
            min = Math.min(min, count);
        }

        System.out.println(min);
    }
}


