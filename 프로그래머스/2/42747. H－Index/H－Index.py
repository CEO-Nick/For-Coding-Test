def solution(citations):
    answer = 0
    citations.sort()
    for idx, citation in enumerate(citations):
        if citation >= len(citations) - idx:
            answer = len(citations) - idx
            break
    return answer