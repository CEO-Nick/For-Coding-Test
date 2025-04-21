import java.util.*;

class Solution {
    
    static int[][] table;
    
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        // col번째 컬럼 값으로 오름차순 정렬
        // 같은 경우, 첫번째 컬럼 값으로 내림차순 정렬
        // 이렇게 정렬한 후에 테이블에 대한 해시함수 정의 
            // S_i = i번째 행의 튜플에 대해서 각 컬럼의 값을 i로 나눈 나머지의 합
            // (1, 2, 3, 4, 5) -> i = 5
            // S_5 = 1 + 2 + 3 + 4 + 0 = 10
        // 이 값을 row_begin ~ row_end까지 모두 XOR로 누적 한 값이 해시 값
        
        table = data;
        col--; row_begin--; row_end--;
        
        final int col_f = col;
        // 정렬하기
        Arrays.sort(table, (a, b) -> {
            if (a[col_f] != b[col_f]) return a[col_f] - b[col_f];
            else return b[0] - a[0];
        });
        
        // 각 튜플 S_i 값 구하면서 XOR 누적하기
        int answer = 0;
        for (int i = row_begin; i <= row_end; i++) {
            int res = calc(i);
            answer ^= res;
        }
        
        return answer;
    }
    
    public static int calc(int row) {
        int sum = 0;
        for (int j = 0; j < table[row].length; j++) 
            sum += (table[row][j] % (row+1));
        
        return sum;
    }
}