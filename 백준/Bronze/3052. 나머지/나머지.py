import sys 
input = sys.stdin.readline

check = [0] * 42

for _ in range(10):
    n = int(input())
    check[n%42] = 1
    
print(sum(check))