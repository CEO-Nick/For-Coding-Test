import java.util.*;

public class Main {

    static char[] input;
    static int size;
    static int max = Integer.MIN_VALUE;

    static Map<Character, Integer> map;
    static Set<Character> alph;
    static List<Character> list;

    static void recur(int idx) {
        if (idx == size) {
            int res = calculate();
            max = Math.max(max, res);
            return;
        }

        for (int i = 1; i <= 4; i++) {
            map.put(list.get(idx), i);
            recur(idx+1);
            map.remove(list.get(idx));
        }
    }

    static int calculate() {
        int cur = map.get(input[0]);
        for (int i = 1; i < input.length - 1; i += 2) {
            switch (input[i]) {
                case '-':
                    cur -= map.get(input[i+1]);
                    break;
                case '+':
                    cur += map.get(input[i+1]);
                    break;
                case '*':
                    cur *= map.get(input[i+1]);
                    break;
            }
        }

        return cur;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        input = sc.next().toCharArray();
        
        alph = new HashSet<>();
        for (int i = 0; i < input.length; i += 2) {
            alph.add(input[i]);
        }
        list = new ArrayList<>(alph);
        map = new HashMap<>();
        size = list.size();

        recur(0);
        System.out.println(max);
    }
}