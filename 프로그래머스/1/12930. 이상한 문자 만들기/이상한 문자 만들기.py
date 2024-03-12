def solution(s):
    s = list(s)
    answer = []
    cnt = 0
    
    for c in s:
        if c == ' ':
            cnt = 0
            answer.append(c)
            continue
        if cnt % 2 == 0:
            answer.append(c.upper())
            cnt += 1
        else :
            answer.append(c.lower())
            cnt += 1
            
    return ''.join(answer)