class Solution {
    static int[][] grid;
    static int[] answer;
    
    public int[] solution(int[][] arr) {
        answer = new int[2];
        grid = arr;
        int length = arr.length;
        int res = divide(0, 0, length);
        
        // 최종 결과가 1 or 0 이면 하나로 압축 가능하다는 의미
        if (res == 0 || res == 1) answer[res]++;
        
        return answer;
    }
    
    // 1: 1로 압축 가능, 0: 0으로 압축 가능, -1: 압축 불가능
    static int divide(int x, int y, int len) {
        if (len == 1) return grid[x][y];
        
        int lu = divide(x, y, len/2);
        int ru = divide(x, y+len/2, len/2);
        int ld = divide(x+len/2, y, len/2);
        int rd = divide(x+len/2, y+len/2, len/2);
        
        // 4개로 쪼갠 결과가 모두 1이거나 모두 0이면 압축 가능하다
        if (lu == 1 && ru == 1 && ld == 1 && rd == 1) {
            return 1;
        }
        if (lu == 0 && ru == 0 && ld == 0 && rd == 0) {
            return 0;
        }
        
        // 압축 불가능한 경우, 그 상위도 이제 앞으로 쭉 압축 불가능
        // 그래서 현재까지 결과를 정답에 반영한 후 진행
        if (lu == 0 || lu == 1) answer[lu]++;
        if (ru == 0 || ru == 1) answer[ru]++;
        if (ld == 0 || ld == 1) answer[ld]++;
        if (rd == 0 || rd == 1) answer[rd]++;
        return -1;
    }
}