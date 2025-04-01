import java.util.*;
import java.util.Map.Entry;

class Solution {
    static HashMap<String, Integer> map;
    static int STOP;
    static List<Character> list;
    
    public String[] solution(String[] orders, int[] course) {
        
        int n = course.length;
        map = new HashMap<>();
        list = new ArrayList<>();
        
        // 각 order에 대해서 course 만큼 선택해서 map에 넣기 (AB = BA 이니깐 order을 정렬한 후에 넘기기)
        for (String ord : orders) {
            char[] arr = ord.toCharArray();
            Arrays.sort(arr);
            //System.out.println(Arrays.toString(arr));
            for (int c : course) {
                STOP = c;
                choose(0, 0, arr);
            }
        }
        int[] max = new int[n];
        
        // 코스 길이별 최댓값 구하기
        for (Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            if (value < 2) continue;
            for (int i = 0; i < n; i++) {
                if (key.length() == course[i]) {
                    
                    max[i] = Math.max(max[i], value);
                    break;
                }
            }
        }
        
        // 최댓값과 일치하는 코스요리 answer에 추가하기
        List<String> answer = new ArrayList<>();
        for (Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            for (int i = 0; i < n; i++) {
                if (key.length() == course[i] && value == max[i]) {
                    answer.add(key);
                    break;
                }
            }
        }
        
        Collections.sort(answer);
        String[] ans = new String[answer.size()];
        for (int i = 0; i < answer.size(); i++) ans[i] = answer.get(i);
        
        return ans;
    }
    
    // 각 주문 조합에서 STOP 개수만큼 선택해서 map에 넣기
    public static void choose(int idx, int cnt, char[] arr) {
        if (cnt == STOP) {
            String course = listToString();
            int count = map.getOrDefault(course, 0);
            map.put(course, count + 1);
            return;
        }
        
        for (int i = idx; i < arr.length; i++) {
            list.add(arr[i]);
            choose(i+1, cnt+1, arr);
            list.remove(list.size()-1);
        }
    }
    
    // list의 원소를 합쳐서 String으로 변환
    public static String listToString() {
        StringBuilder sb = new StringBuilder();
        for (char c : list) sb.append(c);
        return sb.toString();
    }
    
}