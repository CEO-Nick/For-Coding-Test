def solution(s, n):
    answer = ''
    
    print(ord('A')) # 65
    print(ord('Z')) # 90
    print(ord('a')) # 97
    print(ord('z')) # 122
    
    for c in s:
        if c == ' ':
            answer += c
        else :
            print(c, ord(c))
            std = 0
            if 'A' <= c <= 'Z':
                std = 65
            else :
                std = 97
            tmp = ((ord(c)-std + n) % 26) + std
            answer += chr(tmp)
        
    return answer