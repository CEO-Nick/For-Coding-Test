import java.util.Scanner;
import java.util.Queue;
import java.util.ArrayDeque;

class Point {
    int x, y;
    public Point(int x, int y) { 
        this.x = x; 
        this.y = y; 
    } 
}

public class Main {
    public static final int MAX_M = 200;
    public static final int MAX_N = 200;
    public static final int DIR_NUM = 4;

    public static final int WATER = 0;
    public static final int GLACIER = 1;
    
    // 전역 변수 선언:
    public static int n, m;
    
    public static int[][] a = new int[MAX_N][MAX_M];
    
    // bfs에 필요한 변수들 입니다.
    public static Queue<Point> q = new ArrayDeque<>();
    public static boolean[][] visited = new boolean[MAX_N][MAX_N];
    public static int cnt;
    
    public static int[] dx = new int[]{1, -1, 0, 0};
    public static int[] dy = new int[]{0, 0, 1, -1};
    
    // 소요 시간과 가장 마지막으로 녹은 빙하의 수를 저장합니다.
    public static int elapsedTime, lastMeltCnt;
    
    // 범위가 격자 안에 들어가는지 확인합니다.
    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
    
    // 범위를 벗어나지 않으면서 물이여야 하고 방문한 적이 없어야 갈 수 있습니다.
    public static boolean canGo(int x, int y) {
        return inRange(x, y) && a[x][y] == WATER && !visited[x][y];
    }
    
    // visited 배열을 초기화합니다.
    public static void initialize() {
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                visited[i][j] = false;
    }
    
    // 빙하에 둘러쌓여 있지 않은 물들을 전부 구해주는 BFS입니다.
    // 문제에서 가장자리는 전부 물로 주어진다 했기 때문에
    // 항상 (0, 0)에서 시작하여 탐색을 진행하면
    // 빙하에 둘러쌓여 있지 않은 물들은 전부 visited 처리가 됩니다.
    public static void BFS() {
        // BFS 함수가 여러 번 호출되므로
        // 사용하기 전에 visited 배열을 초기화 해줍니다.
        initialize();
    
        // 항상 (0, 0)에서 시작합니다.
        q.add(new Point(0, 0));
        visited[0][0] = true;
    
        while(!q.isEmpty()) {
            // queue에서 가장 먼저 들어온 원소를 뺍니다.
            Point currPos = q.poll();
            int x = currPos.x, y = currPos.y;
    
            // queue에서 뺀 원소의 위치를 기준으로 4 방향을 확인합니다.
            for(int dir = 0; dir < DIR_NUM; dir++) {
                int nx = x + dx[dir], ny = y + dy[dir];
    
                // 더 갈 수 있는 곳이라면 Queue에 추가합니다.
                if(canGo(nx, ny)) {
                    q.add(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }
    
    // 현재 위치를 기준으로 인접한 영역에
    // 빙하에 둘러쌓여 있지 않은 물이 있는지를 판단합니다.
    public static boolean outsideWaterExistInNeighbor(int x, int y) {
        for(int dir = 0; dir < DIR_NUM; dir++) {
            int nx = x + dx[dir], ny = y + dy[dir];
            if(inRange(nx, ny) && visited[nx][ny])
                return true;
        }
    
        return false;
    }
    
    // 인접한 영역에 빙하에 둘러쌓여 있지 않은 물이 있는 빙하를 찾아 녹여줍니다.
    public static void melt() {
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                if(a[i][j] == GLACIER && 
                   outsideWaterExistInNeighbor(i, j)) {
                    a[i][j] = WATER;
                    lastMeltCnt++;
                }
    }
    
    // 빙하를 한 번 녹입니다.
    public static void simulate() {
        elapsedTime++;
        lastMeltCnt = 0;
    
        // 빙하에 둘러쌓여 있지 않은 물의 위치를 전부 
        // visited로 체크합니다.
        BFS();
    
        // 인접한 영역에 빙하에 둘러쌓여 있지 않은 물이 있는 빙하를 찾아
        // 녹여줍니다.
        melt();
    }
    
    // 빙하가 아직 남아있는지 확인합니다.
    public static boolean glacierExist() {
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                if(a[i][j] == GLACIER)
                    return true;
    
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                a[i][j] = sc.nextInt();
        
        do {
            // 빙하를 한 번 녹입니다. 
            simulate();
        } while(glacierExist()); // 빙하가 존재하는 한 계속 반복합니다.

        // 출력:
        System.out.print(elapsedTime + " " + lastMeltCnt);
    }
}
