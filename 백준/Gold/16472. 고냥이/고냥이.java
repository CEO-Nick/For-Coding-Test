
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // 문자열 중 최대 N개의 종류의 알파벳을 가진 연속된 문자열만 인식
        // 이 번역기가 인식할 수 있는 최대 문자열 길이

        int N = sc.nextInt();
        char[] array = sc.next().toCharArray();

        HashMap<Character, Integer> checked = new HashMap<>();
        int j = 0;
        int ans = -1;
        for (int i = 0; i < array.length; i++) {
            while (j < array.length) {
                char alphabet = array[j];

                // 현재 알파벳 종류 최대 개수 & 다음 알파벳 다른 알파벳임 -> stop
                if (checked.size() == N && !checked.containsKey(alphabet)) break;

                // alphabet이 없으면 1 넣고, 있으면 현재 값++
                checked.merge(alphabet, 1, Integer::sum);

                j++;
            }
            ans = Math.max(ans, j - i);

            // 1개 이상 있으면 개수--, 1개 이하라면 키를 삭제
            if (checked.get(array[i]) > 1) {
                Integer value = checked.get(array[i]) - 1;
                checked.put(array[i], value);
            } else {
                checked.remove(array[i]);
            }

        }
        System.out.println(ans);
    }
}
