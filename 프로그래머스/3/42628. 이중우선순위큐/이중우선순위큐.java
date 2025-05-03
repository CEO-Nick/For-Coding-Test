import java.util.*;

class Solution {
    static final String INPUT = "I";
    static final String DELETE_MAX = "D 1";
    static final String DELETE_MIN = "D -1";
    
    public int[] solution(String[] operations) {
        // 빈 큐에서 데이터 삭제 연산 -> 무시
        // 최댓값/최솟값 여러 개 -> 하나만 삭제
        
        PriorityQueue<Integer> pqAsc = new PriorityQueue<>();
        PriorityQueue<Integer> pqDesc = new PriorityQueue<>(Comparator.reverseOrder());
        
        for (String op : operations) {
            // 삭제 요청인데 pq가 비어있으면 연산 무시
            if (op.contains("D") && pqAsc.isEmpty()) continue; 
            
            if (op.contains("I")) {
                String[] command = op.split(" ");
                pqAsc.add(Integer.valueOf(command[1]));
                pqDesc.add(Integer.valueOf(command[1]));
            } else if (op.equals(DELETE_MAX)) {
                Integer max = pqDesc.poll();
                pqAsc.remove(max);
            } else {
                Integer min = pqAsc.poll();
                pqDesc.remove(min);
            }
        }
        
        if (pqAsc.isEmpty()) return new int[] {0, 0};
        else return new int[] {pqDesc.peek(), pqAsc.peek()};
    }
}