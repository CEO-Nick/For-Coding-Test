class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < arr.length; i++) {
            int num = Integer.parseInt(arr[i]);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(max);
        
        return sb.toString();
    }
}