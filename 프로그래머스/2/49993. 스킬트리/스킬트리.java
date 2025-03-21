import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        HashSet<Character> set = new HashSet<>();
        StringBuilder sb;
        
        for (int i = 0; i < skill.length(); i++) set.add(skill.charAt(i));
        
        for (int i = 0; i < skill_trees.length; i++) {
            sb = new StringBuilder();
            for (int j = 0; j < skill_trees[i].length(); j++) {    
                char sk = skill_trees[i].charAt(j);
                if (set.contains(sk)) sb.append(sk);
            }
            
            answer += checkSkillTree(skill, sb.toString()) ? 1 : 0;
        }
        
        return answer;
    }
    
    public static boolean checkSkillTree(String skill, String skillTree) {
        int len = Math.min(skill.length(), skillTree.length());
        
        for (int i = 0; i < len; i++) {
            if (skill.charAt(i) != skillTree.charAt(i)) return false;
        }
        
        return true;
    }
}