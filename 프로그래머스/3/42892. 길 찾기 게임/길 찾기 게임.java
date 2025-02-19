import java.util.*;
class Solution {
    static class Node{
        int x; int y; int v;
        Node left; Node right;
        public Node (int x, int y, int v){
            this.x = x;
            this.y = y;
            this.v = v;
        }
    }
    static ArrayList<Node> nodes = new ArrayList<>();
    static int cnt = 0;
    static int [][] answer; 
    public int[][] solution(int[][] nodeinfo) {
        
        int size = nodeinfo.length;
        
        for(int i = 0; i < size; i++){
            nodes.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1));
        }
        
        // y 크기 내림차순 정렬 -> 레벨(depth) 오름차순 정렬  
        Collections.sort(nodes, (o1, o2) -> {
            return o2.y - o1.y;
        });
        
        Node root = nodes.get(0); // 루트 노드 꺼내기 
        for(int i = 1; i < size; i++){
            update(root, nodes.get(i));
        }
        
        answer = new int [2][size];
        
        pre(root);  // 전위 순회 시작 
        
        cnt = 0;    // cnt 초기화 
        post(root); // 후위 순회 시작 
        
        return answer;
    }
    
    public static void post(Node cur){ // 후위 순회
        if(cur.left != null){
            post(cur.left);
        }
        if(cur.right != null){
            post(cur.right);
        }
        answer[1][cnt++] = cur.v;
    }
    
    public static void pre(Node cur){ // 전위 순회
        answer[0][cnt++] = cur.v;
        if(cur.left != null){
            pre(cur.left);
        }
        if(cur.right != null){
            pre(cur.right);
        }
    }
    
    public static void update(Node parent, Node child){ // 노드 연결
        if(parent.x > child.x){ // 왼쪽
            if(parent.left == null) parent.left = child;
            else update(parent.left, child);
        }
        else{
            if(parent.right == null) parent.right = child;
            else update(parent.right, child);
        }
    }
}
