def solution(record):
    answer = []
    nickname = dict()
    for rec in record:
        rec = rec.split()
        if rec[0] != 'Leave':
            nickname[rec[1]] = rec[2]
            
    for rec in record:
        rec = rec.split()
        if rec[0] == 'Enter':
            result = nickname[rec[1]] + '님이 들어왔습니다.'
            answer.append(result)
        elif rec[0] == 'Leave':
            result = nickname[rec[1]] + '님이 나갔습니다.'
            answer.append(result)
        
    return answer