class Solution {
    
    static int[] difficulty;
    static int[] timeTaken;
    static long LIMIT;
    static int minLevel;
    
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        // 퍼즐 난이도가 내 레벨보다 낮거나 같은 경우 -> 현재 퍼즐 소요 시간만큼만 소요
        // 퍼즐 난이도 더 높다 -> 차이만큼 틀림 -> 틀릴 때마다 (이전 퍼즐 + 현재 퍼즐)만큼 소요
        // 제한 시간 내에 퍼즐 모두 해결하기 위한 숙련도 최솟값 -> binary search..?
        
        // 제한 시간 초과 -> level이 낮아서 오래 걸림거임 -> level 늘림
        // 제한 시간 이하 -> 정답일 수도 있고 level이 높아서 빨리 퀴즈 다 푼 경우일 수도 있음 -> level 낮춤
        
        difficulty = diffs;
        timeTaken = times;
        LIMIT = limit;
        minLevel = Integer.MAX_VALUE;
        
        binarySearch(1, 100001);
        
        return minLevel;
    }
    
    public void binarySearch(int l, int r) {
        while (l < r) {
            int level = (l + r) / 2;
            
            long time = calcTime(level);
            
            if (time > LIMIT) {
                l = level + 1;
            } else {
                minLevel = Math.min(minLevel, level);
                r = level;
            }
        }
    }
    
    // 숙련도에 따른 퀴즈 해결 시간 반환
    public static long calcTime(int level) {
        long needTime = 0L;
        for (int i = 0; i < difficulty.length; i++) {
            if (level >= difficulty[i]) {
                needTime += timeTaken[i];
                continue;
            }
            
            needTime += ((timeTaken[i] + timeTaken[i-1]) * (difficulty[i] - level)) + timeTaken[i]; 
        }
        
        return needTime;
    }
    
}