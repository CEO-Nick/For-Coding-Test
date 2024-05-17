from collections import deque

def dfs(k, graph, visited):
    visited[k] = 1 
    for i in range(len(graph[k])):
        if visited[i] == 0 and graph[k][i] == 1:
            dfs(i, graph, visited)
    

def solution(n, computers):
    answer = 0 
    visited = [0] * n
    
    for i in range(n):
        if visited[i] == 0:
            dfs(i, computers, visited)
            answer += 1
    
        
    return answer