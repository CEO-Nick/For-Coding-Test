import java.util.*;

class Solution {
    static class Truck {
        int time;
        int weight;
        
        Truck(int t, int w) {
            time = t;
            weight = w;
        }
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> q = new ArrayDeque<>();    
        int curW = 0;
        int time = 0;
        int idx = 0;
        int n = truck_weights.length;
        
        
        while (idx < n || !q.isEmpty()) {
            time++;
            
            if (!q.isEmpty() && q.peek().time == time) {
                curW -= q.poll().weight;
            }
            
            if (idx < n) {
                if (curW + truck_weights[idx] <= weight && q.size() < bridge_length) {
                    q.add(new Truck(time + bridge_length, truck_weights[idx]));
                    curW += truck_weights[idx];
                    idx++;
                }
            }
            
        }
        
        return time;
    }
}