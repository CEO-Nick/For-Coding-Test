def solution(new_id):
    answer = ''
    
    # 1단계
    new_id = new_id.lower();
    print('1:', new_id)

    # 2단계
    new_id = list(new_id)
    for i in range(len(new_id)):
        tmp = new_id[i]
        if tmp.isalnum() or tmp == '-' or tmp == '_' or tmp == '.':
            continue
        else:
            new_id[i] = ''
    new_id = ''.join(new_id)
    print('2:', new_id)

    # 3단계
    stack = []
    for i in range(len(new_id)):
        # stack에 값이 있고, 현재 값이 '.'이고 직전 값이랑 같으면 현재 값은 저장하지 않고 넘어간다
        # 즉, 첫 '.'만 남기고 그 이후 연속된 '.'들은 모두 무시
        tmp = new_id[i]
        if stack and tmp == '.' and stack[-1] == tmp:
            continue
        else:
            stack.append(tmp)
    new_id = ''.join(stack)
    print('3:', new_id)
    
    # 4단계
    if new_id != '':
        if new_id[0] == '.' and new_id[-1] == '.':
            new_id = new_id[1:-1]
        elif new_id[0] == '.':
            new_id = new_id[1:]
        elif new_id[-1] == '.':
            new_id = new_id[:-1]
        
    print('4:', new_id)
    
    # 5단계
    if new_id == '':
        new_id = 'a'
    print('5:', new_id)
    
    # 6단계
    if len(new_id) > 15:
        if new_id[14] == '.':
            new_id = new_id[:14]
        else:
            new_id = new_id[:15]
    print('6:', new_id)
    
    # 7단계
    if len(new_id) <= 2:
        new_id = list(new_id)
        last_ch = new_id[-1]
        while len(new_id) < 3:
            new_id.append(last_ch)
        new_id = ''.join(new_id)
    print('7:', new_id)
    
    return new_id