import java.util.*;
import java.lang.*;
class Solution {
    static class Process implements Comparable{
        int location;
        int priority;
        
        Process(int location, int priority) {
            this.location = location;
            this.priority = priority;
        }
        
        public int compareTo(Object obj) {
            Process p = (Process) obj;
            return p.priority - this.priority;
        }
        
        public String toString() {
            return "idx: " + location + " priority: " + priority;
        }
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Process> q = new ArrayDeque<>();
        
        List<Integer> list = new ArrayList<>();
    
        
        for (int i = 0; i < priorities.length; i++) {
            q.add(new Process(i, priorities[i]));
            list.add(priorities[i]);
        }
        
        Collections.sort(list);
        Collections.reverse(list);
        
        int order = 1;
        while(!q.isEmpty()) {
            Process cur = q.peek();
            
            if (cur.priority == list.get(0)) {
                list.remove(0);
                if (cur.location == location) {
                    return order;
                }
                q.poll();
                order++;
            } else {
                q.poll();
                q.add(cur);
            }
        }
        
        return order;
    }
}