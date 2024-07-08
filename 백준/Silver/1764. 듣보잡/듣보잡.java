import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        HashSet<String> blacklist = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            blacklist.add(name);
        }

        List<String> nameList = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (blacklist.contains(name)) {
                nameList.add(name);
            }
        }

        nameList.sort(String::compareTo);

        bw.write(nameList.size() + "\n");
        for (String s : nameList) {
            bw.write(s + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}