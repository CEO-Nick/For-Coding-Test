import sys 
input = sys.stdin.readline

sentence = input().rstrip()
while sentence != '.':
    stack = []
    for s in sentence:
        if s in ['(', '[']:
            stack.append(s)

        elif s == ')':
            if stack == [] or stack[-1] != '(':
                stack.append(s)
            else:
                stack.pop()
        elif s == ']':
            if stack == [] or stack[-1] != '[':
                stack.append(s)
            else:
                stack.pop()
    
    if stack == []:
        print('yes')
    else:
        print('no')

    sentence = input().rstrip()