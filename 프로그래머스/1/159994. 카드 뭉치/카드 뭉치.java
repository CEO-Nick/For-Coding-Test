class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        int idx1 = 0;
        int idx2 = 0;
        int N1 = cards1.length;
        int N2 = cards2.length;
        
        for (String target : goal) {
            if (idx1 < N1 && target.equals(cards1[idx1])) {
                idx1++;
            } else if (idx2 < N2 && target.equals(cards2[idx2])) {
                idx2++;
            } else {
                return "No";
            }
        }
        return "Yes";
    }
}