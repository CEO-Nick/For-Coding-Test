class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        int maxRow = (brown + yellow) / 3;
        
        for (int i = 3; i <= maxRow; i++) {
            boolean findAnswer = false;
            for (int j = maxRow; j >= 3; j--) {
                if ((i * j) < total) break;
                else if ((i*j) == total) {
                    if (((i-2) * (j-2)) == yellow) {
                        findAnswer = true;
                        answer[0] = j; answer[1] = i;
                        break;
                    }
                }
            }
            
            if (findAnswer) break;
        }
        
        return answer;
    }
}