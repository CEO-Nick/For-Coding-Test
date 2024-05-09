from itertools import permutations
import math 

def solution(n, k):
    answer = []
    arr = [i for i in range(1, n+1)]
    
    if n == 1:
        answer.append(1)
    if n == 2:
        if k == 1:
            answer = [1, 2]
        else:
            answer = [2, 1]
            
    while n > 2:
        m = math.factorial(n-1)
        x = k // m
        y = k % m
        print(n, x, y)
        
        if y == 0:
            answer.append(arr[x-1])
            del arr[x-1]
            arr.reverse()
            for num in arr:
                answer.append(num)
            break
         
        answer.append(arr[x])
        del arr[x]
        
        if y == 1:
            for num in arr:
                answer.append(num)
            break
        
        k = y
        n -= 1
        

    return answer