def solution(m, n, puddles):
    answer = 0
    
    grid = [[0] * m for _ in range(n)]

    for pud in puddles:
        x, y = pud[1]-1, pud[0]-1   # x,y축 기준이 반대고 (1,1) 부터 시작하니깐 1씩 빼준다
        grid[x][y] = -1
    
    grid[0][0] = 1
    
    for i in range(n):
        for j in range(m):
            if i == 0 and j == 0: 
                continue
            
            # 현재 좌표가 물에 잠긴 경우 -> pass
            if grid[i][j] < 0:
                continue
                
            left, up = 0, 0 # 현재 좌표의 최단거리는 (좌측 좌표 최단거리) + (위측 좌표 최단거리) 임
            if j-1 < 0 or grid[i][j-1] < 0: # 왼쪽 좌표가 범위를 벗어나거나 물에 잠긴 경우 
                left = 0
            else:  
                left = grid[i][j-1]
                
            if i-1 < 0 or grid[i-1][j] < 0: # 위쪽 좌표가 범위를 벗어나거나 물에 잠긴 경우
                up = 0
            else:
                up = grid[i-1][j]
            
            
            grid[i][j] = left + up
            
             
    return grid[n-1][m-1] % 1000000007