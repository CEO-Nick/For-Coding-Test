
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

    static class Member {
        int age;
        String name;

        Member(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Member[] list = new Member[N];

        for (int i = 0; i < N; i++) {
            list[i] = new Member(sc.nextInt(), sc.next());
        }

        // 참조 자료형의 배열은 stable 이기에 위상이 같은 경우 순서를 보장해준다
        // 애초에 입력이 가입 순서대로 주어지기에 알아서 age가 같은 경우 순서가 보장된다
        Arrays.sort(list, (Comparator.comparingInt(o -> o.age)));

        for (Member m : list) {
            System.out.printf("%d %s\n", m.age, m.name);
        }
    }

}
