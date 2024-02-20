import sys
from collections import deque

input = sys.stdin.readline

n = int(input())

lst = deque()
for i in range(1, n+1):
    lst.append(i)

while True:
    if len(lst) == 1:
        print(lst[0])
        break

    lst.popleft()
    
    if len(lst) == 1:
        print(lst[0])
        break
    tmp = lst.popleft()
    lst.append(tmp)