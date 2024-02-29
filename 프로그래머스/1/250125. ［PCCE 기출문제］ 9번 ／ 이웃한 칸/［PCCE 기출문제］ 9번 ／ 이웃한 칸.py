def solution(board, h, w):
    answer = 0
    n = len(board[0])
    my_color = board[h][w]
    
    dxs, dys = [1, -1, 0, 0], [0, 0, 1, -1]
    for dx, dy in zip(dxs, dys):
        nx, ny = h + dx, w + dy
        
        if nx < 0 or nx >= n or ny < 0 or ny >= n:
            continue
        if my_color == board[nx][ny]:
            answer += 1
    return answer