def solution(skill, skill_trees):
    answer = 0
    tmp = ''
    white_list = []
    for i in range(len(skill)):
        white_list.append(skill[0:i])
    white_list.append(skill)
    
    
    for tree in skill_trees:
        tmp = ''
        for s in tree:
            if s in skill:
                tmp += s
        
        if tmp in white_list:
            answer += 1
    return answer