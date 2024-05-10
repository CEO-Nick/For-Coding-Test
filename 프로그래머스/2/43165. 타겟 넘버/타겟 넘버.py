def solution(numbers, target):
    answer = 0
    
    def dfs(numbers, step, total, target):
        if step == len(numbers):
            if total == target:
                return 1
            else:
                return 0
        res = 0
        res += dfs(numbers, step + 1, total + numbers[step], target) # 시작이 +인 서브트리에서 타겟넘버 만든 횟수
        res += dfs(numbers, step + 1, total - numbers[step], target) # 시작이 -인 서브트리에서 타겟넘버 만든 횟수
        return res
    
    answer = dfs(numbers, 0, 0, target)
    return answer