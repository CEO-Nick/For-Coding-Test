from itertools import permutations 
import math

def isPrime(n):
    if n <= 1:
        return False
    
    for i in range(2, int(math.sqrt(n)) + 1):
        if n % i == 0:
            return False
    
    return True
    

def solution(numbers):
    answer = dict()
    res = 0
    numbers = list(numbers)
    
    for i in range(1, len(numbers)+1): # 자릿수 1자리부터 전체까지
        for j in permutations(numbers, i): 
            tmp = int(''.join(j))
            if isPrime(tmp):
                if tmp not in answer:
                    answer[tmp] = 1
                    res += 1
    return res