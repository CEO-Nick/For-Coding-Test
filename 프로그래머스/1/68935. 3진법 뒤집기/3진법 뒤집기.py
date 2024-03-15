def solution(n):
    tmp = ''
    while n > 2:
        tmp += str(n % 3)
        n //= 3
    tmp += str(n)
    
    answer = 0
    cnt = 0
    
    for i in range(len(tmp)-1, -1, -1): 
        answer += int(tmp[i]) * (3**cnt)
        cnt += 1
        
    return answer