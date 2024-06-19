import sys

input = sys.stdin.readline

n = int(input())
card = list(map(int, input().split()))

card_dict = dict()
for num in card:
    num = str(num)
    if num in card_dict:
        card_dict[num] += 1
    else:
        card_dict[num] = 1


m = int(input())
number = list(map(int, input().split()))

for num in number:
    num = str(num)
    if num in card_dict:
        print(card_dict[num], end=' ')
    else:
        print(0, end=' ')
