from collections import defaultdict
from itertools import combinations
from bisect import bisect_left as left_bound

def solution(info, query):
    answer = []
    people = defaultdict(list)  # dictionary의 key가 "java backend junior pizza"이고 value가 앞에 조건에 해당하는 사람의 점수 list
    
    for i in info:
        person = i.split()
        score = int(person.pop())
        people[''.join(person)].append(score)
        
        for j in range(4):
            case = list(combinations(person, j))
            for c in case:
                people[''.join(c)].append(score)
    
    # 각 경우별 점수 list를 정렬
    for i in people: people[i].sort()
    
    for i in query:
        key = i.split()
        score = int(key.pop())
        key = ''.join(key)
        key = key.replace('and', '').replace(' ', '').replace('-', '')
        
        answer.append(len(people[key]) - left_bound(people[key], score)) # score보다 작은 사람의 수 빼기 
    
    return answer