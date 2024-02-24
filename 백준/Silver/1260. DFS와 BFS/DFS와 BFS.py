import sys
from collections import deque

input = sys.stdin.readline  

N, M, V = map(int, input().split())


graph = [[0] * (N+1) for _ in range(N+1)]
for i in range(M):
    a, b = map(int, input().split())
    graph[a][b] =  graph[b][a] = 1    # 양방향 간선이라 양쪽에 값 넣기

d_visited = [0] * (N+1)
b_visited = [0] * (N+1)

def dfs(V):
    d_visited[V] = 1
    print(V, end=' ')

    for i in range(1, N+1): # V에서 갈 수 있는 노드 중 숫자 작은 것부터 방문
        if graph[V][i] == 1 and d_visited[i] == 0:
            dfs(i)

def bfs(V):
    queue =[V]
    b_visited[V] = 1

    while queue:
        V = queue.pop(0)
        print(V, end=" ")

        for i in range(1, N+1):
            if (graph[V][i] == 1 and b_visited[i] == 0):
                queue.append(i)
                b_visited[i] = 1


dfs(V)
print()
bfs(V)

