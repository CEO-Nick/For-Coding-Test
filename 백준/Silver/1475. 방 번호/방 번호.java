import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String num = String.valueOf(n);

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : num.toCharArray()) {
            if (c == '6') c = '9';
            Integer count = map.getOrDefault(c, 0);
            map.put(c, count+1);
        }

        int max = Integer.MIN_VALUE;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int cnt;
            if (entry.getKey() == '9') {
                if (entry.getValue() % 2 == 0) cnt = entry.getValue() / 2;
                else cnt = (entry.getValue() / 2) + 1;
            }
            else cnt = entry.getValue();

            max = Math.max(max, cnt);
        }

        System.out.println(max);
    }
}
