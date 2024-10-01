class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            long num = numbers[i];
            String binary = null;

            // 짝수인 경우 -> RSB만 0 -> 1로 수정하면 된다
            if (num % 2 == 0) answer[i] = num + 1;
            else {
                
                // 홀수인 경우 -> 오른쪽에서 0이 처음 나오는 index찾고, 01 -> 10 으로 수정하면 된다
                binary = Long.toBinaryString(num);
                int idx = binary.lastIndexOf("0");
                
                // 못찾은 경우 -> 1111과 같은 0이 없는 경우 -> 맨 왼쪽에 0이있다고 가정
                if (idx == -1) {
                    binary = "10" + binary.substring(1, binary.length());
                } else {
                    binary = binary.substring(0, idx) + "10" + binary.substring(idx + 2, binary.length());
                }
                answer[i] = Long.parseLong(binary, 2);      
            }
            
            
        }
        return answer;
    }
    
    
}