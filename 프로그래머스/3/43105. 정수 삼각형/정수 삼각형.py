def solution(triangle):
    
    dp = [[0] * i for i in range(1, len(triangle)+1)]
    
    for i in range(len(triangle)):
        if i == 0:
            dp[0][0] = triangle[0][0]  
            continue
        if i == 1:
            dp[1][0] = dp[0][0] + triangle[1][0]
            dp[1][1] = dp[0][0] + triangle[1][1]
            continue
        
        for j in range(len(triangle[i])):
            if j == 0:
                dp[i][j] = dp[i-1][j] + triangle[i][j]
            elif j == len(triangle[i])-1:
                dp[i][j] = dp[i-1][j-1] + triangle[i][j]
            else:
                dp[i][j] = max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j]

    return max(dp[len(triangle)-1])