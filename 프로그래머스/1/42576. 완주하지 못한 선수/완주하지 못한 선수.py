def solution(participant, completion):
    answer = ''
    com = dict()
    
    for name in completion:
        if name not in com:
            com[name] = 1
        else:
            com[name] += 1
    
    for part in participant:
        if part not in com or com[part] == 0:
            answer = part
            break
        
        com[part] -= 1
    return answer