def solution(money):
    
    dp1 = [0] * len(money)
    dp2 = [0] * len(money)
    
    # 0번부터 시작하는 경우, 집이 홀수개라면 맨 마지막 집은 털 수 없다
    dp1[0] = dp1[1] = money[0]
    for i in range(2, len(money)-1):
        # (한 집 전을 턴 금액) VS (두 집 전을 턴 금액 + 지금 털 집 금액) 
        dp1[i] = max(dp1[i-1], dp1[i-2] + money[i])
        
    # 1번부터 시작하는 경우, 맨 마지막 집 털 수 있다
    dp2[1] = money[1]
    for i in range(2, len(money)):
        dp2[i] = max(dp2[i-1], dp2[i-2] + money[i])
    
    
    return max(max(dp1), max(dp2))