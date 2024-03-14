def solution(s):
    answer = 0
    stack = []
    
    for char in s:
        if stack and stack[-1] == char: # stack에 값이 있고, 마지막 값이 현재 값이랑 같으면
            stack.pop()
        else :
            stack.append(char)
    
    if stack:
        answer = 0
    else :
        answer = 1
    return answer