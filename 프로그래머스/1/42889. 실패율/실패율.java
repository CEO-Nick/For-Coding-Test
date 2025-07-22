import java.util.*;

class Solution {
    class Challenger implements Comparable{
        int idx;
        double rate;
        
        Challenger(int idx, double rate) {
            this.idx = idx;
            this.rate = rate;
        }
        
        public int compareTo(Object obj) {
            Challenger c = (Challenger) obj;
            if (Double.compare(c.rate, this.rate) == 0) {
                return this.idx - c.idx;
            }
            return Double.compare(c.rate, this.rate);
        }
        
        public String toString() {
            return "(" + idx + ", " + rate + ")";
        }
    }
    
    public int[] solution(int N, int[] stages) {
        int[] challenges = new int[N+2];
        
        int total = stages.length;
        for (int stg : stages) challenges[stg]++;
                
        ArrayList<Challenger> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (total == 0) list.add(new Challenger(i, 0));
            else list.add(new Challenger(i, (double)challenges[i] / total));
            total -= challenges[i];
        }
        
        Collections.sort(list);
        // System.out.println(list);
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = list.get(i).idx;
        }
        return answer;
    }
}