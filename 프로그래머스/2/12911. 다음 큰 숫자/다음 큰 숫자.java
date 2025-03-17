class Solution {
    public int solution(int n) {
        int answer = 0;
        // n보다 크고, 2진수로 변환했을 때 1의 개수 같고, 이걸 만족하는 가장 작은 수
        int std = countOne(Integer.toBinaryString(n++));
        int count = -1;
        
        do {
            count = countOne(Integer.toBinaryString(n++));
        } while (std != count);
        
        return --n;
    }
    
    public static int countOne(String bin) {
        int cnt = 0;
        for (int i = 0; i < bin.length(); i++) {
            if (bin.charAt(i) == '1') cnt++;
        }
        
        return cnt;
    }
}