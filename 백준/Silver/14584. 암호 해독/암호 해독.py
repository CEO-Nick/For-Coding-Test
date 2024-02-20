import sys
input = sys.stdin.readline

def editAlphabet(word, x):
    res = ''
    for i in range(len(word)):
        res += chr((((ord(word[i]) + x) - 97) % 26)+97)
    
    return res


cryptogram = input().strip()
N = int(input())
dict = [input().strip() for _ in range(N)]

ans, flag = 0, 0

for i in range(1, 27):
    tmp = editAlphabet(cryptogram, i)
    # print(tmp)
    for j in range(N):
        if (dict[j] in tmp):
            flag = 1
            break
    
    if flag == 1:
        ans = tmp
        break

print(ans)
    
    