import sys
sys.setrecursionlimit(10**8)
input = sys.stdin.readline
T = int(input())


def in_range(x,y):
        return 0 <= x and x < N and 0 <= y and y < M
    
def can_go(nx, ny):
    if not in_range(nx, ny):
        return False
    if grid[nx][ny] == 0:
        return False
    return True

def dfs(x, y):
    grid[x][y] = 0
    dxs, dys = [1, -1, 0, 0], [0, 0, 1, -1]
    for dx, dy in zip(dxs, dys):
        nx, ny = x + dx, y + dy
        if can_go(nx, ny):
            dfs(nx, ny)


for _ in range(T):
    M, N, K = map(int, input().split())

    grid = [[0] * M for _ in range(N)]
    # print("grid")
    # for arr in grid:
    #     print(arr)
    for _ in range(K):
        y, x = map(int, input().split())
        grid[x][y] = 1

    # for arr in grid:
    #     print(arr)
    cnt = 0
    
    for i in range(N):
        for j in range(M):
            if grid[i][j] == 0:
                continue
            dfs(i, j)
            cnt += 1

    print(cnt)
                
        

    
