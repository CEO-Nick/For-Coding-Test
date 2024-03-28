def solution(n, times):
    answer = 0
    left, right = 1, n * max(times)
    
    while left <= right:
        mid = (left + right) // 2   # 현재 시간 
        people = 0 
        for time in times:
            people += mid // time
            if people >= n: # 각 심사원이 처리한 사람을 더하는 데 이게 이미 n을 넘기면 더 조사할 필요도 없이 줄여야함
                break
        
        if people >= n:
            answer = mid
            right = mid -1
        elif people < n:
            left = mid + 1
    
    return answer
            
    return answer