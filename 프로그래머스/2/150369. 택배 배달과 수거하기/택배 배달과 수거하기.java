class Solution {
    // 항상 cap만큼 챙겨서 배달이나 수거해야 되는 곳까지 
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int maxD = 0;
        int maxP = 0;
        for (int i = n-1; i >= 0; i--) {
            if (deliveries[i] != 0) {
                maxD = i;
                break;
            } 
        }
        for (int i = n-1; i >= 0; i--) {
            if (pickups[i] != 0) {
                maxP = i;
                break;
            } 
        }
        
        if (maxD == 0 && maxP == 0) return 0;
        
        while (maxD >= 0 || maxP >= 0) {
            int move = Math.max(maxD, maxP);
            answer += (move + 1) * 2;

            int curCap = cap;
            // 배달하기
            while (maxD >= 0) {
                if (curCap > deliveries[maxD]) {
                    curCap -= deliveries[maxD];
                    deliveries[maxD] = 0;
                    maxD--;
                } else if (curCap == deliveries[maxD]) {
                    curCap = 0;
                    deliveries[maxD] = 0;
                    maxD--;
                } else {
                    deliveries[maxD] -= curCap;
                    break;
                }
            }

            // 수거하기
            curCap = cap;
            while (maxP >= 0) {
                if (curCap > pickups[maxP]) {
                    curCap -= pickups[maxP];
                    pickups[maxP] = 0;
                    maxP--;
                } else if (curCap == pickups[maxP]) {
                    curCap = 0;
                    pickups[maxP] = 0;
                    maxP--;
                } else {
                    pickups[maxP] -= curCap;
                    break;
                }
            }
        }
        
        return answer;
    }
}