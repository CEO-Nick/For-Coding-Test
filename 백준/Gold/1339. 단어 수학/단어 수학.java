import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        int maxLength = -1;
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
            maxLength = Math.max(maxLength, words[i].length());
        }

        HashMap<Character, Integer> toNum = new HashMap<>(26);
        HashMap<Character, Integer> weights = new HashMap<>(26);

        // 알파벳별 가중치 구하기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                char key = words[i].charAt(j);
                int weight = (int) Math.pow(10, words[i].length() - j - 1);
                if (!weights.containsKey(key)) weights.put(key, weight);
                else weights.put(key, weights.get(key) + weight);
            }
        }

        // 가중치 큰 순서대로 9부터 0까지 할당
        int number = 9;
        ArrayList<Entry<Character, Integer>> list = new ArrayList<>(weights.entrySet());
        list.sort(Map.Entry.comparingByValue());
        for (int i = list.size() - 1; i >= 0  ; i--) {
            Entry<Character, Integer> entry = list.get(i);
            toNum.put(entry.getKey(), number--);
        }

        long ans = 0;
        for (int i = 0; i < N; i++) {
            String word = words[i];
            int num = 0;
            for (int j = 0; j < word.length(); j++) {
                int cal = toNum.get(word.charAt(j)) * (int) Math.pow(10, (word.length() - j - 1));
                num += cal;
            }
            ans += num;
        }

        System.out.println(ans);
        br.close();
    }
}
