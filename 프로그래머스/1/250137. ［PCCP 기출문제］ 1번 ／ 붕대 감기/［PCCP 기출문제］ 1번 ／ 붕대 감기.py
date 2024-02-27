def solution(bandage, health, attacks):
    answer = 0
    cur = health
    
    for i in range(len(attacks)):
        time, power = attacks[i][0], attacks[i][1]
        if i == 0:
            tick = time - 0 - 1
        else:
            tick = time - attacks[i-1][0] - 1
        
        # 공격 사이 시간만큼 체력 회복 후 해당 공격만큼 체력 차감
        
        # 추가 체력 회복 몇 번하는지
        more_time = tick // bandage[0] # 추가 체력 회복하는 횟수
        if more_time: 
            cur += bandage[2] * more_time
        
        cur += bandage[1] * tick 
        if cur > health:
            cur = health
        
        cur -= power
        
        if cur <= 0:
            return -1
    return cur