import java.util.*;

class Solution {
    static int[] CARDS;
    static boolean[] visited;
    static List<Integer> groupSizeList;
    
    public int solution(int[] cards) {
        int answer = 0;
        groupSizeList = new ArrayList<>();
        
        CARDS = new int[cards.length + 1];
        for (int i = 0; i < cards.length; i++) {
            CARDS[i+1] = cards[i];
        }
        visited = new boolean[CARDS.length];
        
        for (int i = 1; i < CARDS.length; i++) {
            if (!visited[i]) {
                makeGroup(i);
            }
        }
        Collections.sort(groupSizeList);
        Collections.reverse(groupSizeList);
        // System.out.println(groupSizeList);
        
        //
        if (groupSizeList.size() == 1) return 0;
        
        return groupSizeList.get(0) * groupSizeList.get(1);
    }
    
    // 시작 인덱스 주어지면 그룹 만들기
    public void makeGroup(int idx) {
        int count = 1;
        visited[idx] = true;
        while (!visited[CARDS[idx]]) {
            visited[CARDS[idx]] = true;
            count++;
            idx = CARDS[idx];
        }
        groupSizeList.add(count);
    }
}