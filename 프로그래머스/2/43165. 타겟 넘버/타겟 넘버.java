class Solution {
    static int N;
    static int answer = 0;
    static int[] arr;
    static int T;
    public int solution(int[] numbers, int target) {
        // 매번 2가지 경우의 수 현재 수에 다음 수를 더할지 뺄지
        N = numbers.length;
        arr = numbers;
        T = target;
        
        dfs(1, numbers[0]);
        dfs(1, -numbers[0]);
        return answer;
    }
    
    public static void dfs(int idx, int sum) {
        if (idx == N) {
            if (sum == T) answer++;
            return;
        }
        dfs(idx+1, sum+arr[idx]);
        dfs(idx+1, sum-arr[idx]);
    }
}