from collections import deque

def solution(board):
    
    def bfs(start):
        dxs, dys = [1, 0, -1, 0], [0, 1, 0, -1] # 하,우,상,좌
        n = len(board)   
        visited = [[999999999]*n for _ in range(n)]
        visited[0][0] = 0
        
        q = deque([start])
        while q:
            x, y, cost, d = q.popleft()
            for i in range(4):
                nx, ny = x + dxs[i], y + dys[i]
                if 0 <= nx < n and 0 <= ny < n and board[nx][ny] == 0:
                    if i == d: ncost = cost + 100 
                    else: ncost = cost + 600 

                    if ncost < visited[nx][ny]:
                        visited[nx][ny] = ncost
                        q.append((nx, ny, ncost, i))
                        
        return visited[-1][-1]
            
    return min(bfs((0,0,0,0)), bfs((0,0,0,1)))