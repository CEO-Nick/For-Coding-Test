import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        // 찾으려는 단어만큼 substring 으로 추출해서 비교
        // 일치하면 해당 길이만큼 건너뛰기
        // 다르면 다음으로 넘어가기

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String doc = br.readLine();
        String word = br.readLine();
        int len = word.length();
        int answer = 0;

        int idx = 0;
        while (idx < doc.length()) {
            int endIdx = Math.min(doc.length(), idx + len);
            String temp = doc.substring(idx, endIdx);
            if (word.equals(temp)) {
                answer++;
                idx += len;
            } else {
                idx++;
            }
        }

        System.out.println(answer);
    }

}
