from collections import deque

def solution(n, edge):
    answer = 0
    
    # 인접 리스트로 구현
    route = [0] * (n+1)
    graph = [[] for _ in range(n+1)]
    
    # 그래프 만들기
    for e in edge:
        graph[e[0]].append(e[1])
        graph[e[1]].append(e[0])
        
    queue = deque()
    queue.append(1)
    route[1] = 1
    
    # BFS 탐색 수행 
    while queue:
        now = queue.popleft()
        
        for g in graph[now]:
            if route[g] == 0:
                queue.append(g)
                route[g] = route[now] + 1
    
    max_edge = max(route)
    for r in route:
        if r == max_edge:
            answer += 1
    return answer