import sys
input = sys.stdin.readline

check = [0] * 31
for _ in range(28):
    n = int(input())
    check[n] = 1

answer = []
for i in range(1, 31):
    if check[i] == 0:
        answer.append(i)

answer.sort()
print(answer[0])
print(answer[1])