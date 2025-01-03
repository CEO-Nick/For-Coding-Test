import java.util.*;

public class Main {

    static int k;
    static int n;
    static ArrayList<Integer> list = new ArrayList<>();
 
    static void print() {
        int len = list.size();
        // if (len >= 3) {
        //     for (int i = 2; i < len; i++) {
        //         if (list.get(i) == list.get(i-1) && list.get(i-1) == list.get(i-2)) return;
        //     }   
        // } 

        for (int i = 0; i < len; i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        return;   
    }

    static void recur(int count) {
        if (count == n) {
            print();
            return;
        }

        for (int i = 1; i <= k; i++) {
            if (count >= 2 && 
                i == list.get(list.size() - 1) && 
                i == list.get(list.size() - 2)) 
                continue;
                
            list.add(i);
            recur(count+1);
            list.remove(list.size()-1);
        }
        
    }

    public static void main(String[] args) {
        // Please write your code here.

        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();

        recur(0);

    }
}