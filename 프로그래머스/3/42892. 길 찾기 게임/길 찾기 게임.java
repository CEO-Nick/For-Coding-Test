import java.util.*;

class Solution {
    static class Node implements Comparable {
        int idx;
        int x, y;
        Node left, right;
        
        public Node(int idx, int x, int y, Node left, Node right) {
            this.idx = idx;
            this.x = x;
            this.y = y;
            this.left = left;
            this.right = right;
        }
        
        public int compareTo(Object obj) {
            Node n = (Node) obj;
            if (this.y == n.y) {
                return this.x - n.x;
            }
            return n.y - this.y;
        }
        
        @Override
        public String toString() {
           return String.format("Node{idx=%d, x=%d, y=%d, left=%s, right=%s}", 
                               idx, x, y, 
                               left != null ? "Node(" + left.idx + ")" : "null",
                               right != null ? "Node(" + right.idx + ")" : "null");
        }
    }
    
    static ArrayList<Integer> preOrderList;
    static ArrayList<Integer> postOrderList;
    
    public int[][] solution(int[][] nodeinfo) {        
        ArrayList<Node> nodeList = new ArrayList<>();
        for (int i = 0; i < nodeinfo.length; i++) {
            nodeList.add(new Node(i+1, nodeinfo[i][0], nodeinfo[i][1], null, null));
        }
        
        Collections.sort(nodeList);
        
        // 이진 트리 만들기
        Node root = nodeList.get(0);
        for (int i = 1; i < nodeList.size(); i++) {
            Node parent = root;
            Node curNode = nodeList.get(i);
            
            while (true) {
                if (parent.x > curNode.x) {
                    if (parent.left == null) {
                        parent.left = curNode;
                        break;
                    }
                    else parent = parent.left;
                } else {
                    if (parent.right == null) {
                        parent.right = curNode;
                        break;
                    }
                    else parent = parent.right;
                }
            }
        }
        
        preOrderList = new ArrayList<>();
        postOrderList = new ArrayList<>();
        preorder(root);
        postorder(root);
        
        int[][] answer = new int[2][nodeinfo.length];
        answer[0] = preOrderList.stream().mapToInt(Integer::intValue).toArray();
        answer[1] = postOrderList.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
    
    public static void preorder(Node cur) {
        if (cur == null) return;
        
        preOrderList.add(cur.idx);
        preorder(cur.left);
        preorder(cur.right);
    }
    
    public static void postorder(Node cur) {
        if (cur == null) return;
        
        postorder(cur.left);
        postorder(cur.right);
        postOrderList.add(cur.idx);
    }
}