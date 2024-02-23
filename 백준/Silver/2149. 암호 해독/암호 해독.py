import sys

input = sys.stdin.readline

key = input().strip()
cryptogram = input().strip()
n = (len(cryptogram) // len(key))
m = len(key)

crypto = [[0] * m for _ in range(n)]
idx = 0
for j in range(m):
    for i in range(n):
        crypto[i][j] = cryptogram[idx]
        idx += 1
        
key_arr = [[0,0]  for _ in range(m)]
for i in range(m):
    key_arr[i][0] = key[i]
    key_arr[i][1] = i

key_arr = sorted(key_arr)

ans = [[0] * m for _ in range(n)]
index = 0
for k in key_arr:
    for i in range(n):
        ans[i][k[1]] = crypto[i][index]
    index += 1

for i in range(n):
    for j in range(m):
        print(ans[i][j], end='')



