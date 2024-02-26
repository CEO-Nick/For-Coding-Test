def solution(friends, gifts):
    answer = 0
    n = len(friends)
    
    friend_dict = dict()
    for i in range(n):
        friend_dict[friends[i]] = i
        
    table = [[0] * n for _ in range(n)]
    
    # 주고 받은 선물 내역 표(table)에 저장
    # 선물 지수(gift_indices) 저장
    gift_indices = [0] * n
    
    for gift in gifts:
        a, b = gift.split() # a : 준 사람 b : 받은 사람
        idx1, idx2 = friend_dict[a], friend_dict[b]
        gift_indices[idx1] += 1
        gift_indices[idx2] -= 1
        table[idx1][idx2] += 1
    
    
    get_gift = [0] * n
    for i in range(n):
        for j in range(n):
            if i == j:
                continue
            if table[i][j] > table[j][i]: # 준 게 더 많을 때
                get_gift[i] += 1
            elif table[i][j] == table[j][i]: # 주고 받은게 같을 때 or 둘 다 안주고 받았을 때
                if gift_indices[i] > gift_indices[j]: # 선물 지수 크면 선물 받기
                    get_gift[i] += 1
    
    answer = max(get_gift)
    return answer