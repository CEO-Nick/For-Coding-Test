class Solution {
    public int solution(int[] numbers) {
        int total = 0;
        for (int num : numbers) {
            total += num;
        }
        return 45 - total;
    }
}