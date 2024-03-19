def solution(answers):
    answer = []
#     arr1 = [1,2,3,4,5] * 2001
#     arr2 = [2,1,2,3,2,4,2,5] * 1251
#     arr3 = [3,3,1,1,2,2,4,4,5,5] * 1001
    
#     arr1 = arr1[:len(answers)]
#     arr2 = arr2[:len(answers)]
#     arr3 = arr3[:len(answers)]
    
#     cnt = [0, 0, 0]
#     for i in range(len(answers)):
#         if arr1[i] == answers[i]:
#             cnt[0] += 1
#         if arr2[i] == answers[i]:
#             cnt[1] += 1
#         if arr3[i] == answers[i]:
#             cnt[2] += 1
            
#     max_num = max(cnt)
    
#     for i in range(len(cnt)):
#         if max_num == cnt[i]:
#             answer.append(i+1)
#     return answer

    arr1 = [1,2,3,4,5] 
    arr2 = [2,1,2,3,2,4,2,5] 
    arr3 = [3,3,1,1,2,2,4,4,5,5]
    
    cnt = [0, 0, 0]
    
    for idx, num in enumerate(answers):
        if num == arr1[idx % len(arr1)]:
            cnt[0] += 1
        if num == arr2[idx % len(arr2)]:
            cnt[1] += 1
        if num == arr3[idx % len(arr3)]:
            cnt[2] += 1
           
    max_score = max(cnt)
    for idx, score in enumerate(cnt):
        if max_score == score:
            answer.append(idx+1)
    return answer