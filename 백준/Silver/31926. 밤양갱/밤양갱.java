
import java.util.Scanner;

// 밤양갱 : 31926
public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    // 첫 달디달고 만드는데 소요되는 시간 8초
    int count = 8;
    for (int i = 1; ; i++) {
      if (n - Math.pow(2, i) == 0) {
        count = count + i + 2; // 달디단 만드는데 2초 걸림 dalida + n
        break;
      } else if (n - Math.pow(2, i) < 0) {
        count = count + i + 1; // 달디단 만드는데 n만 추가하면 되서 1초 소모된다.
        break;
      }
    }
    System.out.println(count);
  }
}

