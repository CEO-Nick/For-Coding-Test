class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while (!s.equals("1")) {
            int before = s.length();
            s = s.replace("0", "");
            int after = s.length();
            
            // 삭제된 0의 개수 
            answer[1] += (before - after);
                    
            // 이진 변환 결과
            s = Integer.toBinaryString(s.length());
            
            // 이진 변환 횟수
            answer[0]++;
        }
        return answer;
    }
}