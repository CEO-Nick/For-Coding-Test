def solution(s):
    res = []
    tmp = ''
    # s = s.replace('{', ' ')
    # s = s.replace('}', ' ')
    # s = s.replace(' ', '')
    # res = s.split(',')
    # print(res)

    start_flag = 0 # 현재 집합 안에 있는지
    # 집합 단위로 쪼개기
    for i in range(1, len(s)-1):
        if s[i] == '{':
            tmp = ''
            start_flag = 1
            continue
        elif s[i] == '}':
            res.append(tmp)
        else :
            if start_flag:
                tmp += (s[i])
            else :
                continue
    # 각 집합을 정수형 list로 변환하기
    for i in range(len(res)):
        tmp_list = list(map(int, res[i].split(',')))
        res[i] = tmp_list
    # 집합 원소 개수를 기준으로 정렬
    sorted_res = sorted(res, key = lambda x: len(x))
    
    answer = []
    for i in range(len(sorted_res)):
        for j in range(len(sorted_res[i])):
            if sorted_res[i][j] not in answer:
                answer.append(sorted_res[i][j])
    return answer