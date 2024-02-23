import sys
sys.setrecursionlimit(10**8)
input = sys.stdin.readline


# graph일 때 dfs 구현
def dfs(v):
    visited[v] = True
    for i in (graph[v]):
        if not visited[i]:
            dfs(i)

# 입력 받기
n, m = map(int, input().split())

graph = [[] for _ in range(n+1)]
visited = [False] * (n+1)

for _ in range(m):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

# dfs시작!
cnt = 0
for i in range(1, n+1):
    if not visited[i]:
        if not graph[i]:
            cnt += 1
            visited[i] = True
        else:
            dfs(i)
            cnt += 1


print(cnt)
