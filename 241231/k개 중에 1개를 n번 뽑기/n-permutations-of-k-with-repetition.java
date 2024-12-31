import java.util.*;

public class Main {
    static int k;
    static int n;
    static ArrayList<Integer> list;

    static void print() {
        for (int a : list) System.out.print(a + " ");
        System.out.println();
    }

    public static void choose(int count) {
        if (count == n) {
            print();
            return;
        }

        for (int i = 1; i <= k; i++) {
            list.add(i);
            choose(count+1);
            list.remove(list.size()-1);
        }
    }
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();
        list = new ArrayList<>();

        choose(0);
    }
}