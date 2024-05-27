import sys
input = sys.stdin.readline

check = [-1] * 26

string = input().rstrip()
for i in range(len(string)):
    index = ord(string[i])-ord('a')

    if check[index] == -1:
        check[index] = i

for n in check:
    print(n, end=' ')