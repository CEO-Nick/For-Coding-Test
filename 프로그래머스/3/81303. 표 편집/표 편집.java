import java.util.*;

class Solution {
    static class Info {
        int idx;
        int left;
        int right;
        
        Info(int idx, int left, int right) {
            this.idx = idx;
            this.left = left;
            this.right = right;
        }
    }
    
    public String solution(int n, int k, String[] command) {
        int[][] linkedList = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            linkedList[i][0] = i-1;
            linkedList[i][1] = i+1;
        }
        linkedList[n-1][1] = -1;
        
        
        Stack<Info> stack = new Stack<>();
        
        for (String cmd : command) {
            if (cmd.startsWith("U")) {
                String[] parts = cmd.split(" ");
                int move = Integer.parseInt(parts[1]);
                for (int i = 0; i < move; i++) {
                    k = linkedList[k][0];
                }
                
            } else if (cmd.startsWith("D")) {
                String[] parts = cmd.split(" ");
                int move = Integer.parseInt(parts[1]);
                for (int i = 0; i < move; i++) {
                    k = linkedList[k][1];
                }
                
            } else if (cmd.equals("C")) {
                int left = linkedList[k][0];
                int right = linkedList[k][1];
                
                stack.push(new Info(k, left, right));

                if (left == -1) {
                    linkedList[right][0] = -1;
                    k = right;
                } else if (right == -1) {
                    linkedList[left][1] = -1;
                    k = left;
                } else {
                    linkedList[left][1] = right;
                    linkedList[right][0] = left;
                    k = right;
                }
            } else {
                Info info = stack.pop();
                if (info.left == -1) {
                    linkedList[info.right][0] = info.idx;
                } else if (info.right == -1) {
                    linkedList[info.left][1] = info.idx;
                } else {
                    linkedList[info.left][1] = info.idx;
                    linkedList[info.right][0] = info.idx;
                }
            }
        }
       
        boolean[] checkList = new boolean[n];
        Arrays.fill(checkList, true);
        for (Info info : stack) {
            checkList[info.idx] = false;
        }

        StringBuilder sb = new StringBuilder();
        for (boolean exist : checkList) {
            if (exist) sb.append("O");
            else sb.append("X");
        }
        return sb.toString();
    }
}