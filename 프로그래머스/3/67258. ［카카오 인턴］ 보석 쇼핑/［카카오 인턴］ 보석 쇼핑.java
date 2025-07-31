import java.util.*;

class Solution {
    // 진열된 모든 종류의 보석을 적어도 1개 이상 포함하는 가장 짧은 구간을 찾아서 구매
    
    // 우선 보석 종류 개수를 알기 위해선 HashSet을 활용
    // 투 포인터 앞에서부터 시작(같은 길이인 경우 시작 진열대 작은 구간을 찾아야 되니까)
    
    // 첫 시작부터 모든 종류 파악 가능한 
    public int[] solution(String[] gems) {
        
        HashSet<String> all = new HashSet<>();
        
        for (String gem : gems) all.add(gem);
        int total = all.size();
        
        HashMap<String, Integer> current = new HashMap<>();
        
        
        
        int l = 0; int r = 0;
        for (int i = 0; i < gems.length; i++) {
            current.put(gems[i], current.getOrDefault(gems[i], 0) + 1);
            
            if (current.size() == total) {
                r = i;
                break;
            }
        }
        int minLen = r - l + 1;
        int[] answer = new int[] {l+1, r+1};
        
        while (l <= r) {
            // 현재 모든 종류 포함하고 있다면 
            // 최소 구간 체크하고 l을 오른쪽으로 한 칸 이동
            if (current.size() == total) {
                if (r-l+1 < minLen) {
                    minLen = r-l+1;
                    answer[0] = l+1;
                    answer[1] = r+1;
                }
                
                int count = current.get(gems[l]);
                if (count == 1) current.remove(gems[l]);
                else current.put(gems[l], count-1);
                l++;
            } 
            // 모든 종류 보석 포함 안하고 있다면 r을 오른쪽으로 한 칸 이동
            else {
                r++;
                if (r >= gems.length) break;
                current.put(gems[r], current.getOrDefault(gems[r], 0)+1);
            }
            
        }
        
        
        return answer;
    }
}