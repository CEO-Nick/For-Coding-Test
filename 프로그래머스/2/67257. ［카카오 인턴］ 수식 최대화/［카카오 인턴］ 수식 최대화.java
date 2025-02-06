import java.util.*;

class Solution {
    
    static ArrayList<Character> expPriority;
    static LinkedHashSet<Character> expType;
    static Character[] expTypeArr;
    static ArrayList<String> expList;
    
    public long solution(String expression) {
        /*
         * 우선순위 모두 다름
         * 같은 연산자끼리는 앞에 있는 게 우선순위 더 높음
        */
        
        // 1. 연산자 종류 찾아 배열로 만들기
        expType = new LinkedHashSet<>();
        expList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        for (int exp : expression.toCharArray()) {
            if (exp >= 48 && exp <= 57) {
                sb.append((char) exp);
                continue;
            }
            expList.add(sb.toString());
            expType.add((char) exp);
            expList.add(String.valueOf((char) exp));
            
            sb = new StringBuilder();
        }
        expList.add(sb.toString());
        
        // System.out.println("expList : " + expList);
        expTypeArr = expType.toArray(new Character[0]);
        
        // 2. backtracking으로 가능한 모든 우선 순위 만들기
        chosen = new boolean[expTypeArr.length];
        expPriority = new ArrayList<>();
        
        makePriority(0);
        
        return max;
    }
    
    static boolean[] chosen;
    static long max = Long.MIN_VALUE;
    // 모든 우선 순위 조합 만들기
    static void makePriority(int count) {
        if (count == expTypeArr.length) {
            long result = calcExp();
            max = Math.max(max, Math.abs(result));
            return;
        }
        
        for (int i = 0; i < expTypeArr.length; i++) {
            if (chosen[i] == true) continue;
            
            expPriority.add(expTypeArr[i]);
            chosen[i] = true;
            
            makePriority(count + 1); 
            
            expPriority.remove(expPriority.size() - 1);
            chosen[i] = false;
        }
    }
    
    // 정해진 우선순위에 따라 계산하기
    static long calcExp() {
        long result = 0L;
        ArrayDeque<String> stack = new ArrayDeque<>();
        String[] expArray = expList.toArray(new String[0]);
        // System.out.println(expPriority);
        for (int i = 0; i < expPriority.size(); i++) {
            // 계산할 연산자
            String curExp = String.valueOf(expPriority.get(i));
            // System.out.println("curExp : "+curExp);
            // System.out.println("expArray : "+Arrays.toString(expArray));
            
            
            int j = 0;
            while (true) {
                if (j >= expArray.length) break;
                
                if (expArray[j].equals(curExp)) {
                    String before = stack.pollLast();
                    String after = expArray[j+1];
                    j++;
                    long res = calculate(before, after, curExp);
                    stack.add(String.valueOf(res));
                } else {
                    stack.add(expArray[j]);
                    // System.out.println("add to stack : " + stack);
                }
                j++;
            }
            // System.out.println();
            // for (int j = 0; j < expArray.length; j++) {
            //     if (expArray[j].equals(curExp)) {
            //         String before = stack.poll();
            //         String after = expArray[j+1];
            //         j++;
            //         int res = calculate(before, after, curExp);
            //         stack.add(String.valueOf(res));
            //     } else {
            //         stack.add(expArray[j]);
            //     }
            // }
            
            expArray = stack.toArray(new String[0]);
            if (i == expPriority.size()-1) {
                result = Long.parseLong(stack.poll());
            }
            stack.clear();
        }
        return result;
    }
    
    static Long calculate(String num1, String num2, String exp) {
        Long n1 = Long.valueOf(num1);
        Long n2 = Long.valueOf(num2);
        
        if (exp.equals("+")) {
            return n1 + n2;
        } else if (exp.equals("-")) {
            return n1 - n2;
        } else if (exp.equals("*")) {
            return n1 * n2;
        } 
        
        return 1L;
    }
}