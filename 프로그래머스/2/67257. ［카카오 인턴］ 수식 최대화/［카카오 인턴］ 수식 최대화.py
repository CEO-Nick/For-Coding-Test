from itertools import permutations

def calc(a, b, operator):
    if operator == '+':
        return int(a) + int(b)
    elif operator == '-':
        return int(a)-int(b)
    else:
        return int(a)*int(b)

def solution(expression):
    answer = []
    operators = ['+', '-', '*']
    exp = []
    tmp = ''
    
    for c in expression:    # expression을 operator 기준으로 분리
        if 48 <= ord(c) <= 57:
            tmp += c
        else:
            exp.append(tmp)
            exp.append(c)
            tmp = ''
    exp.append(tmp)
    
    real_exp = exp
    for operator in permutations(operators):
        tmp = []
        exp = real_exp
        for op in operator: # 연산자 우선 순위대로 연산
            idx = 0
            while idx < len(exp):
                if exp[idx] == op:
                    tmp.append(calc(tmp.pop(), exp[idx+1], exp[idx]))
                    idx += 1
                else:
                    tmp.append(exp[idx])
                idx += 1            
            exp = tmp
            tmp = []
        answer.append(abs(exp[0]))
    return max(answer)