import java.util.*;

class Solution {
    static HashMap<String, Integer> orderMap;
    
    public String[] solution(String[] orders, int[] course) {
        orderMap = new HashMap<>();
        for (String order : orders) {
            char[] orderArr = order.toCharArray();
            Arrays.sort(orderArr);
            
            for (int len : course) {
                if (order.length() < len) continue;
    
                sb = new StringBuilder();
                choose(orderArr, 0, len);
            }
        }
        
        int[] max = new int[course.length];
        for (Map.Entry<String, Integer> entry : orderMap.entrySet()) {
            for (int i = 0; i < course.length; i++) {
                if (entry.getKey().length() == course[i]) {
                    max[i] = Math.max(max[i], entry.getValue());
                    break;
                }
            }
        }
        
        ArrayList<String> answer = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : orderMap.entrySet()) {
            for (int i = 0; i < course.length; i++) {
                // 코스 길이와 최댓값 일치하는 경우 & 코스 2번 이상 선택된 경우 -> 정답
                if (entry.getKey().length() == course[i] && entry.getValue() >= 2 && entry.getValue() == max[i]) {
                    answer.add(entry.getKey());
                }
            }
        }
        Collections.sort(answer);
        
        String[] ans = new String[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            ans[i] = answer.get(i);
        }
        
        return ans;
    }
    
    static StringBuilder sb;
    public static void choose(char[] arr, int cur, int len) {
        if (sb.length() == len) {
            String course = sb.toString();
            orderMap.put(course, orderMap.getOrDefault(course, 0) + 1);
            return;
        }
        
        for (int i = cur; i < arr.length; i++) {
            sb.append(arr[i]);
            choose(arr, i+1, len);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    
}