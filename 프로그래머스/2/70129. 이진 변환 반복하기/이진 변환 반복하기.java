class Solution {
    public int[] solution(String s) {
        int[] answer = {0, 0};
        // 문자열에서 1인 부분의 개수 구하고 2진수로 변환 -> 변환된 2진수의 길이가 1이 아니면 반복
        while (s.length() != 1) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '1') count++;
                else answer[1]++;
            }
            
            s = Integer.toBinaryString(count);
            answer[0]++;
        }
        return answer;
    }
}