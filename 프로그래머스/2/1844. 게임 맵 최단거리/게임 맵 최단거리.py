import sys     
sys.setrecursionlimit(10000)

from collections import deque

def solution(maps):
    n, m = len(maps), len(maps[0])
    visited = [[0]*m for _ in range(n)]
    
    def in_range(x, y):
        return 0 <= x and x < n and 0 <= y and y < m    
    
    def can_go(nx, ny):
        if not in_range(nx, ny):
            return False
        if visited[nx][ny] != 0 or maps[nx][ny] == 0:
            return False
        
        return True

    q = deque()
    def bfs():
        while q:
            x, y = q.popleft()
            
            dxs, dys = [0, 1, -1, 0], [1, 0, 0, -1]
            for dx, dy in zip(dxs, dys):
                nx, ny = x + dx, y + dy

                if can_go(nx, ny):
                    # print(nx, ny)
                    visited[nx][ny] = visited[x][y] + 1    
                    q.append((nx, ny))
    
    q.append((0,0))
    visited[0][0] = 1
    bfs()
    # print(visited)
    if visited[n-1][m-1] != 0:
        return visited[n-1][m-1]
    else:
        return -1
