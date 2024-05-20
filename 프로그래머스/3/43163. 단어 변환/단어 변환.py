from collections import deque

def diff_one(target, word):
    diff = 0
    for i in range(len(target)):
        if target[i] != word[i]:
            diff += 1
            
    if diff == 1: return True
    else: return False

def solution(begin, target, words):
    if target not in words:
        return 0
    
    q = deque()
    q.append([begin, 0])
    visited = [0] * len(words)
    
    while q:
        word, cnt = q.popleft()
        if word == target: return cnt
        
        for i in range(len(words)):
            if not visited[i]:
                if diff_one(word, words[i]):
                    q.append([words[i], cnt+1])
                    visited[i] = 1
    
    return 0