import java.util.*;
import java.io.*;

public class Main {

    static boolean[] visited;
    static int cnt;

    static void DFS(int node) {

        for (int i = 0; i < listArr[node].size(); i++) {
            int curNode = listArr[node].get(i);
            if (visited[curNode]) continue;

            visited[curNode] = true;
            cnt++;
            DFS(curNode);
        }
    }
    
    static int n;
    static int m;
    static ArrayList<Integer>[] listArr;

    public static void main(String[] args) throws IOException {
        // Please write your code here.    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        listArr = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            listArr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            listArr[x].add(y);
            listArr[y].add(x);
        }

        visited = new boolean[n+1];
        
        visited[1] = true;
        DFS(1);

        System.out.println(cnt);
    }
}
