import math
def solution(progresses, speeds):
    answer = []
    days = [0] * len(progresses)
    cnt = 1
    
    for i in range(len(progresses)):
        days[i] = math.ceil((100-progresses[i]) / speeds[i])
    
    standard = days[0]
    for i in range(1, len(days)):
        if days[i] <= standard:
            cnt += 1
        else:
            answer.append(cnt)
            standard = days[i]
            cnt = 1
    
    answer.append(cnt)
    return answer