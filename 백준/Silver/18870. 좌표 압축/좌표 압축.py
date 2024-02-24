import sys
input = sys.stdin.readline

N = int(input())
arr = list(map(int, input().split()))

# 중복 제거 -> 정렬 -> 배열 index가 곧 압축한 값

# 1. 중복 제거 및 정렬 : set(arr)을 통해서 중복 제거 후 정렬
sorted_arr = sorted(list(set(arr)))

# 2. dictionary로 값에 따른 index 저장
dict_arr = dict(zip(sorted_arr, list(range(len(sorted_arr)))))

for num in arr:
    print(dict_arr[num], end=' ')