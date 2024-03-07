def solution(n):
    
    snail = [[0] * i for i in range(1, n+1)]
    dx, dy = [1, 0, -1], [0, 1, -1] # 아래 -> 오른쪽 -> 대각선
    x = y = direction = 0
    
    size = (n * (n+1)) // 2 
    
    for i in range(1, size+1):
        snail[x][y] = i
        
        nx, ny = x + dx[direction], y + dy[direction]
        
        # 배열 범위 안에 있어야 하고, 해당 자리에 값이 할당된 적 없어야 함
        if 0 <= nx < n and 0 <= ny <= nx and snail[nx][ny] == 0:
            x, y = nx, ny
        else : # 방향 변경해야 되는 경우
            direction = (direction + 1) % 3
            x, y = x + dx[direction], y + dy[direction]
    
    return [i for j in snail for i in j] # 2차원 배열을 1차원 배열로 압축