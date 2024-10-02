import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        HashMap<Character, Integer> skillMap = new HashMap<>();
        for (int i = 0; i < skill.length(); i++) {
            skillMap.put(skill.charAt(i), 1);
        }
        
        ArrayList<Character> stack = new ArrayList<>();
        for (int i = 0; i < skill_trees.length; i++) {
            boolean possible = true;
            for (int j = 0; j < skill_trees[i].length(); j++) {
                char sk = skill_trees[i].charAt(j);
                if (skillMap.containsKey(sk)) stack.add(sk);
            }
            
            int loop = Math.min(stack.size(), skill.length());
            for (int k = 0; k < loop; k++) {
                if (stack.get(k) != skill.charAt(k)) {
                    possible = false;
                    break;
                }
            }
            
            if (possible) answer++;
            
            stack.clear();
        }
        
        
        return answer;
    }
}