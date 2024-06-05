
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 정문에서 가장 짧은 거리 방을 선호
        int T = sc.nextInt();
        while(T-- > 0) {
            int H = sc.nextInt(); // 층 수
            int W = sc.nextInt(); // 각 층의 방 수
            int N = sc.nextInt(); // 몇 번째 손님인지

            int floor;
            int roomNum;

            if (N % H == 0) {
                floor = H;
                roomNum = N / H;
            } else {
                floor = N % H;
                roomNum = (N / H) + 1;
            }

            String ans = "";
            ans += floor;

            if (roomNum < 10) {
                ans += ("0" + roomNum);
            } else {
                ans += roomNum;
            }

            System.out.println(ans);

        }
    }
}


