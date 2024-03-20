def solution(brown, yellow):
    answer = []
    
    total = brown + yellow
    
    # i : 가로
    for i in range(3, total):
        # j : 세로
        for j in range(3, i+1): # 세로는 가로와 같거나 작음
            if i * j == total:
                if (i-1)*2 + (j-1)*2 == brown:
                    return [i, j]
    