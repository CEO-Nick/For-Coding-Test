class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        
        for (int h = 3; h < (int)(Math.sqrt(total)) + 1; h++) {
            if (total % h != 0) continue;
            
            int w = total / h;
            int b = w * 2 + (h - 2) * 2;
            if (b == brown) {
                answer[0] = w;
                answer[1] = h;
                break;
            }
        }
        return answer;
    }
}