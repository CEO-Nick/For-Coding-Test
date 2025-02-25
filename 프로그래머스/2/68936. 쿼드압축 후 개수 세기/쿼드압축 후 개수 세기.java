class Solution {
    static int zero = 0;
    static int one = 0;
    
    // {0 개수, 1 개수}
    static void check(int[][] arr, int startX, int startY, int endX, int endY, int len) {
        // 1개 숫자로 압축할 수 있는 경우
        if (canCompress(arr, startX, startY, endX, endY)) {
            zero += arr[startX][startY] == 0 ? 1 : 0;
            one += arr[startX][startY] == 1 ? 1 : 0;
            return;
        }
        
        // 더이상 분할 불가능
        if (len == 1) return;
        
        // 압축 못하면 4개로 분할하기
        check(arr, startX, startY, startX + len/2 - 1, startY + len/2 - 1, len / 2); // 좌측 상단
        check(arr, startX, startY + len/2, startX + len/2 - 1, endY, len / 2); // 우측 상단
        check(arr, startX + len/2, startY, endX, startY + len/2 - 1, len / 2); // 좌측 하단
        check(arr, startX + len/2, startY + len/2, endX, endY, len / 2); // 우측 하단
    }
    
    // 지정된 범위 안에서 압축 가능한지 판단
    static boolean canCompress(int[][] arr, int startX, int startY, int endX, int endY) {
        int std = arr[startX][startY];
        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                if (std != arr[i][j]) return false;
            }
        }
        return true;
    }
    public int[] solution(int[][] arr) {
        // S 내부 모든 수 같은 값 -> S를 하나로 압축
        // S를 4개로 쪼갬
        // 재귀함수로 쪼개야겠다
        // 재귀함수에서는 자기 부분 압축 가능한지 check -> 가능하면 바로 해당 값 반환
        // 불가능하면 4개 쪼개서 각각함수 호출
        check(arr, 0, 0, arr.length - 1, arr.length - 1, arr.length);
        
        return new int[] {zero, one};
    }
}