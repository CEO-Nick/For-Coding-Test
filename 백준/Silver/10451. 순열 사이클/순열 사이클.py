import sys
input = sys.stdin.readline

def dfs(v):
    visited[v] = True

    for i in graph[v]:
        if not visited[i]:
            dfs(i)

T = int(input())

for _ in range(T):
    N = int(input())
    array = list(map(int, input().split()))

    graph = [[] for _ in range(N+1)]
    visited = [False] * (N+1)
    cnt = 0

    for i in range(1, N+1):
        graph[i].append(array[i-1])
    
    for i in range(1, N+1):
        if not visited[i]:
            dfs(i)
            cnt += 1
    
    print(cnt)