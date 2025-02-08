import java.util.*;

class Solution {
    static int N;
    static int R;
    static String[] curInfo;
    static ArrayList<String> list;
    static HashMap<String, List<Integer>> map;
    
    static void combi(int idx, int count) {
        if (count == R) {
            String key = makeKey();
            if (map.containsKey(key)) {
                map.get(key).add(Integer.parseInt(curInfo[4]));
            } else {
                ArrayList<Integer> value = new ArrayList<>();
                value.add(Integer.parseInt(curInfo[4]));
                map.put(key, value);
            }
            return;
        }        
        
        for (int i = idx; i < 4; i++) {
            list.add(curInfo[i]);
            combi(i+1, count+1);
            list.remove(list.size()-1);
        }
    }
    
    static String makeKey() {
        StringBuilder sb = new StringBuilder();
        for (String info : list) sb.append(info);
        
        return sb.toString();
    }
    
    static String makeQueryKey(String[] query) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < query.length - 1; i++) {
            String qa = query[i];
            if (qa.equals("and") || qa.equals("-")) continue;
            sb.append(qa);
        }
        
        return sb.toString();
    }
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        int idx = 0;
        // info에 대해서 가능한 모든 조합 hashmap에 저장하기 (key : javabackendjuniorpizza, value : [150])
        map = new HashMap<>();
        list = new ArrayList<>();
        map.put("", new ArrayList<Integer>());
        
        for (String person : info) {
            curInfo = person.split(" ");
            map.get("").add(Integer.parseInt(curInfo[4]));
            for (int i = 1; i <= 4; i++) {
                R = i;
                combi(0, 0);
            }
        }
        
        for (List<Integer> scores : map.values()) {
            Collections.sort(scores);
        }
        
        String[] keys = null;
        for (String q : query) {
            keys = q.split(" ");
            int target = Integer.parseInt(keys[keys.length - 1]);
            String key = makeQueryKey(keys);
            
            if (map.get(key) == null) {
                System.out.println("null");
                idx++;
                continue;
            }
            
            int count = binarySearch(target, map.get(key));
            // System.out.println(map.get(key) + "\t" + count);
            answer[idx++] = map.get(key).size() - count;
        }
        return answer;
    }
    
    // list에서 target보다 작은 원소의 개수
    static int binarySearch(int target, List<Integer> list) {
        if (list.isEmpty()) return 0;

        int left = 0, right = list.size() - 1;
        while(left<=right) {
            int cur = (left + right) / 2;
            if( list.get(cur) < target ) left = cur + 1;
            if( list.get(cur) >= target ) right = cur - 1;

        }
        
        return left;
        
    }
}