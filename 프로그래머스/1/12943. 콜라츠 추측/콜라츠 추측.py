cnt = 0
over = False
def solution(num):
    global cnt, over
    answer = 0
    if num == 1:
        return 0
    func(num)
    if over:
        return -1
    else:
        return cnt

def func(n):
    global cnt, over
    if n == 1:
        return
    if cnt > 500:
        over = True
        return 
    cnt += 1
    
    if n%2 == 0:
        return func(n//2)
    else:
        return func((n*3) + 1)
    
    