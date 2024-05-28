import sys
input = sys.stdin.readline

n = int(input())
numbers = input().rstrip()

sum = 0
for num in numbers:
    sum += int(num)

print(sum)