import sys

input = sys.stdin.readline

key = input().strip()
cryptogram = input().strip()
n = (len(cryptogram) // len(key))
m = len(key)

crypto = [[0] * m for _ in range(n)]
idx = 0
#암호문 -> 배열로 변환
for j in range(m):
    for i in range(n):
        crypto[i][j] = cryptogram[idx]
        idx += 1
        
key_arr = [[0,0]  for _ in range(m)]
# 기존 INDEX 저장하기 위해서
for i in range(m):
    key_arr[i][0] = key[i]
    key_arr[i][1] = i    #원래 idx 저장

key_arr = sorted(key_arr)

ans = [[0] * m for _ in range(n)]
index = 0  
# 기존 INDEX 바탕으로 해당 열 복사해서 ans에 넣기
for k in key_arr:
    for i in range(n):
        ans[i][k[1]] = crypto[i][index]
    index += 1

for i in range(n):
    for j in range(m):
        print(ans[i][j], end='')