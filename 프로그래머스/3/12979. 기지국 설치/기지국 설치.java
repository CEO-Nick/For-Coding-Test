class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int current = 1;
        int idx = 0;
        
        // 현재 위치에서 (2 * w + 1) 만큼 점프 -> 기존 기지국 사정거리 안에 들어왔다 -> 사정거리 밖으로 세팅
        // 사정 거리 안에 안들어옴 -> 기지국 세운다
        while (current <= n) {
            if (idx < stations.length && current >= stations[idx] - w) {
                current = stations[idx] + w + 1;
                idx++;
            } else {
                answer++;
                current += 2 * w + 1;
            }
        }

        return answer;
    }
}