import java.util.*;

class Solution {
    public String solution(int[] numbers) {        
        List<String> list = new ArrayList<>();
        int sum = 0;
        for (int num : numbers) {
            list.add(String.valueOf(num));
            sum += num;
        }
        // numbers 배열이 모두 0인 경우
        if (sum == 0) return "0";
        
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String n1 = o1 + o2;
                String n2 = o2 + o1;
                return n2.compareTo(n1);
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i == 0 && list.get(i).equals("0")) continue;
            sb.append(list.get(i));
        }
        
        return sb.toString();
    }
}