import sys 
input = sys.stdin.readline

check = dict()

for _ in range(10):
    n = int(input())
    remain = n % 42 
    if remain not in check:
        check[remain] = 1

print(len(check)) 