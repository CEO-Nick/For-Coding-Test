def solution(rows, columns, queries):
    answer = []

    grid = [[(i) * columns + (j + 1) for j in range(columns)] for i in range(rows)]
    
    for i in range(len(queries)):
        answer.append(rotate(queries[i], grid))
        


    return answer  

def rotate(query, grid):
    x1, y1, x2, y2 = query[0], query[1],query[2],query[3]
    x1, y1, x2, y2 = x1-1, y1-1, x2-1, y2-1

    first = grid[x1][y1]
    min_value = first
    
    # 왼쪽
    for i in range(x1, x2):
        grid[i][y1] = grid[i+1][y1]
        min_value = min(min_value, grid[i+1][y1])
    
    #아래
    for i in range(y1, y2):
        grid[x2][i] = grid[x2][i+1]
        min_value = min(min_value, grid[x2][i+1])

    #오른쪽
    for i in range(x2, x1,-1):
        grid[i][y2] = grid[i-1][y2]
        min_value = min(min_value, grid[i-1][y2])

    #위
    for i in range(y2, y1+1, -1):
        grid[x1][i] = grid[x1][i-1]
        min_value = min(min_value, grid[x1][i-1])

    grid[x1][y1+1] = first
    return min_value
