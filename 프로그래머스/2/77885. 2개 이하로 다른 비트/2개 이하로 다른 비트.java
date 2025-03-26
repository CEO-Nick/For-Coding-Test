class Solution {
    public long[] solution(long[] numbers) {
        int n = numbers.length;
        long[] answer = new long[n];
        
        String bin;
        for(int i = 0; i < n; i++) {
            long cur = numbers[i];
            if (cur % 2 == 0) {
                answer[i] = cur+1;
                continue;
            }
            
            // 홀수인 경우는 우측에서 첫번째 01 을 10으로 수정 (ex. 1(01)1 -> 1(10)1)
            bin = Long.toBinaryString(cur);
            int idx = bin.lastIndexOf('0');
            if (idx == -1) bin = "10" + bin.substring(1, bin.length());
            else bin = bin.substring(0, idx) + "10" + bin.substring(idx + 2, bin.length());
            
            answer[i] = Long.parseLong(bin, 2);
        }
        return answer;
    }
}