import sys
input = sys.stdin.readline

N = int(input())
have = sorted(list(map(int, input().split())))

M = int(input())
find = (list(map(int, input().split())))

def binary_search(start, end, key):
    global have

    if start > end:
        return 0
    
    idx = (start + end) // 2

    if (have[idx] == key):
        return 1
    elif (have[idx] > key):
        end = idx-1
    else:
        start = idx+1
    
    return binary_search(start, end, key)
    

for n in find:
    ans = binary_search(0, N-1, n)
    print(ans, end=' ')
    

