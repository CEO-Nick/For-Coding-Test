import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer;
        
        s = s.replace("{", "");

        String[] array = s.split("}");
        List<List<Integer>> doubleList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            String[] split = array[i].split(",");
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < split.length; j++) {
                if (split[j].equals("")) continue;
                list.add(Integer.parseInt(split[j]));
            }
            doubleList.add(list);
        }
        
        doubleList.sort((o1, o2) -> o1.size() - o2.size());
        // doubleList.sort(Comparator.comparingInt(List::size));
        answer = new int[doubleList.get(doubleList.size()-1).size()];
        boolean[] visited = new boolean[100001];
        for (int i = 0; i < doubleList.size(); i++) {
            if (i == 0) {
                answer[i] = doubleList.get(i).get(i);
                visited[answer[i]] = true;
                continue;
            }
            for (int e : doubleList.get(i)) {
                if (visited[e]) continue;
                answer[i] = e;
                visited[e] = true;
            }
        }
        return answer;
    }
}