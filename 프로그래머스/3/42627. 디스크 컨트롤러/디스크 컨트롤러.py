from heapq import heappush, heappop

def solution(jobs):
    answer, now, i = 0, 0, 0
    
    start = -1
    heap = []
    
    while i < len(jobs):
        
        # 현재 시점에서 처리할 수 있는 모든 작업을 가장 짧은 순서대로 큐에 넣기
        for job in jobs:
            if start < job[0] <= now:
                heappush(heap, job[::-1]) # (0, 3)을 뒤집어서 (3, 0)으로 넣기
        
        # 현재 시점에 처리할 일 있으면 처리하기 
        if len(heap) > 0:
            current = heappop(heap)
            start = now
            now += current[0]
            answer += now - current[1]  # 각 task의 요청~종료까지 소요 시간 누적
            i += 1
        # 없으면 그냥 1초 흐름
        else:
            now += 1
        
    return answer // len(jobs)