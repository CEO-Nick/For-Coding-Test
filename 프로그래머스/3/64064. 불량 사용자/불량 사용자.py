from itertools import combinations 
from itertools import permutations 

def solution(user_id, banned_id):
    answer = set()
    banlist = set() # userId가 겹치면 안되니까 set으로 선언
    for i, banId in enumerate(banned_id):
        for j, userId in enumerate(user_id):
            
            if len(banId) == len(userId): # 두 id의 길이가 같을 때만 masking 제외하고 같은지 확인
                isSame = True
                for k in range(len(banId)): # Id를 문자 하나하나 비교하기
                    if banId[k] == '*': 
                        continue
                    if userId[k] != banId[k]:
                        isSame = False
                        break
                 
                if isSame:
                    banlist.add(userId)
    print(banlist)

    
    print('permutations')
    for per in permutations(banlist, len(banned_id)):
        # print(per)
        sameCnt = 0
        for i in range(len(per)):
            if len(per[i]) == len(banned_id[i]):
                # print(per[i])
                isSameId = True
                for j in range(len(per[i])):
                    if banned_id[i][j] == '*':
                        continue
                    if per[i][j] != banned_id[i][j]:
                        isSameId = False
                        break
                if isSameId:
                    sameCnt += 1
        if sameCnt == len(per):
            tmp = list(per)
            tmp.sort()
            tmp = tuple(tmp)
            answer.add(tmp)
    print(answer)
    return len(answer)