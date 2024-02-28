def solution(id_list, report, k):
    n = len(id_list)
    answer = [0] * n
    
    id_dict = dict()
    for i in range(n):
        id_dict[id_list[i]] = i
    
    # 신고 현황 2차원 배열에 저장
    result = [[0] * n for _ in range(n)]
    for r in report:
        a, b = r.split()
        a_idx, b_idx = id_dict[a], id_dict[b]
        result[a_idx][b_idx] = 1
    
    # 신고당한 횟수 파악
    reported_time = [0] * n
    for j in range(n):
        for i in range(n):
            if result[i][j] != 0:
                reported_time[j] += 1
    
    # k번 이상 신고 당한 유저 찾고 -> 그 유저를 신고한 유저 찾기
    for j in range(n):
        if reported_time[j] >= k:   # 신고 횟수 k번 이상인 경우
            for i in range(n):
                if result[i][j] != 0:
                    answer[i] += 1
    return answer