import java.util.*;

public class Main {

    static void recur(int lastNum, int cnt) {
        if (cnt == m) {
            print();
            return;
        }

        for (int i = lastNum; i <= n; i++) {
            list.add(i);
            recur(i + 1, cnt+1);
            list.remove(list.size()-1);
        }
    }

    static void print() {
        for (int a : list) System.out.print(a + " ");
        System.out.println();
    }

    static int n;
    static int m;
    static ArrayList<Integer> list;

    public static void main(String[] args) {
        // Please write your code here.

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        list = new ArrayList<>();
        
        recur(1, 0);
    }
}