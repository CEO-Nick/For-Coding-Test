def solution(s):
    answer = 1001
    
    for i in range(1, ((len(s)+1)//2) + 1): # 단위 길이가 문자열의 절반 이상이 되면 같은게 연속으로 나올 수 없음
        sList = []
        idx, cnt = 0, 0
        ans = ""
        
        for j in range(0, len(s), i):
            sList.append(s[j:j+i])
        
        tmp = sList[0]
        while idx < len(sList):
            if tmp == sList[idx]:
                cnt += 1
                idx += 1
            else:
                # 이전까지 같았던 거 문자열로 만들기
                if cnt >= 2: # 2개 이상 같은게 있었다 -> 압축
                    ans += str(cnt)
                    ans += tmp
                else :
                    ans += tmp
                
                tmp = sList[idx]
                cnt = 1
                idx += 1
        
        # 
        if cnt >= 2: # 2개 이상 같은게 있었다 -> 압축
            ans += str(cnt)
            ans += tmp
        else :
            ans += tmp
        answer = min(answer, len(ans))
                
        
            
    return answer