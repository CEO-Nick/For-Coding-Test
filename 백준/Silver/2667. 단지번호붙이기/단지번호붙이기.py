N = int(input())

grid = []
for _ in range(N):
    grid.append(list(map(int, input())))

visited = [[False] * N for _ in range(N)]

cnt = 0

def in_range(x, y):
    return 0 <= x and x < N and 0 <= y and y < N

def can_go(nx, ny):
    if not in_range(nx, ny):
        return False
    if visited[nx][ny] or grid[nx][ny] == 0:
        return False
    
    return True

ans = [] 
def dfs(x, y):
    global cnt
    visited[x][y] = True
    dxs, dys = [1, 0, 0, -1], [0, -1, 1, 0]
    for dx, dy in zip(dxs, dys):
        nx, ny = x + dx, y + dy
        if can_go(nx, ny):
            dfs(nx, ny)
            cnt += 1

for i in range(N):
    for j in range(N):
        cnt = 0
        if grid[i][j] == 1 and visited[i][j] == False:
            cnt += 1
            dfs(i, j)
            ans.append(cnt)


print(len(ans))
ans.sort()
for n in ans:
    print(n)