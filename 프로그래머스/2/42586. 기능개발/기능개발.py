import math
def solution(progresses, speeds):
    answer = []
    n = len(speeds)
    remaining_days = []
    for i in range(n):
        remaining_days.append(math.ceil((100-progresses[i])/speeds[i]))
    
    cnt = 1
    standard = remaining_days[0]
    for i in range(1, n):
        if standard >= remaining_days[i]:
            cnt += 1
        else:
            answer.append(cnt)
            cnt = 1
            standard = remaining_days[i]
    answer.append(cnt)
    # print(remaining_days)
    return answer