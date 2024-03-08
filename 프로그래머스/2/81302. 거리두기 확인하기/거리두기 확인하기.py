

def solution(places):
    answer = []
    dxs, dys = [1, -1, 0, 0], [0, 0, 1, -1]
    
    # x, y를 기준으로 맨하튼 거리 2이하에 거리두기 지키고 있는지 확인
    # 지키고 있으면 return 1, 안지키면 return 0
    def check(place, x, y):
        for dx, dy in zip(dxs, dys):
            nx, ny = x + dx, y + dy
            # 5x5 범위 넘는 경우
            if nx < 0 or nx >= 5 or ny < 0 or ny >= 5 or visited[nx][ny]:
                continue
            
            visited[nx][ny] = True
            # 맨하튼 거리 1에, 사람 있는 경우 -> 바로 0 return 
            if place[nx][ny] == 'P':
                return 0
            
            # 맨하튼 거리 1에, 가림막 있는 경우 다음으로
            if place[nx][ny] == 'X':
                continue
            
            # 맨하튼 거리 1에, 책상인 경우 -> 한 depth 더 들어가기
            for dx, dy in zip(dxs, dys):
                nnx, nny = nx + dx, ny + dy
                
                # 5x5 범위 넘거나 방문한 적 있으면 -> 다음으로
                if nnx < 0 or nnx >= 5 or nny < 0 or nny >= 5 or visited[nnx][nny]:
                    continue
        
                visited[nnx][nny] = True
            
                # 맨하튼 거리 2일 때, 사람 있으면 return 0
                if place[nnx][nny] == 'P':
                    return 0
        # 위에서 return 0 안당하고 여기까지 내려온거면 모든 경우 다 통과한 것 -> 거리두기 지킴
        return 1
            
    
    for place in places:
        visited = [[False] * 5 for _ in range(5)]
        d = 0
        flag1 = 0
        for i in range(5):
            flag2 = 0
            for j in range(5):            
                if place[i][j] == 'P':
                    visited[i][j] = True
                    # 거리두기 안지키면
                    if check(place, i, j) == 0:
                        flag2 = 1
                        answer.append(0)
                        break
            if flag2:
                flag1 = 1
                break
        
        # place에서 거리두기 안지킨 경우가 없었던 것
        if flag1 == 0:
            answer.append(1)
                
    return answer