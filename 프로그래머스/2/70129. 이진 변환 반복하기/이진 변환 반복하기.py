def solution(s):
    answer = [0, 0] # 변환 횟수, 제거한 0의 갯수
    
    
    while s != '1':
        before = len(s)
        s = s.replace('0', '')
        after = len(s)
        
        answer[1] += (before-after)
        s = format(after, 'b')
        
        answer[0] += 1
    return answer